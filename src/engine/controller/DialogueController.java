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

	DialogueNode myDN = new DialogueNode(); //needs to be THE dialoguenode, not just an instance
	Queue<DialogueBox> d = myDN.getDialogueBoxes();
	
	public void showNextDialogue(){
		updateDialogueImage();
		updateDialogueText();
		d.poll();
	}
	
	public String updateDialogueImage(){
		return d.peek().getImagePath();
	}
	
	public String updateDialogueText(){
		return d.peek().getText();
	}
	
	
	
}
