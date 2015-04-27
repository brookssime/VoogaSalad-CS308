/*
 * 
 */
package engine.gameScreens;

import java.util.List;
import java.util.Queue;

import engine.NodeState;

// TODO: Auto-generated Javadoc
/**
 * DialogueScenes will consist of a background image, several "heads" on top of that, and then a center pane with dialogue
 * The background image will be passed in alone
 * The heads will be passed in as a list, which will be read by the view
 * The view will use the size of that list to determine how to construct the scene
 * Dialogue is going to be passed in as a Queue that will be polled (by the view perhaps) to populate the center pane.
 *
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class DialogueNode extends GameNode{


	private Queue<DialogueBox> myDialogueBoxes;
	private String myBackgroundImagePath;
	private List<String> myImagePathList; // contains all image paths of talking
											// heads. gamePlayer can read these
											// and determine how many spaces to
											// make in dialogueScene for heads

	
	public DialogueNode(){
		super();
	}

	
	
	public DialogueNode(String backgroundImagePath, Queue<DialogueBox> dialogueBoxes) {
		myBackgroundImagePath = backgroundImagePath;
		myDialogueBoxes = dialogueBoxes;
	}
	
	@Override
	public void render() {
		// TODO PUT APPROPRIATE CALLS FOR DIALOGUESCENE WHEN WE HAVE UNIFIED GUI CLASS
		
	}
	
	public void showNextDialogue(){
		myDialogueBoxes.poll();
		render();
	}
	
	public void setImagePath(String imagePath){
		myBackgroundImagePath = imagePath;
	}
	
	public void setDialogueBoxes(Queue<DialogueBox> dialogueBoxes){
		myDialogueBoxes = dialogueBoxes;
	}
	
	public String getImagePath(){
		return myBackgroundImagePath;
	}
	
	public Queue<DialogueBox> getDialogueBoxes(){
		return myDialogueBoxes;
	}
		
	@Override
	public NodeState checkState() {	
		return myState;
	}

	@Override
	public void update() {

	}
	
	public DialogueBox getNextDialogueBox(){
		return myDialogueBoxes.poll();
	}

	
}