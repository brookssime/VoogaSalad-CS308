package engine.gameScreens;

import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.Collectors;

import engine.Grid;
import engine.GridManager;
import engine.HeadsUpDisplay;
import engine.NodeState;
import engine.conditions.Condition;
import engine.gameLogic.LevelStats;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;

public class LevelNode extends GameNode {

	private Store myStore;
	private Grid myGrid;
	private HeadsUpDisplay myHUD;
	private ArrayList<Condition> myConditions;
	private LevelStats myGameStats;
	private long myStartTime;
	private long myTotalTime;

	public LevelNode() {
		super();
		myStartTime = System.nanoTime();
	}

	@Override
	public void render() {
		myPlayerManager.updateLevel(myGrid, myStore, myHUD);

	}

	// increment money appropriately and place on grid
	public void purchaseSprite(String SpriteID, Placement spritePlacement) {
		myGameStats.updateMoney(-1
				* myStore.getTowerCost(myStore.getFromID(SpriteID)));
		myGrid.placeSpriteAt(myStore.getFromID(SpriteID), spritePlacement);
		render();
	}

	public void placeSprite(String SpriteID, Placement spritePlacement) {
		myGrid.placeSpriteAt(myStore.getTowerFromName(SpriteID),
				spritePlacement);

	}

	public void sellObject(String spriteID, Placement spritePlacement) {
		myGameStats.updateMoney(myStore.getFromID(spriteID).getMyPrice()
				* -myStore.getSellPercentage());
		myGrid.removeSpriteAt(myStore.getFromID(spriteID), spritePlacement);
		myGrid.removeSpriteAt(myStore.getFromID(spriteID).getRangeObject(),
				spritePlacement);
		render();
	}

	// REVIEW make sure that the Player displays the range correctly in addition
	// to the model updating the HUD
	// REVIEW make sure that the player can accurately display a popup with the
	// enemy's data
	void examineSprite(String SpriteID, Placement spritePlacement) {
		render();
	}

	public HeadsUpDisplay getHUD() {
		return myHUD;
	}

	public void setTotalTime(long time) {
		myTotalTime = time;
	}

	public void setStore(Store store) {
		myStore = store;
	}

	public void setGrid(Grid grid) {
		myGrid = new Grid(grid, new GridManager(myGrid));

	}

	public void setWaves(Queue<Wave> waves) {
		myGrid.setWaves(waves);
	}

	public long getTotalTime() {
		return myTotalTime;
	}

	public Grid getGrid() {
		return myGrid;
	}

	public Queue<Wave> getWaves() {
		return myGrid.getWaves();
	}

	public Store getStore() {
		return myStore;
	}

	public void update() {
		myGrid.update();
		myGameStats.getTimeElapsed(myStartTime);
	}

	public NodeState checkState() {
		return myConditions.stream().map(c -> c.evaluate(this))
				.filter(s -> s != NodeState.RUNNING)
				.collect(Collectors.toList()).get(0); //returns the first state that is non
	}

	public void setGameStats(LevelStats gamestats) {
		myGameStats = gamestats;
	}

	public long calculateRemainingTime() {
		return myTotalTime - myGameStats.getTimeElapsed(myStartTime);
	}

}