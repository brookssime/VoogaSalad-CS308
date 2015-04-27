package engine;

import interfaces.Collidable;

import java.awt.Point;
import java.util.Map;
import java.util.Queue;

import engine.gameLogic.GameObject;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Sprite;
import engine.sprites.Tile;

public class Grid extends GameObject{

	private String myName;
	public Tile[][] myTiles;
	private GridManager myGridManager;
	private Map<Sprite, Placement> mySpriteMap;	
	//private List<Tile> myPorts;
	//private Map<String, Sprite> mySpriteNames; //
	
	public Grid(int width, int height){
		myTiles = new Tile[width][height];
		myGridManager = new GridManager(this);
		init();
	}

	public Grid(Grid grid, GridManager gm){
		myName = grid.myName;
		myTiles = grid.myTiles;
		mySpriteMap = grid.mySpriteMap;
		myGridManager = gm;
	}
	
	public Tile[][] getTiles(){
		return myTiles;
	}

	public int getBaseHealth(){
		return myGridManager.calculateBaseHealth();
	}
	public void moveSprite(Sprite s, Placement p){
		mySpriteMap.put(s, p);
	}
	
	public void refreshHeadings(){
		for(Sprite s : mySpriteMap.keySet()){
			mySpriteMap.get(s).normalize();
		}
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
		refreshHeadings();
		myGridManager.update();
		//myGridManager.checkComplete();
	}

	public void setTiles(Tile[][] tiles){
		myTiles = tiles;
		initTiles();
	}
	
	private void initTiles(){
		 
		
		// adjust Tile y locations such that (0,0) is bottom right
		for (int x = 0; x < myTiles.length; x++)
			for(int i = 0; i < myTiles[0].length / 2; i++)
			{
				Tile temp = myTiles[x][i];
				myTiles[x][i] = myTiles[x][myTiles.length - i - 1];
				myTiles[x][myTiles.length - i - 1] = temp;
			}
		
		
		// clone Tiles and set their locations
		for (int x = 0; x < myTiles.length; x++)
			for (int y = 0; y < myTiles[0].length; y++){
				myTiles[x][y] = myTiles[x][y].clone();
				myTiles[x][y].setGridLocation(new Point(x,y));
			}
		
		
	}

	public void placeSpriteAt(Sprite sprite, Placement spritePlacement){
		mySpriteMap.put(sprite, spritePlacement);
	}
	
	public void removeSpriteAt(Sprite sprite, Placement spritePlacement){
		mySpriteMap.remove(sprite, spritePlacement);
	}
	
	public void addTile(Tile t, int x, int y){
		myTiles[x][y] = t;
	}

	public Tile getTile(int x, int y){
		return myTiles[x][y];
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
	
	public void move(Sprite sprite, Placement move) {
		mySpriteMap.put(sprite, move);
		
	}
	
	public void placeSpriteIDAt(String SpriteID, Placement p){
		
	}
	
	//maybe we'll need this idk
//	public Sprite getSpritefromPlacement (Placement p){
//		for (Sprite mySprite : mySpriteMap.keySet()){
//			if (mySpriteMap.get(mySprite).equals(p))
//				return mySprite;
//		}
//		return null;
//	}
	
	public Placement getPlacement(Collidable s){
		return mySpriteMap.get(s);
	}
}