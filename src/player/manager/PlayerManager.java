package player.manager;

import java.lang.reflect.InvocationTargetException;

import engine.Grid;
import engine.HeadsUpDisplay;
import engine.Controller;
import engine.gameLogic.Placement;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.Store;
import engine.sprites.Tower;
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
	public void SceneManager(GameLevelScene level, DialogScene dialog, Controller controller){
		myLevel = level;
		myDialog = dialog;
		myController = controller;
	}
	public void init(){
		
	}
	//for controller
	@Override
	public void updateLevel(Grid grid, Store store, HeadsUpDisplay hud){
		myLevel.updateLevel(grid, store, hud);
	}
	@Override
	public void updateDialogue(DialogueBox dialog){
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
		
			try {
				myController.doSomething("sellObject", params);
			} catch (NoSuchMethodException | SecurityException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void purchaseObject(String spriteID) {
		Object[] params = {spriteID};
		try {
			myController.doSomething("purchaseObject", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void showNextDialogue() {
		Object[] params = {};
		try {
			myController.doSomething("showNextDialogue", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
