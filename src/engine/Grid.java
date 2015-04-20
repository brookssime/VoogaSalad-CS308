package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import interfaces.Collidable;

public class Grid extends GameObject implements Observable{
	
	private String myName;
	public Tile[][] myTiles;
	//private Map<Collidable, Placement> myCollidables;
	private Map<GridObject, Placement> myGridObjectMap;	
	private Tile myPort;
	// myProjectiles?
	// myEnemies?
	public GridManager myGridManager;
	
	
	public Grid(Grid grid, GridManager gm){
		myName = grid.myName;
		myTiles = grid.myTiles;
		myGridObjectMap = grid.myGridObjectMap;
		myPort = grid.myPort;
		myGridManager = gm;
	}
	
	public Grid(int width, int height){
		myTiles = new Tile[width][height];
		myGridManager = new GridManager(this);
		init();
	}
	
	public Tile[][] getTiles(){
		return myTiles;
	}
	
	public Map<GridObject, Placement> getGridObjectMap(){
		return myGridObjectMap;
	}
	
	private void init(){
		for (int x = 0; x < myTiles.length; x++)
			for (int y = 0; y < myTiles.length; y++){
				myTiles[x][y] = new Tile(x, y);
			}	
	}
	
	public void start(){
		myGridManager.start();
		
	}
	
	public void setWaves(Queue<Wave> waves){
		myGridManager.setWaves(waves);
		
	}
	
	public void update(){
		myGridManager.update();
		myGridManager.checkComplete();
	}
	
	
	
	public void setTiles(Tile[][] tiles){
		myTiles = tiles;
	}
	
	public void placeGridObjectAt(GridObject o, Placement p){
		myGridObjectMap.put(o, p);
	}
	
	
	public void addTile(Tile t, int x, int y){
		myTiles[x][y] = t;
	}
	
	public void setPort(Tile t){
		myPort = t;
	}
	
	public Tile getPort(){
		return myPort;
	}
	
	public Tile getTile(int x, int y){
		return myTiles[x][y];
	}


	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	public boolean isComplete() {
		return myGridManager.isComplete();
	}

	public Tile getPortFor(Wave w) {
		// TODO RETURN THE TILE THAT CORRESPONDS TO THE PORT FOR THIS WAVE
		return null;
	}

	public Queue<Wave> getWaves() {
		return myGridManager.getWaves();
	}
	
	
}
