package player.manager;

import engine.Grid;
import engine.HeadsUpDisplay;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.Store;


/**
 * This interface is for controller to use to update level and dialogue scene
 * @author Fangyi Chen
 *
 */

public interface UpdateView {
	void displayError(String errormessage);
	void updateLevel(Grid grid, Store store, HeadsUpDisplay hud);
	void updateDialogue(DialogueBox dialog);
		
	
}
