package player.manager;

import engine.Grid;
import engine.HeadsUpDisplay;
import engine.controller.Controller;
import engine.gameLogic.Placement;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.Store;
import engine.sprites.Tower;
import player.dialogue.DialogScene;
import player.level.GameLevelScene;

public class PlayerManager implements DialogueManager, LevelManager, UpdateView{
	private GameLevelScene myLevel;
	private DialogScene myDialog;
	private Controller myController;
	public void SceneManager(){
		
	}
	public void init(){
		
	}
	@Override
	public void updateLevel(Grid grid, Store store, HeadsUpDisplay hud){
		
	}
	@Override
	public void updateDialogue(DialogueBox dialog){
		
	}
	
	@Override
	public void placeTower(String spriteID, Placement place) {
		myController.placeSprite(spriteID, place);
		
	}
	@Override
	public void purchaseObject(String spriteID) {
		myController.purchaseObject(spriteID);
		
	}
	@Override
	public void sellObject(String spriteID, Placement place) {
		myController.sellObject(spriteID, place);
		
	}
	@Override
	public String getNextDialogueText() {
		return myController.updateDialogueText();
	}
	@Override
	public String getNextDialogueImage() {
		return myController.updateDialogueImage();
	}
	
	
}
