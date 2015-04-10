package engine;

import java.util.List;

import interfaces.Authorable;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Game implements Authorable {
	
	private String myName;
	private final int FRAME_RATE = 10;
	private GameScene myHead;
	private Store myStore;
	
	public Game(){
		
	}
	
	public Game(GameScene head){
		myHead = head;
		addStoreToLevel();
	}
	
	/**
	 * This is pretty awful design
	 * Any ideas?
	 */
	public void addStoreToLevel(){
		if(myHead instanceof LevelScene){
			((LevelScene) myHead).setStore(myStore);
		}
	}
	
	public KeyFrame startGame(){
		return new KeyFrame(Duration.millis(FRAME_RATE * 10), e -> update());
	}


	public KeyFrame update(){
		if(sceneComplete()){
			myHead = myHead.getNextScene();
			addStoreToLevel();
			return myHead.start(FRAME_RATE);
		}
		return myHead.getCurScene();
	}
	
	public boolean sceneComplete(){
		return myHead.isComplete();
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