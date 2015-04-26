package engine;

import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Game {
	
	private String myName;
	private final int FRAME_RATE = 10;	
	private GameNode myCurNode;
	private Store myStore;
	
	public Game(GameNode head){
		myCurNode = head;
		addStoreToLevel();
	}
	
	
	
	public void setHead(GameNode head){
		myCurNode = head;
	}
	
	public GameNode getCurNode(){
		return myCurNode;
	}
	
	/**
	 * This is pretty awful design
	 * Any ideas? Maybe a try/catch
	 */
	public void addStoreToLevel(){
		if(myCurNode instanceof LevelNode){
			((LevelNode) myCurNode).setStore(myStore);
		}
	}
	
	//TODO: Can this all be removed with our new framework of KeyFrame/game loop?
	//Fangyi will handle the game loop and creating the key frames
	//then he will call a method in the controller that calls the loop method in model
	
/*	public KeyFrame startGame(){
		return new KeyFrame(Duration.millis(FRAME_RATE * 10), e -> update());
	}
	
	public KeyFrame update(){
		if(sceneComplete()){
			myCurNode = myCurNode.getNextNode();
			addStoreToLevel();
			return myCurNode.start(FRAME_RATE);
		}
		return myCurNode.getCurScene();
	}*/

	public boolean sceneComplete(){
		return myCurNode.isComplete();
	}

	
}