package player.manager;

import engine.gameScreens.DialogueBox;


/**
 * Interface for dialoueScene to update next dialog
 * 
 * @author Fangyi Chen
 *
 */
public interface DialogueManager extends NodeManager{
	//public String getNextDialogueText();
	//public String getNextDialogueImage();
	void showNextDialogue();
	//public void moveToNode(String NodeID);
}
