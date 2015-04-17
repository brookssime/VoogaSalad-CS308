package engine;

import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import interfaces.Authorable;
import interfaces.Collidable;

// TODO: Auto-generated Javadoc
/**
 * The Class Grid.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class Grid implements Authorable{
	
	/** The my name. */
	private String myName;
	
	/** The my tiles. */
	public Tile[][] myTiles;
	
	/** The my collidables. */
	private List<Collidable> myCollidables;
	// myProjectiles?
	// myEnemies?
	/** The my grid manager. */
	private GridManager myGridManager;
	
	/**
	 * Instantiates a new grid.
	 */
	public Grid(){
		
	}
	
	/**
	 * Instantiates a new grid.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public Grid(int width, int height){
		myTiles = new Tile[width][height];
		myGridManager = new GridManager(this);
	}
	
	/**
	 * Inits the.
	 */
	private void init(){
		
		
	}
	
	
	/**
	 * Adds the tile.
	 *
	 * @param t the t
	 * @param x the x
	 * @param y the y
	 */
	public void addTile(Tile t, int x, int y){
		myTiles[x][y] = t;
	}
	
	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public Tile getPort(){
		// TODO: implement this
		return null;
	}
	
	/**
	 * Gets the tile.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the tile
	 */
	public Tile getTile(int x, int y){
		return myTiles[x][y];
	}
	
	/**
	 * Spawn.
	 *
	 * @param c the c
	 */
	public void spawn(Collidable c){
		
		// TODO
	}
	
	/**
	 * Gets the objects.
	 *
	 * @return the objects
	 */
	public ObservableList<Collidable> getObjects(){
		return FXCollections.observableList(myCollidables);
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
	
	
}
