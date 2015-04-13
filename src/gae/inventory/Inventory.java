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

import java.awt.event.ActionEvent;

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
	private ObservableMap<String, Effect> myEffects;
	private ObservableMap<String, Range> myRanges;
	private ObservableMap<String, Store> myStores;
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
		myEffects = FXCollections.observableHashMap();
		myRanges = FXCollections.observableHashMap();
		myStores = FXCollections.observableHashMap();
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
			e1.printStackTrace();
		}
		Authorable newThing = (Authorable) Reflection.createInstance("engine."+type);
		newThing.setName("New"+type);
		map.put(newThing.getName(), newThing);
	}

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
