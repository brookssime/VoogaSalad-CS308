package player.manager;

import engine.GridManager;
import engine.HeadsUpDisplay;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.Store;


/**
 * This interface is for controller to use to update level and dialogue scene
 * @author Fangyi Chen
 *
 */

public interface UpdateView {
	public void displayError(String errormessage);
	public void updateLevel(GridManager gridManager, Store store, HeadsUpDisplay hud);
	public void updateDialogue(DialogueBox dialog);
		
	
}
