// This entire file is part of my masterpiece.
// Sajal Kantha

package engine;

import java.lang.reflect.InvocationTargetException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import player.manager.PlayerManager;

public class Controller {

	/**
	 * Used after player has clicked on a button Takes player to a new node,
	 * whether that be a level, title, or dialogue The ID will be passed to the
	 * player by the model, likely by a set method The player should also be
	 * able to know the ID of the node that they are going to
	 * 
	 * @param screenID
	 */

	private Game myGame;
	private PlayerManager myPlayerManager;

	public Controller(Game game, PlayerManager manager) {
		myPlayerManager = manager;
		myGame = game;
	}

	public void moveToNode(String nodeID) {
		myGame.goToNode(nodeID);
	}

	public void start() {
		myGame.setPlayerManager(myPlayerManager);
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		KeyFrame frame = new KeyFrame(Duration.seconds(.02),
				e -> myGame.update());
		timeline.getKeyFrames().add(frame);
		timeline.play();
	}

	// allows for generalized action on GameNodes
	public void doSomething(String action, Object[] params)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class[] paramTypes = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			paramTypes[i] = params[i].getClass();
		}
		java.lang.reflect.Method method = myGame.getCurNode().getClass()
				.getMethod(action, paramTypes);

		method.invoke(myGame.getCurNode(), params);
	}

	/*
	
	*//********** From DialogueController **********/
	/*
	 * 
	 * DialogueNodeQueue<DialogueBox> myDialogueBoxes =
	 * myDialogueNode.getDialogueBoxes();
	 * 
	 * public void showNextDialogue(){ updateDialogueImage();
	 * updateDialogueText(); myDialogueBoxes.poll(); }
	 * 
	 * public String updateDialogueImage(){ return
	 * myDialogueBoxes.peek().getImagePath(); }
	 * 
	 * public String updateDialogueText(){ return
	 * myDialogueBoxes.peek().getText(); }
	 *//********* From LevelController ***********/
	/*
	 * 
	 * 
	 * Takes in the ID and location of a tower on the front-end grid Will add
	 * sprite to grid on the back-en @param spriteID
	 * 
	 * @param spritePlacement Takes in the ID and location of a tower on the
	 * front-end grid
	 * 
	 * 
	 * public void placeSprite(String spriteID, Placement spritePlacement){
	 * Store myStore = new Store(); Environment myEnvironment = new
	 * Environment(); Grid myGrid = myEnvironment.getGrid();
	 * myGrid.placeSpriteAt(myStore.getFromID(spriteID), spritePlacement); }
	 *//**
	 * Takes in SpriteID Will display information about the sprite on screen
	 * Useful for looking at cost and health of towers, etc. TODO: Is this okay
	 * that it returns the Sprite info directly to view?
	 * 
	 * @param spriteID
	 * @return
	 */
	/*
	 * public Map<String, String> examineSprite(String spriteID){ Environment
	 * myEnvironment = new Environment(); Grid myGrid = myEnvironment.getGrid();
	 * return myGrid.getFromID(spriteID).getSpriteInfo(); }
	 *//**
	 * Takes in spriteID and makes necessary changes to money, HUD, and Store
	 */
	/*
	 * public void purchaseObject(String spriteID){ GameStats myGameStats = new
	 * GameStats(); Store myStore = new Store();
	 * myGameStats.updateMoney(myStore.getFromID(spriteID).getMyPrice()); }
	 *//**
	 * Takes in ID and placement Makes changes to money, HUD, and store Also
	 * removes sprite from grid on back-end
	 * 
	 * @param spriteID
	 * @param spritePlacement
	 */
	/*
	 * public void sellObject(String spriteID, Placement spritePlacement){
	 * Environment myEnvironment = new Environment(); GameStats myGameStats =
	 * new GameStats(); Store myStore = new Store(); Grid myGrid =
	 * myEnvironment.getGrid();
	 * myGrid.removeSpriteAt(myStore.getFromID(spriteID), spritePlacement);
	 * myGrid.removeSpriteAt(myStore.getFromID(spriteID).getRangeObject,
	 * spritePlacement);
	 * myGameStats.updateMoney(myStore.getFromID(spriteID).getMyPrice() *
	 * -myStore.getSellPercentage); }
	 *//**
	 * Error message if there isn't enough money to purchase returns true if
	 * there is money, otherwise false
	 */
	/*
	 * public boolean notEnoughMoney(String spriteID){ GameStats myGameStats =
	 * new GameStats(); Store myStore = new Store(); return
	 * (myGameStats.getMoney() > myStore.getFromID(spriteID).getMyPrice()); }
	 */
	/*********** From TitleController ***********/

}