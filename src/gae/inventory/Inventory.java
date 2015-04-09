package gae.inventory;

import engine.Tower;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Inventory {
	
//	private Map<String, Enemy> myEnemies;
	private ObservableMap<String, Tower> myTowers;
//	private Map<String, Tile> myTiles;
	
	public Inventory() {
//		myEnemies = FXCollections.observableHashMap();
		myTowers = FXCollections.observableHashMap();
//		myTiles = FXCollections.observableHashMap();
	}
	
//	public void addEnemy(Enemy newEnemy) {
//		myEnemies.put(newEnemy.getName(), newEnemy);
//	}
	
//	public void updateEnemy(String name, Enemy enemy) {
//		myEnemies.put(name, enemy);
//	}
	
//	public ObservableList<String> getEnemies() {
//		return myEnemies.keySet();
//	}
		
	public void addTower(Tower newTower) {
		myTowers.put(newTower.getName(), newTower);
	}
	
	public void updateTower(String name, Tower tower) {
		myTowers.put(name, tower);
	}
	
	public ObservableList<String> getTowers() {
		return FXCollections.observableArrayList(myTowers.keySet());
	}
	
	public void addTowerListener(MapChangeListener<String, Tower> listener) {
		myTowers.addListener(listener);
	}
	
	public Tower getTower(String name) {
		return myTowers.get(name);
	}

//	public void addTile(Tile newTile) {
//		myTiles.put(newTile.getName(), newTile);
//	}
	
//	public void updateTile(String name, Tile tile) {
//		myTiles.put(name, tile);
//	}


}
