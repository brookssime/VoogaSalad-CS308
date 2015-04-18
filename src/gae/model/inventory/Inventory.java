/*
 * 
 */
package gae.model.inventory;

import exceptions.ObjectDoesntExistException;
import gae.view.inventorypane.UpdateListener;
import interfaces.Authorable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import reflection.Reflection;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

// TODO: Auto-generated Javadoc
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

	private Map<String, ObservableMap<String, Authorable>> myMaps;

	/** The Constant TYPES. */
	private static final String[] TYPES = { "Game", "LevelScene",
			"DialogueScene", "TitleScene", "Base", "Projectile", "Grid",
			"Wave", "Port", "Enemy", "Tower", "Tile", "Effect", "Range",
			"Store" };

	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		myMaps = new HashMap<String, ObservableMap<String, Authorable>>();
		for (String type : TYPES) {
			ObservableMap<String, Authorable> map = FXCollections
					.observableHashMap();
			myMaps.put(type, map);
		}
	}
	
	private ObservableMap<String, Authorable> getMap(String obj) {
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
		ObservableMap<String, Authorable> map = myMaps.get(type);
		Authorable newThing = (Authorable) Reflection.createInstance("engine."
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
	 * @param obj
	 *            the obj
	 * @param params
	 *            the params
	 */
	public void runOnObject(String obj, Method method, Object...params) {
		ObservableMap<String, Authorable> map = getMap(obj);
		Authorable object = map.get(obj);
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
	
	public Object getFromObject(String obj, Method method, Object...params) {
		ObservableMap<String, Authorable> map = getMap(obj);
		Authorable object = map.get(obj);
		Object ret;
		try {
			ret = method.invoke(object, params);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			ret = null;
		}
		return ret;
	}

	public Authorable getObject(String type, String obj) {
		ObservableMap<String, Authorable> map = myMaps.get(type);
		Authorable object = map.get(obj);
		return object;
	}

	/**
	 * Removes the object.
	 * @param obj
	 *            the obj
	 */
	public void removeObject(String obj) {
		ObservableMap<String, Authorable> map = getMap(obj);
		map.remove(obj);
	}

	public Set<String> getList(String type) {
		ObservableMap<String, Authorable> map = myMaps.get(type);
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
		ObservableMap<String, Authorable> map = myMaps.get(type);
		Set<String> update = map.keySet();
		map.addListener(new MapChangeListener<String, Authorable>() {

			@Override
			public void onChanged(
					Change<? extends String, ? extends Authorable> arg0) {
				ul.setUpdate(FXCollections.observableArrayList(update));
				ul.run();
			}

		});
	}

}
