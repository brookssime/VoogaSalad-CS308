// This entire file is part of my masterpiece.
// SID GOPINATH

package engine;

import interfaces.Collidable;
import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import engine.gameLogic.GameObject;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Sprite;
import engine.sprites.Tile;

public class Grid extends GameObject{

	private int myHeight;
	private int myWidth;
	private Tile[][] myTiles;
	private Map<Sprite, Placement> mySpriteMap;
	private ArrayList<Wave> myWaves;
	private Tile[][] myGAETiles;
	private int myTileRow;
	private int myTileColumn;
	private int mySpriteRow;
	private int mySpriteColumn;
	
	public Grid(){
		mySpriteMap = new HashMap<Sprite, Placement>();
		myWaves = new ArrayList<Wave>();
		mySpriteRow = 0;
		mySpriteColumn = 0;
	}

	public Grid(Grid grid){
		myName = grid.myName;
		setMyTiles(grid.getMyTiles());
		mySpriteMap = grid.mySpriteMap;
	}
	
	/********Called by GAE**********/
	@MethodAnnotation(editor=true, name = "Grid Editor", type = "grid", fieldName = "")
	public void getGAEComponent() {
		return;
	}
	
	@SpecialEditorAnnotation(specialeditor = true, name = "Set Height", fieldName = "myHeight")
	public void setHeight(Integer height) {
		myHeight = height;
	}
	
	@SpecialEditorAnnotation(specialeditor = true, name = "Set Width", fieldName = "myWidth")
	public void setWidth(Integer width) {
		myWidth = width;
	}
	
	@MethodAnnotation(editor=true, name = "Set Waves", type = "queueeditor", fieldName = "myWaves")
	public void addWave(Wave wave){
		myWaves.add(wave);
	}

	@SpecialEditorAnnotation(specialeditor=true, name="Set Tiles", fieldName="myTiles")
	public void setTiles(Tile tile){
		myGAETiles[myTileRow][myTileColumn] = tile;
		if(myTileRow>=myHeight-1){
			myTileRow = 0;
		}
		else{
			myTileRow++;
		}
		if(myTileColumn>=myWidth-1){
			myTileColumn = 0;
		}
		else{
			myTileColumn++;
		}
		if(myGAETiles[0].length==myWidth && myGAETiles.length==myHeight){
			myTiles = myGAETiles;
			initTiles();
		}
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Sprite", fieldName="mySpriteMap")
	public void setSprite(Sprite sprite) {
		if(sprite!=null){
			Point point = new Point(mySpriteColumn, mySpriteRow);
			mySpriteMap.put(sprite, new Placement(point));
		}
		if(mySpriteRow>=myHeight-1){
			mySpriteRow = 0;
		}
		else{
			mySpriteRow++;
		}
		if(mySpriteColumn>=myWidth-1){
			mySpriteColumn = 0;
		}
		else{
			mySpriteColumn++;
		}
	}

	/******Called by Player and GridManager*********/
	public Map<Sprite, Placement> getSpriteMap(){
		return mySpriteMap;
	}

	/******Helper Methods********/
	private void initTiles(){
		for (int x = 0; x < getMyTiles().length; x++)
			for (int i = 0; i < getMyTiles()[0].length / 2; i++) {
				Tile temp = getMyTiles()[x][i];
				getMyTiles()[x][i] = getMyTiles()[x][getMyTiles().length - i
						- 1];
				getMyTiles()[x][getMyTiles().length - i - 1] = temp;
			}
		for (int x = 0; x < getMyTiles().length; x++){
			for (int y = 0; y < getMyTiles()[0].length; y++) {
				getMyTiles()[x][y] = getMyTiles()[x][y].clone();
				getMyTiles()[x][y].setGridLocation(new Point(x, y));
			}
		}
	}
	
	protected void refreshHeadings(){
		for(Sprite s : mySpriteMap.keySet()){
			mySpriteMap.get(s).normalize();
		}
	}
	
	/*********Called by LevelNode*******/
	public void placeSpriteAt(Sprite sprite, Placement spritePlacement){
		mySpriteMap.put(sprite, spritePlacement);
	}
	
	public void removeSpriteAt(Sprite sprite, Placement spritePlacement){
		mySpriteMap.remove(sprite, spritePlacement);
	}

	/*******Called by PathFinder***********/
	public Tile getPortFor(Wave wave) {
		Placement placement = new Placement();
		for(Sprite sprite : mySpriteMap.keySet()){
			if(sprite.getName().equals(wave.getPortName()))
					placement = mySpriteMap.get(sprite);	
		}
		return getMyTiles()[(int) Math.floor(placement.getLocation().getX())][(int) Math.floor(placement.getLocation().getY())]; 
	}

	public List<Tile> getTileNeighbors(Tile tile) {
		int x = tile.getGridLocation().x;
		int y = tile.getGridLocation().y;
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
	protected void move(Sprite sprite, Placement move) {
		mySpriteMap.put(sprite, move);
	}

	protected Placement getPlacement(Collidable s){
		return mySpriteMap.get(s);
	}

	protected Tile[][] getMyTiles() {
		return myTiles;
	}

	protected void setMyTiles(Tile[][] tiles) {
		myTiles = tiles;
	}
	
	protected ArrayList<Wave> getWaves(){
		return myWaves;
	}
}