package engine;

import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import interfaces.Collidable;

public class Grid {
	
	public Tile[][] myTiles;
	private List<Collidable> myCollidables;
	// myProjectiles?
	// myEnemies?
	private GridManager myGridManager;
	
	
	public Grid(int width, int height){
		myTiles = new Tile[width][height];
		myGridManager = new GridManager(this);
	}
	
	private void init(){
		
		
	}
	
	
	public void addTile(Tile t, int x, int y){
		myTiles[x][y] = t;
	}
	
	public Tile getPort(){
		// TODO: implement this
		return null;
	}
	
	public Tile getTile(int x, int y){
		return myTiles[x][y];
	}
	
	public void spawn(Collidable c){
		
		// TODO
	}
	
	public ObservableList<Collidable> getObjects(){
		return FXCollections.observableList(myCollidables);
	}
	
	
}
