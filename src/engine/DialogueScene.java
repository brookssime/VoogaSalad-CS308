/*
 * 
 */
package engine;

import interfaces.Authorable;

import java.util.List;
import java.util.Queue;

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
public class DialogueScene extends GameScene{


	/** The my name. */
	private String myName;
	
	/** The my dialogue. */
	private Queue<DialogueBox> myDialogue;
	
	/** The my background image path. */
	private String myBackgroundImagePath;
	
	/** The my image path list. */
	private List<String> myImagePathList; // contains all image paths of talking
											// heads. gamePlayer can read these
											// and determine how many spaces to
											// make in dialogueScene for heads

	
	/**
	 * Instantiates a new dialogue scene.
	 */
	public DialogueScene(){
		
	}
	

	public DialogueScene(String backgroundImagePath, Queue<DialogueBox> dialogueBoxes) {
		myBackgroundImagePath = backgroundImagePath;
		myDialogue = dialogueBoxes;
	}
	
	public void setImagePath(String imagePath){
		myBackgroundImagePath = imagePath;
	}
	
	public void setDialogueBoxes(Queue<DialogueBox> dialogueBoxes){
		myDialogue = dialogueBoxes;
	}
	
	@Override
	public boolean isComplete() {
		
		return (myDialogue.size() <= 0);
	}


	@Override
	public void update() {

	}
	public DialogueBox getNextDialogueBox(){
		return myDialogue.poll();
	}





	}