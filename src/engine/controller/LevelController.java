package engine.controller;

import java.util.Map;

import engine.Environment;
import engine.Grid;
import engine.gameLogic.GameStats;
import engine.gameLogic.Placement;
import engine.gameScreens.Store;

//TODO Where do we get the store, environment, grid, game stats, etc. from?
//We need to actually get those in here properly
public class LevelController extends Controller {

	/**
	 * Takes in the ID and location of a tower on the front-end grid
	 * Will add sprite to grid on the back-end
	 * @param spriteID
	 * @param spritePlacement
	 */
	public void placeSprite(String spriteID, Placement spritePlacement){
		Store myStore = new Store();
		Environment myEnvironment = new Environment();
		Grid myGrid = myEnvironment.getGrid();
		myGrid.placeSpriteAt(myStore.getFromID(spriteID), spritePlacement);
	}
	
	/**
	 * Takes in SpriteID
	 * Will display information about the sprite on screen
	 * Useful for looking at cost and health of towers, etc.
	 * TODO: Is this okay that it returns the Sprite info directly to view?
	 * @param spriteID
	 * @return 
	 */
	public Map<String, String> examineSprite(String spriteID){
		Environment myEnvironment = new Environment();
		Grid myGrid = myEnvironment.getGrid();
		return myGrid.getFromID(spriteID).getSpriteInfo();	
	}

	/**
	 * Takes in spriteID and makes necessary changes to money, HUD, and Store
	 */
	public void purchaseObject(String spriteID){
		GameStats myGameStats = new GameStats();
		Store myStore = new Store();
		myGameStats.updateMoney(myStore.getFromID(spriteID).getMyPrice());
	}
	
	/**
	 * Takes in ID and placement
	 * Makes changes to money, HUD, and store
	 * Also removes sprite from grid on back-end
	 * @param spriteID
	 * @param spritePlacement
	 */
	public void sellObject(String spriteID, Placement spritePlacement){
		Environment myEnvironment = new Environment();
		GameStats myGameStats = new GameStats();
		Store myStore = new Store();
		Grid myGrid = myEnvironment.getGrid();
		myGrid.removeSpriteAt(myStore.getFromID(spriteID), spritePlacement);
		myGameStats.updateMoney(myStore.getFromID(spriteID).getMyPrice() * -1);	
	}	
}