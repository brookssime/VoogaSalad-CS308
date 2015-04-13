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

/**
 * 
 * @author Peter
 * This class holds the inventory. It allows the the frontend to addObjects, Update Objects, and remove Objects
 * from the inventory. The inventory contains all the game objects.
 *
 */
public class Inventory {

	private ObservableMap<String, Game> myGames;
	private ObservableMap<String, LevelScene> myLevelScenes;
	private ObservableMap<String, DialogueScene> myDialogueScenes;
	private ObservableMap<String, TitleScene> myTitleScenes;
	private ObservableMap<String, Base> myBases;
	private ObservableMap<String, Projectile> myProjectiles;
	private ObservableMap<String, Grid> myGrids;
	private ObservableMap<String, Wave> myWaves;
	private ObservableMap<String, Port> myPorts;
	private ObservableMap<String, Enemy> myEnemys;
	private ObservableMap<String, Tower> myTowers;
	private ObservableMap<String, Tile> myTiles;
	private ObservableMap<String, Effect> myEffect;
	private ObservableMap<String, Range> myRange;
	private ObservableMap<String, Store> myStore;
	private static final String[] TYPES = { "Game", "LevelScene",
			"DialogueScene", "TitleScene", "Base", "Projectile", "Grid",
			"Wave", "Port", "Enemy", "Tower", "Tile", "Effect", "Range",
			"Store" };

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
	private void setNews() {
		for (String type : TYPES) {
			addObject(type);
		}
	}

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

	public void updateObject(String type, String obj, List<Object> params) {
		String mapString = "my" + type + "s";
		Authorable oldE = ((ObservableMap<String, Authorable>) Reflection
				.getFieldValue(this, mapString)).get(obj);
		oldE.updateParams(params);
		((ObservableMap<String, Authorable>) Reflection.getFieldValue(this,
				mapString)).put(oldE.getName(), oldE);
	}

	public void removeObject(String type, String obj) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = (ObservableMap<String, Authorable>) Reflection
				.getFieldValue(this, mapString);
		map.remove(obj);
	}

	public void setBind(String type,
			ObjectProperty<ObservableList<String>> property) {
		String mapString = "my" + type + "s";
		ObservableMap<String, Authorable> map = (ObservableMap<String, Authorable>) Reflection
				.getFieldValue(this, mapString);
		property.set(FXCollections.observableArrayList(map.keySet()));
	}

}
