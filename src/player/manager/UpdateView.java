// This entire file is part of my masterpiece.
// Fangyi Chen
package player.manager;

import java.util.List;

import engine.Grid;
import engine.HeadsUpDisplay;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.NodeButton;
import engine.gameScreens.Store;


/**
 * This interface is for controller to use to update level and dialogue scene
 * @author Fangyi Chen
 *
 */

public interface UpdateView {
	/**
	 * @param errormessage
	 * display error message
	 */
	public void displayError(String errormessage);
	
	/**
	 * @param grid
	 * @param store
	 * @param hud
	 * 
	 * update level scene
	 */
	public void updateLevel(Grid grid, Store store, HeadsUpDisplay hud);
	
	
	/**
	 * @param dialog
	 * 
	 * tell dialoguescene to update the dialog
	 */
	public void updateDialogue(DialogueBox dialog);
	
	
	/**
	 * @param nodeButtons
	 * tell current scene to make node button for user to use
	 */
	public void makeNodeButton(List<NodeButton> nodeButtons);
	
}
