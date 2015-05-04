// This entire file is part of my masterpiece.
// Patrick Wickham
package engine.gameScreens;

import java.util.ArrayList;
import java.util.stream.Collectors;
import player.manager.PlayerManager;
import engine.Grid;
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


	public LevelNode() {
		super();
		
	}

/*******Overridden from GameNode - Called by Game*********/
	@Override
	public void render(PlayerManager playerManager) {
		playerManager.updateLevel(myGrid, myStore, myHUD);
	}
	
	@Override
	public void update() {
		myGrid.update();
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

	public void setStore(Store store) {
		myStore = store;
		
	}

}