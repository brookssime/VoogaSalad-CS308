package engine;

import interfaces.Collidable;
import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import engine.gameLogic.GameObject;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Sprite;
import engine.sprites.Tile;

public class Grid extends GameObject{

	private int myHeight;
	private int myWidth;
	public Tile[][] myTiles;
	private GridManager myGridManager;
	private Map<Sprite, Placement> mySpriteMap;	
	
	public Grid(){
		myTiles = new Tile[myWidth][myHeight];
		myGridManager = new GridManager(this);
		init();
	}

	public Grid(Grid grid, GridManager gm){
		myName = grid.myName;
		myTiles = grid.myTiles;
		mySpriteMap = grid.mySpriteMap;
		myGridManager = gm;
	}
	
	/********Called by GAE**********/
	
	@MethodAnnotation(editor=true, name = "Grid Editor", type = "grid", fieldName = "")
	public void fakeMethod() {
		return;
	}
	
	@SpecialEditorAnnotation(specialeditor = true, name = "Set Height", fieldName = "myHeight")
	public void setHeight(int height) {
		myHeight = height;
	}
	
	@SpecialEditorAnnotation(specialeditor = true, name = "Set Width", fieldName = "myWidth")
	public void setWidth(int width) {
		myWidth = width;
	}
	
	@SpecialEditorAnnotation(specialeditor = true, name = "Set Waves", fieldName = "myGridManager.getWaves()")
	public void setWaves(Queue<Wave> waves){
		myGridManager.setWaves(waves);
	}

	@SpecialEditorAnnotation(specialeditor=true, name="Set Tiles", fieldName="myTiles")
	public void setTiles(Tile[][] tiles){
		myTiles = tiles;
		initTiles();
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Sprite", fieldName="mySpriteMap")
	public void setSprite(Sprite sprite, Point point) {
		mySpriteMap.put(sprite, new Placement(point));
	}


	/*******Called by Condition classes********/ // REVIEW Condition / Grid / LevelNode access
	
	public int getBaseHealth(){
		return myGridManager.calculateBaseHealth();
	}
	
	public Queue<Wave> getWaves() {
		return myGridManager.getWaves();
	}
	
	
	/******Called by Player and GridManager*********/
	
	public Map<Sprite, Placement> getSpriteMap(){
		return mySpriteMap;
	}

	
	/********Helpers********/
	
	private void init(){
		for (int x = 0; x < myTiles.length; x++)
			for (int y = 0; y < myTiles.length; y++){
				myTiles[x][y] = new Tile(x, y);
			}	
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
	
	private void refreshHeadings(){
		for(Sprite s : mySpriteMap.keySet()){
			mySpriteMap.get(s).normalize();
		}
	}
	
	
	/*********Called by LevelNode*******/
	
	public void update(){
		refreshHeadings();
		myGridManager.update();
		//myGridManager.checkComplete();
	}
	
	public void placeSpriteAt(Sprite sprite, Placement spritePlacement){
		mySpriteMap.put(sprite, spritePlacement);
	}
	
	public void removeSpriteAt(Sprite sprite, Placement spritePlacement){
		mySpriteMap.remove(sprite, spritePlacement);
	}

	/*******Called by PathFinder***********/

	public Tile getPortFor(Wave w) {
		Placement p = new Placement();
		for(Sprite o : mySpriteMap.keySet()){
			if(o.getName().equals(w.getPortName()))
					p = mySpriteMap.get(o);	
		}
		
		return myTiles[(int) Math.floor(p.getLocation().getX())][(int) Math.floor(p.getLocation().getY())]; 
		// REVIEW: this might cause errors because Tile's array location will NOT be related to each object's location
	}

	public List<Tile> getTileNeighbors(Tile t) {
		int x = t.getGridLocation().x;
		int y = t.getGridLocation().y;
		
		List<Tile> neighbors = new ArrayList<Tile>();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for (int i = 0; i < dx.length; i++){
			if(x + dx[i] < myTiles.length && 
					x + dx[i] >= 0 &&
					y + dy[i] < myTiles[0].length &&
					y + dy[i] >= 0){
				Tile temp = (myTiles[x + dx[i]][y + dy[i]]);
				neighbors.add(temp);
			}
		}

		return neighbors;
	}
	
	/*******Called by GridManager*********/
	
	public void move(Sprite sprite, Placement move) {
		mySpriteMap.put(sprite, move);
		
	}

	public Placement getPlacement(Collidable s){
		return mySpriteMap.get(s);
	}
	
	
	/*********outdated--delete once GAE is finalized *********/
	
	/*public boolean isComplete() {
	return myGridManager.isComplete();
}*/
	
	
	//maybe we'll need this idk
//	public Sprite getSpritefromPlacement (Placement p){
//		for (Sprite mySprite : mySpriteMap.keySet()){
//			if (mySpriteMap.get(mySprite).equals(p))
//				return mySprite;
//		}
//		return null;
//	}
	
	/*public void start(){
	myGridManager.start();
}*/
	// REVIEW: uncomment this if needed, but it shouldn't be unless by the game player
/*	public Tile[][] getTiles(){
		return myTiles;
	}*/


	
}