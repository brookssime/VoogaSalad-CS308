package engine;

import javafx.animation.KeyFrame;
import javafx.util.Duration;
import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;


/**
 * The Class Game.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class Game {
	
	/** The my name. */
	private String myName;

	private final int FRAME_RATE = 10;
	
	/** The my head. */
	private GameNode myStartNode;
	
	/** The my store. */
	private Store myStore;
	
	
	
	/**
	 * Instantiates a new game.
	 *
	 * @param head the head
	 */
	public Game(GameNode head){
		myStartNode = head;
		addStoreToLevel();
	}
	
	public void setHead(GameNode head){
		myStartNode = head;
	}
	
	public GameNode getHead(){
		return myStartNode;
	}
	
	/**
	 * This is pretty awful design
	 * Any ideas?.
	 */
	public void addStoreToLevel(){
		if(myStartNode instanceof LevelNode){
			((LevelNode) myStartNode).setStore(myStore);
		}
	}
	
	/**
	 * Start game.
	 *
	 * @return the key frame
	 */
	public KeyFrame startGame(){
		return new KeyFrame(Duration.millis(FRAME_RATE * 10), e -> update());
	}


	/**
	 * Update.
	 *
	 * @return the key frame
	 */
	public KeyFrame update(){
		if(sceneComplete()){
			myStartNode = myStartNode.getNextNode();
			addStoreToLevel();
			return myStartNode.start(FRAME_RATE);
		}
		return myStartNode.getCurScene();
	}
	
	/**
	 * Scene complete.
	 *
	 * @return true, if successful
	 */
	public boolean sceneComplete(){
		return myStartNode.isComplete();
	}
}