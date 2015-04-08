package GameEngine;

import java.util.Queue;

public class DialogueScene extends GameScene{

	private Queue<String> myDialogue;
	
	@Override
	public void update() {
		// nothing yet
	}

	@Override
	public void checkComplete() {
		myHasCompleted = (myDialogue.size() <= 0);
	}
	
	public String getNextDialogue(){
		return myDialogue.poll();
	}
}
