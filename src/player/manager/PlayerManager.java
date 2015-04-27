package player.manager;

import java.util.List;

import engine.Grid;
import engine.HeadsUpDisplay;
import engine.Controller;
import engine.gameLogic.Placement;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.NodeButton;
import engine.gameScreens.Store;
import engine.sprites.Tower;
import player.GraphicGameScene;
import player.dialogue.DialogScene;
import player.level.GameLevelScene;


/**
 * For controller to use, can be casted as interface updateview
 * @author Fangyi Chen
 *
 */
public class PlayerManager implements DialogueManager, LevelManager, UpdateView{
	private GameLevelScene myLevel;
	private DialogScene myDialog;
	private Controller myController;
	private GraphicGameScene currScene;
	public void SceneManager(GameLevelScene level, DialogScene dialog, Controller controller){
		myLevel = level;
		myDialog = dialog;
		myController = controller;
	}
	public void init(){
		
	}
	public void moveToNode(String nodeID){
		myController.moveToNode(nodeID);
	}
	//for controller
	
	@Override
	public void updateLevel(Grid grid, Store store, HeadsUpDisplay hud){
		if(currScene != myLevel){
			changeScene(myLevel);
		}
		currScene = myLevel;
		myLevel.updateLevel(grid, store, hud);

	}
	private void changeScene(GraphicGameScene myLevel2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateDialogue(DialogueBox dialog){
		if(currScene!=myDialog){
			changeScene(myDialog);
		}
		currScene = myDialog;
		myDialog.displayDialog(dialog);

	}
	@Override
	public void displayError(String errormessage) {
		myLevel.displayError(errormessage);
		
	}
	
	//for level scene

	@Override
	public void sellObject(String spriteID, Placement place) {
		Object[] params = {spriteID, place};
		myController.doSomething("sellObject", params);
		
		
	}
	@Override
	public void placeSprite(String spriteID, Placement place) {
		Object[] params = {spriteID, place};
		myController.doSomething("placeSprite", params);
		
	}
	@Override
	public void examinSprite(String spriteID, Placement place) {
		Object[] params = {spriteID, place};
		myController.doSomething("examinSprite", params);
		
	}
	@Override
	public void increaseGameSpeed() {
		Object[] params = {};
		myController.doSomething("increaseGameSpeed", params);
		
	}
	@Override
	public void decreaseGameSpeed() {
		Object[] params = {};
		myController.doSomething("decreaseGameSpeed", params);
		
	}
	@Override
	public void purchaseObject(String spriteID) {
		Object[] params = {spriteID};
		myController.doSomething("purchaseObject", params);
	}
	@Override
	public void showNextDialogue() {
		Object[] params = {};
		myController.doSomething("showNextDialogue", params);
		
	}
	
	
	
	public void makeNodeButton(List<NodeButton> nodeButtons){
		currScene.makeNodeButton(nodeButtons);
	}
	
	public void makeDialogNodeButton(){
		
	}
	
	
	
	//for dialog scene use
	
	/*
	@Override
	public String getNextDialogueText() {
		return myController.updateDialogueText();
	}
	@Override
	public String getNextDialogueImage() {
		return myController.updateDialogueImage();
	}
	*/

	

	
}
