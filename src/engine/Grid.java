package engine;

import java.util.ArrayList;
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
	private Tile myPort;
	// myProjectiles?
	// myEnemies?
<<<<<<< HEAD
	/** The my grid manager. */
	private GridManager myGridManager;
=======
	public GridManager myGridManager;
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
	
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
		init();
	}
	
	/**
	 * Inits the.
	 */
	private void init(){
		for (int x = 0; x < myTiles.length; x++)
			for (int y = 0; y < myTiles.length; y++){
				myTiles[x][y] = new Tile(x, y);
			}	
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
	
<<<<<<< HEAD
	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
=======
	public void setPort(Tile t){
		myPort = t;
	}
	
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
	public Tile getPort(){
		return myPort;
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
	
<<<<<<< HEAD
	/**
	 * Spawn.
	 *
	 * @param c the c
	 */
=======
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
	
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
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
