/*
 * 
 */
package gae.inventory;

import gae.inventorypane.UpdateListener;
import interfaces.Authorable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import reflection.Reflection;
import engine.Base;
import engine.DialogueScene;
import engine.Effect;
import engine.Game;
import engine.Grid;
import engine.LevelScene;
import engine.Port;
import engine.Projectile;
import engine.Range;
import engine.Store;
import engine.TitleScene;
import engine.Tower;
import engine.Enemy;
import engine.Tile;
import engine.Wave;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;


// TODO: Auto-generated Javadoc
/**
 * The Class Inventory.

 * 
 * @author Peter
 * This class holds the inventory. It allows the the frontend to addObjects, Update Objects, and remove Objects
 * from the inventory. The inventory contains all the game objects.
 *
 */
public class Inventory {

	/** The my games. */
	private ObservableMap<String, Game> myGames;
	
	/** The my level scenes. */
	private ObservableMap<String, LevelScene> myLevelScenes;
	
	/** The my dialogue scenes. */
	private ObservableMap<String, DialogueScene> myDialogueScenes;
	
	/** The my title scenes. */
	private ObservableMap<String, TitleScene> myTitleScenes;
	
	/** The my bases. */
	private ObservableMap<String, Base> myBases;
	
	/** The my projectiles. */
	private ObservableMap<String, Projectile> myProjectiles;
	
	/** The my grids. */
	private ObservableMap<String, Grid> myGrids;
	
	/** The my waves. */
	private ObservableMap<String, Wave> myWaves;
	
	/** The my ports. */
	private ObservableMap<String, Port> myPorts;
	
	/** The my enemys. */
	private ObservableMap<String, Enemy> myEnemys;
	
	/** The my towers. */
	private ObservableMap<String, Tower> myTowers;
	
	/** The my tiles. */
	private ObservableMap<String, Tile> myTiles;
	
	/** The my effect. */
	private ObservableMap<String, Effect> myEffects;
	
	/** The my range. */
	private ObservableMap<String, Range> myRanges;
	
	/** The my store. */
	private ObservableMap<String, Store> myStores;
	
	/** The Constant TYPES. */
	private static final String[] TYPES = { "Game", "LevelScene",
			"DialogueScene", "TitleScene", "Base", "Projectile", "Grid",
			"Wave", "Port", "Enemy", "Tower", "Tile", "Effect", "Range",
			"Store" };

	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		myGames = FXCollections.observableHashMap();
		myLevelScenes = FXCollections.observableHashMap();
		myDialogueScenes = FXCollections.observableHashMap();
		myTitleScenes = FXCollections.observableHashMap();
		myBases = FXCollections.observableHashMap();
		myProjectiles = FXCollections.observableHashMap();
		myGrids = FXCollections.observableHashMap();
		myWaves = FXCollections.observableHashMap();
		myPorts = FXCollections.observableHashMap();
		myEnemys = FXCollections.observableHashMap();
		myTowers = FXCollections.observableHashMap();
		myTiles = FXCollections.observableHashMap();
		myEffects = FXCollections.observableHashMap();
		myRanges = FXCollections.observableHashMap();
		myStores = FXCollections.observableHashMap();
		// setNews();
	}

	// method for testing
	/**
	 * Sets the news.
	 */
	private void setNews() {
		for (String type : TYPES) {
			addObject(type);
		}
	}

	/**
	 * Adds the object.
	 *
	 * @param type the type
	 */
	public void addObject(String type) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = null;
		try {
			map = (ObservableMap<String, Authorable>) this.getClass()
					.getDeclaredField(mapString).get(this);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}
		Authorable newThing = (Authorable) Reflection.createInstance("engine."+type);
		newThing.setName("New"+type);
		map.put(newThing.getName(), newThing);
	}

	/**
	 * Update object.
	 *
	 * @param type the type
	 * @param obj the obj
	 * @param params the params
	 */
	public void updateObject(String type, String obj, List<Object> params) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = null;
		try {
			map = (ObservableMap<String, Authorable>) this.getClass()
					.getDeclaredField(mapString).get(this);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}
		Authorable oldE = map.get(obj);
		oldE.updateParams(params);
		map.put(oldE.getName(), oldE);
	}
	
	public Authorable getObject(String type, String obj) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = null;
		try {
			map = (ObservableMap<String, Authorable>) this.getClass()
					.getDeclaredField(mapString).get(this);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}
		Authorable object = map.get(obj);
		return object;
	}

	/**
	 * Removes the object.
	 *
	 * @param type the type
	 * @param obj the obj
	 */
	public void removeObject(String type, String obj) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = null;
		try {
			map = (ObservableMap<String, Authorable>) this.getClass()
					.getDeclaredField(mapString).get(this);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}
		map.remove(obj);
	}
	
	public Set<String> getList(String type) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = null;
		try {
			map = (ObservableMap<String, Authorable>) this.getClass()
					.getDeclaredField(mapString).get(this);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}
		return map.keySet();
	}

	/**
	 * Sets the bind.
	 *
	 * @param type the type
	 * @param property the property
	 */
	public void setListener(String type,
			UpdateListener ul) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = null;
		try {
			map = (ObservableMap<String, Authorable>) this.getClass()
					.getDeclaredField(mapString).get(this);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}
		map.addListener(new MapChangeListener() {

			@Override
			public void onChanged(Change arg0) {
//				ul.setUpdate(FXCollections.observableArrayList(map.keySet()));
				ul.run();
			}
			
		});
	}

}
