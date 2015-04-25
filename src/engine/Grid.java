package engine;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import engine.gameLogic.GameObject;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Sprite;
import engine.sprites.Tile;

/**
 * The Class Grid.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class Grid extends GameObject implements Observable{


	/** The my name. */
	private String myName;

	/** The my tiles. */
	public Tile[][] myTiles;

	/** The my grid manager. */
	private GridManager myGridManager;
	private Map<Sprite, Placement> mySpriteMap;	
	private List<Tile> myPorts;
	

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
	 * Instantiates a grid that connects to the gridmanager
	 */
	public Grid(Grid grid, GridManager gm){
		myName = grid.myName;
		myTiles = grid.myTiles;
		mySpriteMap = grid.mySpriteMap;
		myPorts = grid.myPorts;
		myGridManager = gm;
	}
	public Tile[][] getTiles(){
		return myTiles;
	}

	public Map<Sprite, Placement> getSpriteMap(){
		return mySpriteMap;
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
		//myGridManager.checkComplete();
	}

	public void setTiles(Tile[][] tiles){
		myTiles = tiles;
	}

	public void placeSpriteAt(Sprite sprite, Placement spritePlacement){
		mySpriteMap.put(sprite, spritePlacement);
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
	 * Sets the port.
	 *
	 *
	 */
	public void setPort(List<Tile> t){
		myPorts = t;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public List<Tile> getPort(){
		return myPorts;
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
		Placement p = new Placement();
		for(Sprite o : mySpriteMap.keySet()){
			if(o.getName().equals(w.getPortName()))
					p = mySpriteMap.get(o);	
		}
		
		return getTileForPlacement(p);
	}
	
	private Tile getTileForPlacement(Placement p){
		return myTiles[(int) Math.floor(p.getLocation().getX())][(int) Math.floor(p.getLocation().getY())];
	}

	public Queue<Wave> getWaves() {
		return myGridManager.getWaves();
	}
}