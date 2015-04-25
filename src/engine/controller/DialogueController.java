package engine.controller;

import java.util.Queue;

import engine.gameScreens.DialogueBox;
import engine.gameScreens.DialogueNode;

/**
 * A player clicks the "next" button in a dialogue scene
 * This would show the next string of text and image to the player
 * This would work by moving through our data structure containing the dialogue scene
 */

public class DialogueController extends Controller {

	DialogueNode myDialogueNode;
	Queue<DialogueBox> myDialogueBoxes = myDialogueNode.getDialogueBoxes();
	
	public void showNextDialogue(){
		updateDialogueImage();
		updateDialogueText();
		myDialogueBoxes.poll();
	}
	
	public String updateDialogueImage(){
		return myDialogueBoxes.peek().getImagePath();
	}
	
	public String updateDialogueText(){
		return myDialogueBoxes.peek().getText();
	}
}
