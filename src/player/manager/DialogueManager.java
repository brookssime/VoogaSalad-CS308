// This entire file is part of my masterpiece.
// Fangyi Chen
package player.manager;

import engine.gameScreens.DialogueBox;


/**
 * Interface for dialoueScene to update next dialog
 * 
 * @author Fangyi Chen
 *
 */
public interface DialogueManager extends NodeManager{

	/**
	 * tell controller to show next dialogue
	 */
	public void showNextDialogue();

}
