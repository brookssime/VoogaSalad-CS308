package engine;

import interfaces.Authorable;

import java.util.List;
import java.util.Queue;

/**
 * 
 * DialogueScenes will consist of a background image, several "heads" on top of that, and then a center pane with dialogue
 * The background image will be passed in alone
 * The heads will be passed in as a list, which will be read by the view
 * The view will use the size of that list to determine how to construct the scene
 * Dialogue is going to be passed in as a Queue that will be polled (by the view perhaps) to populate the center pane
 * @author Sid and Brooks and Patrick
 *
 */
public class DialogueScene extends GameScene{

	private Queue<DialogueBox> myDialogueBoxes;
	private String myBackroundImagePath;
	
	public DialogueScene(){
		
	}
	
	public DialogueScene(String backroundImagePath, Queue<DialogueBox> dialogueBoxes) {
		myBackroundImagePath = backroundImagePath;
		myDialogueBoxes = dialogueBoxes;
	}
	
	public void setImagePath(String imagePath){
		myBackroundImagePath = imagePath;
	}
	
	public void setDialogueBoxes(Queue<DialogueBox> dialogueBoxes){
		myDialogueBoxes = dialogueBoxes;
	}
	
	
	
	/**
	 * Empty for now
	 */
	@Override
	public void update() {

	}

	@Override
	public void checkComplete() {
		myHasCompleted = (myDialogueBoxes.size() <= 0);
	}
	
	public DialogueBox getNextDialogueBox(){
		return myDialogueBoxes.poll();
	}
	
	/**
	 * To be accessed by view
	 * Returns imagePathList to allow for dialogue to be set up
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}