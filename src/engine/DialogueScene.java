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
public class DialogueScene extends GameScene implements Authorable{

	/** The my name. */
	private String myName;
	
	/** The my dialogue. */
	private Queue<String> myDialogue;
	
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
	
	/**
	 * Instantiates a new dialogue scene.
	 *
	 * @param backroundImagePath the backround image path
	 * @param imagePathList the image path list
	 */
	public DialogueScene(String backroundImagePath, List<String> imagePathList) {
		myBackgroundImagePath = backroundImagePath;
		myImagePathList = imagePathList;
	}
	
	/**
	 * Empty for now.
	 */
	@Override
	public void update() {

	}

	/* (non-Javadoc)
	 * @see engine.GameScene#checkComplete()
	 */
	@Override
	public void checkComplete() {
		myHasCompleted = (myDialogue.size() <= 0);
	}
	
	/**
	 * Gets the next dialogue.
	 *
	 * @return the next dialogue
	 */
	public String getNextDialogue(){
		return myDialogue.poll();
	}
	
	/**
	 * To be accessed by view
	 * Returns imagePathList to allow for dialogue to be set up.
	 *
	 * @return the image path list
	 */
	public List<String> getImagePathList(){
		return myImagePathList;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}