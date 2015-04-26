/*
 * 
 */
package gae.model.inventory;

import exceptions.ObjectDoesntExistException;
import gae.view.inventorypane.UpdateListener;
import engine.gameLogic.GameObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
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

	/** The Constant TYPES. */
	private static final String[] TYPES = { "Game", "LevelScene",
			"DialogueScene", "TitleScene", "Base", "Projectile", "Grid",
			"Wave", "Port", "Enemy", "Tower", "Tile", "Effect", "Range",
			"Store" };

	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		myMaps = new HashMap<String, ObservableMap<String, GameObject>>();
		for (String type : TYPES) {
			ObservableMap<String, GameObject> map = FXCollections
					.observableHashMap();
			myMaps.put(type, map);
		}
	}

	private ObservableMap<String, GameObject> getMap(String obj) {
		
		for (String type : TYPES) {
			if (myMaps.get(type).containsKey(obj)) {
				return myMaps.get(type);
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
	public void addObject(String type) {
		ObservableMap<String, GameObject> map = myMaps.get(type);
		//TODO only addes engine.sprites classes. needs to expand.
		GameObject newThing = (GameObject) Reflection.createInstance("engine.sprites."
				+ type);
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

	public Object getFromObject(String obj, String fieldName) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
		ObservableMap<String, GameObject> map = getMap(obj);
		GameObject object = map.get(obj);
		
		Object returnValue = null;
		Field field = grabField(obj, fieldName);
		
		if (field!=null){
			field.setAccessible(true);
			returnValue = field.get(object);
		}
		
		return returnValue;
		/*
		ObservableMap<String, GameObject> map = getMap(obj);
		GameObject object = map.get(obj);
		Object ret;
		try {
			ret = method.invoke(object, params);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			ret = null;
		}
		System.out.println(ret);
		return ret;
		*/
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
		for (String type : TYPES) {
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
	
	private Field grabField(Class<?> objClass, String fieldName) throws ClassNotFoundException{
		Field field = null;
		try {
			field = objClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			Class<?> parent = objClass.getSuperclass();
			if (parent!=null){
				try {
					field = grabField(parent, fieldName);
				} catch (SecurityException e1) {
					System.out.println("Failed to fetch field:  "+fieldName);
				}
			}
		}
		
		return field;
	}
	
	private Field grabField(String objname, String fieldName) throws ClassNotFoundException{
		//TODO only works for sprites folder. make it work to all engine classes. 
		Class<?> objClass = Class.forName("engine.sprites."+getType(objname));
		return grabField(objClass, fieldName);
	}
	

}
