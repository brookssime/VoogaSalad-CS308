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
public class DialogueScene extends GameScene implements Authorable{

	private String myName;
	private Queue<String> myDialogue;
	private String myBackgroundImagePath;
	private List<String> myImagePathList; // contains all image paths of talking
											// heads. gamePlayer can read these
											// and determine how many spaces to
											// make in dialogueScene for heads
	
	public DialogueScene(){
		
	}
	
	public DialogueScene(String backroundImagePath, List<String> imagePathList) {
		myBackgroundImagePath = backroundImagePath;
		myImagePathList = imagePathList;
	}
	
	/**
	 * Empty for now
	 */
	@Override
	public void update() {

	}

	@Override
	public void checkComplete() {
		myHasCompleted = (myDialogue.size() <= 0);
	}
	
	public String getNextDialogue(){
		return myDialogue.poll();
	}
	
	/**
	 * To be accessed by view
	 * Returns imagePathList to allow for dialogue to be set up
	 */
	public List<String> getImagePathList(){
		return myImagePathList;
	}

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}