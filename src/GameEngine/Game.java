package GameEngine;

import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Game {
	
	private final int FRAME_RATE = 10;
	private GameScene myHead;
	
	public Game(GameScene head){
		myHead = head;
	}
	
	public KeyFrame startGame(){
		return new KeyFrame(Duration.millis(FRAME_RATE * 10), e -> update());
	}

	public KeyFrame update(){
		if(sceneComplete()){
			myHead = myHead.getNextScene();
			return myHead.start(FRAME_RATE);
		}
		return myHead.getCurScene();
	}
	
	public boolean sceneComplete(){
		return myHead.isComplete();
	}
}