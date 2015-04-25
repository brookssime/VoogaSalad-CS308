package engine.controller;

import engine.Environment;
import engine.Grid;
import engine.GridManager;
import engine.gameLogic.GameStats;
import engine.gameLogic.Placement;


//TODO NEED TO WRITE STRING TO SPRITE CLASS
//TODO SPRITE NEEDS getWorth() METHOD AND getInfo() [total info about sprite] METHOD
public class LevelController extends Controller {

	/**
	 * Takes in the ID and location of a tower on the front-end grid
	 * Will add sprite to grid on the back-end
	 * @param spriteID
	 * @param spritePlacement
	 */
	
	public void placeSprite(String spriteID, Placement spritePlacement){
		Environment e = new Environment();
		Grid myGrid = e.getGrid();
		myGrid.placeSpriteAt(sprite, spritePlacement);
	}
	
	/**
	 * Takes in SpriteID
	 * Will display information about the sprite on screen
	 * Useful for looking at cost and health of towers, etc.
	 * @param spriteID
	 */
	public void examineSprite(String spriteID){
		
		return sprite.getInfo();
		
	}
	
	/**
	 * Starts gameplay (and timeline, etc.)
	 */
	public void play(){
		//should be in the view
		
	}
	
	/**
	 * Pauses gameplay (and timeline, etc.)
	 */
	public void pause(){
		//should be in the view
	}
	
	/**
	 * Allows for player to double the speed of gameplay
	 */
	public void increaseGameSpeed(){
		//should be in the view
	}
	
	/**
	 * Allows for player to cut the speed of gameplay in half
	 */
	public void decreaseGameSpeed(){
		//should be in the view
		
	}
	
	/**
	 * Takes in spriteID and makes necessary changes to money, HUD, and Store
	 */
	public void purchaseObject(String spriteID){
		GameStats myGameStats = new GameStats();
		myGameStats.updateMoney(sprite.getWorth());
		
	}
	
	/**
	 * Takes in ID and placement
	 * Makes changes to money, HUD, and store
	 * Also removes sprite from grid on back-end
	 * @param spriteID
	 * @param spritePlacement
	 */
	public void sellObject(String spriteID, Placement spritePlacement){
		GameStats myGameStats = new GameStats();
		Environment e = new Environment();
		Grid myGrid = e.getGrid();
		myGrid.placeSpriteAt(tile, spritePlacement);
		myGameStats.updateMoney(sprite.getWorth() * -1);
		
		
	}
	
	/**
	 * Displays the help page for players
	 */
	public void showHelpPage(){
		//should be in the view
		
	}
	
	
}