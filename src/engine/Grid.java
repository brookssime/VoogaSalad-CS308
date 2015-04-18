package engine;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import interfaces.Authorable;
import interfaces.Collidable;

public class Grid implements Authorable{
	
	private String myName;
	public Tile[][] myTiles;
	private Map<Collidable, Point> myCollidables;
	private Map<GridObject, Point> myGridObjectMap;
	
	private Tile myPort;
	// myProjectiles?
	// myEnemies?
	public GridManager myGridManager;
	
	public Grid(){
		
	}
	
	public Grid(int width, int height){
		myTiles = new Tile[width][height];
		myGridManager = new GridManager(this);
		init();
	}
	
	private void init(){
		for (int x = 0; x < myTiles.length; x++)
			for (int y = 0; y < myTiles.length; y++){
				myTiles[x][y] = new Tile(x, y);
			}	
	}
	
	public void setTiles(Tile[][] tiles){
		myTiles = tiles;
	}
	
	public void placeGridObjectAt(GridObject o, Point p){
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
	
	public List<Tile> getTileNeighbors(Tile t){
		if (t == null)
			System.out.println("Grid.getTileNeighbors called with null Tile");
		int x = t.getX();
		int y = t.getY();
		List<Tile> neighbors = new ArrayList<Tile>();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		//System.out.println("Neighbors added: ");
		
		for (int i = 0; i < dx.length; i++){
			if(x + dx[i] < myTiles.length && 
					x + dx[i] >= 0 &&
					y + dy[i] < myTiles[0].length &&
					y + dy[i] >= 0){
				Tile temp = (myTiles[x + dx[i]][y + dy[i]]);
				neighbors.add(temp);
				//System.out.println(temp.getX() + ", " + temp.getY());
				
			}
		}
		
		/*neighbors.add(myTiles[x-1][y]);
		neighbors.add(myTiles[x+1][y]);
		neighbors.add(myTiles[x][y-1]);
		neighbors.add(myTiles[x][y+1]);
		//TODO
		*/
		
		return neighbors;
	}
	
	public void spawn(Collidable c){
		
		// TODO
	}
	
	public ObservableList<Collidable> getObjects(){
		return FXCollections.observableList((List<Collidable>) myCollidables.keySet());
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
