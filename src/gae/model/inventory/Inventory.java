/*
 * 
 */
package gae.model.inventory;

import exceptions.ObjectDoesntExistException;
import gae.view.inventorypane.UpdateListener;
import engine.gameLogic.GameObject;
import engine.gameScreens.NodeButton;
import engine.gameScreens.TitleScene;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import reflection.Reflection;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

/**
 * The Class Inventory.
 * 
 * 
 * @author Peter This class holds the inventory. It allows the the frontend to
 *         addObjects, Update Objects, and remove Objects from the inventory.
 *         The inventory contains all the game objects.
 *
 */
public class Inventory {

	private Map<String, ObservableMap<String, GameObject>> myMaps;

	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		myMaps = new HashMap<String, ObservableMap<String, GameObject>>();
	}

	public void addMap(String type) {
		ObservableMap<String, GameObject> map = FXCollections
				.observableHashMap();
		myMaps.put(type, map);
	}

	private ObservableMap<String, GameObject> getMap(String obj) {

		for (ObservableMap<String, GameObject> map : myMaps.values()) {
			if (map.containsKey(obj)) {
				return map;
			}
		}
		try {
			throw new ObjectDoesntExistException();
		} catch (ObjectDoesntExistException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Adds the object.
	 *
	 * @param type
	 *            the type
	 */
	public void addObject(String type, String location) {
		ObservableMap<String, GameObject> map = myMaps.get(type);
		// TODO only addes engine.sprites classes. needs to expand.
		GameObject newThing = (GameObject) Reflection.createInstance("engine."
				+ location + type);
		String newName = "New" + type;
		int vrsNum = 0;
		while (map.containsKey(newName)) {
			vrsNum++;
			newName = "New" + type + vrsNum;
		}
		newThing.setName(newName);
		map.put(newThing.getName(), newThing);
	}

	/**
	 * Update object.
	 * 
	 * @param obj
	 *            the obj
	 * @param params
	 *            the params
	 */
	public void runOnObject(String obj, Method method, Object... params) {
		ObservableMap<String, GameObject> map = getMap(obj);
		GameObject object = map.get(obj);
		try {
			method.invoke(object, params);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		if (object.getName().equals(obj)) {
			map.put(obj, object);
		} else {
			map.remove(obj);
			map.put(object.getName(), object);
		}
	}
	
	public void runOnObjectSwap(String obj, Method method, Object... params) {
		Object[] newparams = new Object[params.length];
		for (int i = 0; i < params.length; i++) {
			String str = params[i].toString();
			newparams[i] = getObject(str);
		}
		runOnObject(obj, method, newparams);
	}
	
	public boolean isInvObject(String type) {
		for (String key : myMaps.keySet()) {
			if (type.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Method> getEditorMethods(String obj) {
		ObservableMap<String, GameObject> map = getMap(obj);
		GameObject object = map.get(obj);
		return new ArrayList<Method>(Reflection.getEditorMethods(object));
	}

	public Object getFromObject(String obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException,
			ClassNotFoundException {
		ObservableMap<String, GameObject> map = getMap(obj);
		GameObject object = map.get(obj);

		Object returnValue = null;
		Field field = grabField(obj, fieldName);

		if (field != null) {
			field.setAccessible(true);
			returnValue = field.get(object);
		}

		return returnValue;
		/*
		 * ObservableMap<String, GameObject> map = getMap(obj); GameObject
		 * object = map.get(obj); Object ret; try { ret = method.invoke(object,
		 * params); } catch (IllegalAccessException | IllegalArgumentException |
		 * InvocationTargetException e) { e.printStackTrace(); ret = null; }
		 * System.out.println(ret); return ret;
		 */
	}
	
	public List<NodeButton> getButtonList(String obj) {
		if (!getType(obj).equals("TitleScene")) {
			try {
				throw new ObjectDoesntExistException();
			} catch (ObjectDoesntExistException e) {
				e.printStackTrace();
				return null;
			}
		}
		ObservableMap<String, GameObject> map = getMap(obj);
		GameObject object = map.get(obj);
		TitleScene titlescene = (TitleScene) object;
		return titlescene.getButtons();
	}

	public GameObject getObject(String obj) {
		ObservableMap<String, GameObject> map = getMap(obj);
		GameObject object = map.get(obj);
		return object;
	}

	/**
	 * Removes the object.
	 * 
	 * @param obj
	 *            the obj
	 */
	public void removeObject(String obj) {
		ObservableMap<String, GameObject> map = getMap(obj);
		map.remove(obj);
	}

	public String getType(String obj) {
		for (String type : myMaps.keySet()) {
			if (myMaps.get(type).containsKey(obj)) {
				return type;
			}
		}
		try {
			throw new ObjectDoesntExistException();
		} catch (ObjectDoesntExistException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Set<String> getList(String type) {
		ObservableMap<String, GameObject> map = myMaps.get(type);
		return map.keySet();
	}

	/**
	 * Sets the listener.
	 *
	 * @param type
	 *            the type
	 * @param ul
	 *            the listener
	 */
	public void setListener(String type, UpdateListener ul) {
		ObservableMap<String, GameObject> map = myMaps.get(type);
		Set<String> update = map.keySet();
		map.addListener(new MapChangeListener<String, GameObject>() {

			@Override
			public void onChanged(
					Change<? extends String, ? extends GameObject> arg0) {
				ul.setUpdate(FXCollections.observableArrayList(update));
				ul.run();
			}

		});
	}

	private Field grabField(Class<?> objClass, String fieldName)
			throws ClassNotFoundException {
		Field field = null;
		try {
			field = objClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			Class<?> parent = objClass.getSuperclass();
			if (parent != null) {
				try {
					field = grabField(parent, fieldName);
				} catch (SecurityException e1) {
					System.out.println("Failed to fetch field:  " + fieldName);
				}
			}
		}

		return field;
	}

	private Field grabField(String objname, String fieldName)
			throws ClassNotFoundException {
		// TODO only works for sprites folder. make it work to all engine
		// classes.
		Class<?> objClass = Class.forName("engine.sprites." + getType(objname));
		return grabField(objClass, fieldName);
	}

}
