/*
 * 
 */
package gae.inventory;

import interfaces.Authorable;

import java.util.List;
import java.util.Map;

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
	private ObservableMap<String, Effect> myEffect;
	
	/** The my range. */
	private ObservableMap<String, Range> myRange;
	
	/** The my store. */
	private ObservableMap<String, Store> myStore;
	
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
		myEffect = FXCollections.observableHashMap();
		myRange = FXCollections.observableHashMap();
		myStore = FXCollections.observableHashMap();
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Authorable newThing = (Authorable) Reflection.createInstance("engine."+type);
		newThing.setName("New"+type);
		map.put(newThing.getName(), newThing);
		System.out.println(newThing.getName());
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
		Authorable oldE = ((ObservableMap<String, Authorable>) Reflection
				.getFieldValue(this, mapString)).get(obj);
		oldE.updateParams(params);
		((ObservableMap<String, Authorable>) Reflection.getFieldValue(this,
				mapString)).put(oldE.getName(), oldE);
	}

	/**
	 * Removes the object.
	 *
	 * @param type the type
	 * @param obj the obj
	 */
	public void removeObject(String type, String obj) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = (ObservableMap<String, Authorable>) Reflection
				.getFieldValue(this, mapString);
		map.remove(obj);
	}

	/**
	 * Sets the bind.
	 *
	 * @param type the type
	 * @param property the property
	 */
	public void setBind(String type,
			ObjectProperty<ObservableList<String>> property) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = (ObservableMap<String, Authorable>) Reflection
				.getFieldValue(this, mapString);
		property.set(FXCollections.observableArrayList(map.keySet()));
	}

}
