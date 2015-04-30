package engine.gameScreens;

import interfaces.MethodAnnotation;
import interfaces.TypeAnnotation;

import java.util.ArrayList;
import java.util.stream.Collectors;

import player.manager.PlayerManager;
import engine.Grid;
import engine.GridManager;
import engine.HeadsUpDisplay;
import engine.NodeState;
import engine.conditions.Condition;
import engine.gameLogic.LevelStats;
import engine.gameLogic.Placement;


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
		myConditions = new ArrayList<Condition>();
	}

/*******Overridden from GameNode - Called by Game*********/
	@Override
	public void render(PlayerManager playerManager) {
		//System.out.print("Calling update level node render\n");
		playerManager.updateLevel(myGrid, myStore, myHUD);
	}
	
	@Override
	public void update() {
		myGrid.update();
		if(myGameStats != null)myGameStats.getTimeElapsed(myStartTime);
	}
	
	@Override
	public NodeState checkState() {
		if(myConditions == null) return null;
		return myConditions.stream().map(c -> c.evaluate(this))
				.filter(s -> s != NodeState.RUNNING)
				.collect(Collectors.toList()).get(0); //returns the first state that is non
	}


/*******Called using reflection in Controller.doSomething()*********/
	
	public void purchaseSprite(String SpriteID, Placement spritePlacement) {
		myGameStats.updateMoney(-1
				* myStore.getTowerCost(myStore.getFromID(SpriteID)));
		myGrid.placeSpriteAt(myStore.getFromID(SpriteID), spritePlacement);
	}
	
	public void placeSprite(String SpriteID, Placement spritePlacement) {
		myGrid.placeSpriteAt(myStore.getTowerFromName(SpriteID),
				spritePlacement);

	}

	public void sellObject(String spriteID, Placement spritePlacement) {
		myGameStats.updateMoney(myStore.getFromID(spriteID).getPrice()

				* -myStore.getSellPercentage());
		myGrid.removeSpriteAt(myStore.getFromID(spriteID), spritePlacement);
		myGrid.removeSpriteAt(myStore.getFromID(spriteID).getRangeObject(),
				spritePlacement);
	}

	void examineSprite(String SpriteID, Placement spritePlacement) {
		// REVIEW make sure that the Player accurately displays range and Tower info when selected...no backend implementation of examineSprite for now
	}

/********Called by GAE**********/

	@MethodAnnotation(editor = true, name = "Set Time Limit", type = "textfield", fieldName = "myTotalTime")
	public void setTotalTime(long time) {
		myTotalTime = time;
	}

	@MethodAnnotation(editor = true, name = "Set Store", type = "singleselect", fieldName = "myStore")
	@TypeAnnotation(type="Store")
	public void setStore(Store store) {
		System.out.println(store);
		myStore = store;
	}

	public void setHUD(HeadsUpDisplay HUD){
		myHUD = HUD;
	}

	@MethodAnnotation(editor = true, name = "Set Grid", type = "singleselect", fieldName = "myGrid")
	@TypeAnnotation(type="Grid")
	public void setGrid(Grid grid) {
		myGrid = new Grid(grid, new GridManager(grid));

	}

	public void setGameStats(LevelStats gamestats) {
		myGameStats = gamestats;
	}

/**********Called by by Condition subclasses***********/
	
	public long getTotalTime() {
		return myTotalTime;
	}

	public Grid getGrid() {
		return myGrid;
	}

	public long calculateRemainingTime() {
		return myTotalTime - myGameStats.getTimeElapsed(myStartTime);
	}
	
	public void addCondition(Condition c){
		myConditions.add(c);
	}

}