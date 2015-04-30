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
	private Tile[][] myTiles;
	private GridManager myGridManager;
	private Map<Sprite, Placement> mySpriteMap;	
	private Queue<Wave> myWaves;
	private Tile[][] gaeTiles;
	private int tileR;
	private int tileC;
	private int spriteR;
	private int spriteC;
	
	public Grid(){
		setMyTiles(new Tile[myWidth][myHeight]);
		myGridManager = new GridManager(this);
		init();
	}

	public Grid(Grid grid, GridManager gm){
		myName = grid.myName;
		setMyTiles(grid.getMyTiles());
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
	
	@MethodAnnotation(editor=true, name = "Set Waves", type = "queueeditor", fieldName = "myWaves")
	public void setWaves(Queue<Wave> waves){
		myWaves = waves;
		myGridManager.setWaves(waves);
	}

	@SpecialEditorAnnotation(specialeditor=true, name="Set Tiles", fieldName="myTiles")
<<<<<<< HEAD
	public void setTiles(Tile[][] tiles){
		setMyTiles(tiles);
		initTiles();
=======
	public void setTiles(Tile tile){
		gaeTiles[tileR][tileC] = tile;
		if(tileR>=myHeight-1){
			tileR = 0;
		}
		else{
			tileR++;
		}
		if(tileC>=myWidth-1){
			tileC = 0;
		}
		else{
			tileC++;
		}
		
		if(gaeTiles[0].length==myWidth && gaeTiles.length==myHeight){
			myTiles = gaeTiles;
			initTiles();
		}
>>>>>>> 15cc7b11a938fdf18bc0b92e3e36d0358c36e9d5
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Sprite", fieldName="mySpriteMap")
	public void setSprite(Sprite sprite) {
		if(sprite!=null){
			Point point = new Point(spriteC, spriteR);
			mySpriteMap.put(sprite, new Placement(point));
		}
		if(spriteR>=myHeight-1){
			spriteR = 0;
		}
		else{
			spriteR++;
		}
		if(spriteC>=myWidth-1){
			spriteC = 0;
		}
		else{
			spriteC++;
		}
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
		for (int x = 0; x < getMyTiles().length; x++)
			for (int y = 0; y < getMyTiles().length; y++){
				getMyTiles()[x][y] = new Tile(x, y);
			}	
	}

	private void initTiles(){
		
		// adjust Tile y locations such that (0,0) is bottom right
		for (int x = 0; x < getMyTiles().length; x++)
			for(int i = 0; i < getMyTiles()[0].length / 2; i++)
			{
				Tile temp = getMyTiles()[x][i];
				getMyTiles()[x][i] = getMyTiles()[x][getMyTiles().length - i - 1];
				getMyTiles()[x][getMyTiles().length - i - 1] = temp;
			}
		
		
		// clone Tiles and set their locations
		for (int x = 0; x < getMyTiles().length; x++)
			for (int y = 0; y < getMyTiles()[0].length; y++){
				getMyTiles()[x][y] = getMyTiles()[x][y].clone();
				getMyTiles()[x][y].setGridLocation(new Point(x,y));
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
		
		return getMyTiles()[(int) Math.floor(p.getLocation().getX())][(int) Math.floor(p.getLocation().getY())]; 
		// REVIEW: this might cause errors because Tile's array location will NOT be related to each object's location
	}

	public List<Tile> getTileNeighbors(Tile t) {
		int x = t.getGridLocation().x;
		int y = t.getGridLocation().y;
		
		List<Tile> neighbors = new ArrayList<Tile>();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for (int i = 0; i < dx.length; i++){
			if(x + dx[i] < getMyTiles().length && 
					x + dx[i] >= 0 &&
					y + dy[i] < getMyTiles()[0].length &&
					y + dy[i] >= 0){
				Tile temp = (getMyTiles()[x + dx[i]][y + dy[i]]);
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

	public Tile[][] getMyTiles() {
		return myTiles;
	}

	public void setMyTiles(Tile[][] myTiles) {
		this.myTiles = myTiles;
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