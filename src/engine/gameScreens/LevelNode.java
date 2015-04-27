package engine.gameScreens;



import java.util.ArrayList;
import java.util.Queue;

import engine.Grid;
import engine.GridManager;
import engine.HeadsUpDisplay;
import engine.NodeState;
import engine.conditions.Condition;
import engine.gameLogic.GameStats;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;

public class LevelNode extends GameNode  {

	private Store myStore;
	private Grid myGrid;
	private HeadsUpDisplay myHUD;
	private GridManager myGridManager;
	private ArrayList<Condition> myConditions;
	private GameStats myGameStats;

	public LevelNode() {
		super();
	}
	
	@Override
	public void render() {
		// TODO FILL IN WITH APPROPRIATE CALLS FOR LEVELNODE ONCE AVAILABLE
		
	}
	
	// increment money appropriately and place on grid
	public void purchaseSprite(String SpriteID, Placement spritePlacement){
		myGameStats.updateMoney(-1*myStore.getTowerCost(myStore.getFromID(SpriteID)));
		myGrid.placeSpriteAt(myStore.getFromID(SpriteID), spritePlacement);
		render();
	}
	
	public void placeSprite(String SpriteID, Placement spritePlacement){
		myGrid.placeSpriteAt(myStore.getTowerFromName(SpriteID), spritePlacement);
		
	}
	
	// TODO should the value when sold be different from the value when purchased? Currently, it is not.
	// increment money appropriately and remove from Grid
	public void sellObject(String SpriteID, Placement spritePlacement){
		myGameStats.updateMoney(myStore.getTowerCost(myStore.getFromID(SpriteID)));
		myGrid.removeSpriteAt(myStore.getFromID(SpriteID), spritePlacement);
		render();
	}
	
	// TODO make sure that the Player displays the range correctly in addition to the model updating the HUD
	// TODO make sure that the player can accurately display a popup with the enemy's data
	public void examineSprite(String SpriteID, Placement spritePlacement){
		render();
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
	
	public void setGrid(Grid grid){
		myGrid = new Grid(grid, new GridManager(myGrid));
	}

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