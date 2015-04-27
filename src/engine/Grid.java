package engine;

import java.util.List;
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
	private List<Tile> myPorts;
	private Map<String, Sprite> mySpriteNames; //TODO: This needs to be populated
	
	public Grid(int width, int height){
		myTiles = new Tile[width][height];
		myGridManager = new GridManager(this);
		init();
	}

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

	public void setPort(List<Tile> t){
		myPorts = t;
	}

	public List<Tile> getPort(){
		return myPorts;
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
	
	public Sprite getFromID(String inputSprite){
		for (String spriteName: mySpriteNames.keySet()){
			if (spriteName == inputSprite){
				return mySpriteNames.get(spriteName);
			}
		}
		return null; //TODO: Throw an error?
	}

	public void move(Sprite sprite, Placement move) {
		mySpriteMap.put(sprite, move);
		
	}
}