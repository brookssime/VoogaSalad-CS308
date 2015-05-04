// This entire file is part of my masterpiece.
// Fangyi Chen
package player.manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import engine.Game;
import engine.Grid;
import engine.HeadsUpDisplay;
import engine.Controller;
import engine.gameLogic.Placement;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.NodeButton;
import engine.gameScreens.Store;
import engine.sprites.Tower;
import game_data.ImageLoader;
import game_data.SampleGameMain;
import game_data.XMLWriter;
import player.GameChoiceScreen;
import player.GraphicGameScene;
import player.MainMenu;
import player.dialogue.DialogScene;
import player.level.GameLevelScene;


/**
 * --------Controller use-----------
 * UpdateView is for Engine to use to update the view in player side
 * 
 * --------Player use--------------
 * DialogueManager is the interface which  let dialogScene tell controller to update dialog
 * LevelManager is the interface for GameLevelScene. It has some method to let controller know what operation 
 * is made by player.
 * 
 * @author Fangyi Chen
 *
 */

public class PlayerManager implements DialogueManager, LevelManager, UpdateView{
	private GameLevelScene myLevel;
	private DialogScene myDialog;
	private Controller myController;
	private GraphicGameScene currScene;
	private Stage stage;
	private double screenWidth;
	private double screenHeight;
	private Game currGame;
	public static ImageLoader myImageLoader;

	public PlayerManager(Stage stage, double screenWidth, double screenHeight){
		this.stage = stage;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		init();
	}
	
	/**
	 * init the class
	 */
	private void init(){
		myImageLoader = new ImageLoader();
		myLevel = new GameLevelScene(stage, screenWidth, screenHeight, this);
		myDialog = new DialogScene(stage, screenWidth, screenHeight, this);
		SampleGameMain sample = new SampleGameMain();
		currGame = sample.createGame();
		myController = new Controller(currGame,this);
		
		
	}
	
	/**
	 * give the control to myController
	 * Update will be called when engine part changed something
	 */
	public void play(){
		myController.start();
	}
	
	/**
	 * return initial scene for player
	 */
	public Scene getInitScene(){
		
		MainMenu mainMenu = new MainMenu(stage,screenWidth,screenHeight);

		Scene initScene = mainMenu.getScene();
		
		return initScene;
	}
	

	/**
	 * ----------------this is for controller to use
	 */
	
	@Override
	public void updateLevel(Grid grid, Store store, HeadsUpDisplay hud){
		
		if(currScene != myLevel){
			changeScene(myLevel);
		}
		
		myLevel.updateLevel(grid, store, hud);

	}
	
	private void changeScene(GraphicGameScene myScene) {
		currScene = myScene;
		stage.setScene(currScene.getScene());
		stage.show();
		
	}
	@Override
	public void updateDialogue(DialogueBox dialog){
		if(currScene!=myDialog){
			changeScene(myDialog);
		}
		
		myDialog.displayDialog(dialog);

	}
	@Override
	public void displayError(String errormessage) {
		myLevel.displayError(errormessage);
		
	}
	
	
	/**
	 * make nodebutton for users to change scene
	 */
	@Override
	public void makeNodeButton(List<NodeButton> nodeButtons){
		currScene.makeNodeButton(nodeButtons);
	}
	
	/**
	 * -------------this is for levelscene to use
	 * 
	 * 
	 */

	@Override
	public void sellObject(String spriteID, Placement place) {
		Object[] params = {spriteID, place};

		
			try {
				myController.doSomething("sellObject", params);
			} catch (NoSuchMethodException | SecurityException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		

		
		
	}
	@Override
	public void placeSprite(String spriteID, Placement place) {
		Object[] params = {spriteID, place};
		try {
			myController.doSomething("placeSprite", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void examinSprite(String spriteID, Placement place) {
		Object[] params = {spriteID, place};
		try {
			myController.doSomething("examinSprite", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void increaseGameSpeed() {
		Object[] params = {};
		try {
			myController.doSomething("increaseGameSpeed", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void decreaseGameSpeed() {
		Object[] params = {};
		try {
			myController.doSomething("decreaseGameSpeed", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void purchaseObject(String spriteID, Placement p) {
		Object[] params = {spriteID, p};
		try {
			myController.doSomething("purchaseSprite", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ---------this is for dialogScene to use
	 * 
	 * 
	 */
	@Override
	public void showNextDialogue() {
		Object[] params = {};
		try {
			myController.doSomething("showNextDialogue", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * -------this is for both levelscene and dialogscene to use to change from one scene to another
	 * 
	 */


	public void moveToNode(String nodeID){
		myController.moveToNode(nodeID);
	}
}
