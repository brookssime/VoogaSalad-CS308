package engine;

import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import interfaces.Authorable;
import interfaces.Collidable;

public class Grid implements Authorable{
	
	private String myName;
	public Tile[][] myTiles;
	private List<Collidable> myCollidables;
	// myProjectiles?
	// myEnemies?
	private GridManager myGridManager;
	
	public Grid(){
		
	}
	
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

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
	
	
}
