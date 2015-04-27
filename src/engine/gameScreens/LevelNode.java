package engine.gameScreens;


import java.awt.List;
import java.util.ArrayList;
import java.util.Queue;

import engine.Grid;
import engine.GridManager;
import engine.HeadsUpDisplay;
<<<<<<< HEAD
import engine.NodeState;
import engine.conditions.Condition;
=======
import engine.gameLogic.GameStats;
import engine.gameLogic.Placement;
>>>>>>> 3466350ec643555bf8e8c8bff695002e5ff19163
import engine.gameLogic.Wave;

public class LevelNode extends GameNode  {

	//private String myLevelTitle; TODO - why
	private Store myStore;
	private Grid myGrid;
	private HeadsUpDisplay myHUD;
	private GridManager myGridManager;
	private ArrayList<Condition> myConditions;
	private GameStats myGameStats;
	//private GridManager myGridManager; TODO - why

	public LevelNode() {
		super();
	}
	
	@Override
	public void render() {
		// TODO FILL IN WITH APPROPRIATE CALLS FOR LEVELNODE ONCE AVAILABLE
		
	}
	
	// increment money appropriately and place on grid
	void purchaseSprite(String SpriteID, Placement spritePlacement){
		myGameStats.updateMoney(-1*myStore.getTowerCost(myStore.getFromID(SpriteID)));
		myGrid.placeSpriteAt(myStore.getFromID(SpriteID), spritePlacement);
		render();
		
	}
	
	// TODO should the value when sold be different from the value when purchased? Currently, it is not.
	// increment money appropriately and remove from Grid
	void sellObject(String SpriteID, Placement spritePlacement){
		myGameStats.updateMoney(myStore.getTowerCost(myStore.getFromID(SpriteID)));
		myGrid.removeSpriteAt(myStore.getFromID(SpriteID), spritePlacement);
		render();
	
	}
	
	// TODO make sure that the Player displays the range correctly in addition to the model updating the HUD
	// TODO make sure that the player can accurately display a popup with the enemy's data
	void examineSprite(String SpriteID, Placement spritePlacement){
		render();
	}
	
	

	void increaseGameSpeed(){
		// TODO not sure why this is in the API
	}
	
	void decreaseGameSpeed(){
		// TODO not sure why this is in the API
	}
	
	
	private void init(){
		myGrid = new Grid(myGrid, myGridManager);
		myStore  = new Store();
		myHUD = new HeadsUpDisplay();
		myConditions = new ArrayList<Condition>();
	}

	
	public HeadsUpDisplay getHUD(){
		return myHUD;
	}

	public GridManager getGridManager() {
		return myGridManager;
	}
	
	public void setStore(Store store){
		myStore = store;
	}
	
	//TODO: MAKE SURE this is all that needs to be set up
	public void setGrid(Grid grid){
		myGrid = new Grid(grid, new GridManager(myGrid));
	}
	
	//TODO: make sure this is the right way to handle this
	public void setWaves(Queue<Wave> waves){
		myGrid.setWaves(waves);
	}
	
	public Grid getGrid(){
		return myGrid;
	}
	
	public Queue<Wave> getWaves(){
		return myGrid.getWaves();
	}
	
	public Store getStore(){
		return myStore;
	}

	public void update(){	
		myGrid.update();
	}

	public NodeState checkState(){
		return NodeState.RUNNING;
	}
	
	public void setGameStats(GameStats gamestats){
		myGameStats = gamestats;
	}



}