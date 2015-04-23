package engine;

import engine.gameScreens.GameScene;
import engine.gameScreens.LevelScene;
import engine.gameScreens.Store;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * The Class Game.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class Game {
	
	/** The my name. */
	private String myName;
	
	/** The frame rate. */
	private final int FRAME_RATE = 10;
	
	/** The my head. */
	private GameScene myHead;
	
	/** The my store. */
	private Store myStore;
	
	
	
	/**
	 * Instantiates a new game.
	 *
	 * @param head the head
	 */
	public Game(GameScene head){
		myHead = head;
		addStoreToLevel();
	}
	
	public void setHead(GameScene head){
		myHead = head;
	}
	
	public GameScene getHead(){
		return myHead;
	}
	
	/**
	 * This is pretty awful design
	 * Any ideas?.
	 */
	public void addStoreToLevel(){
		if(myHead instanceof LevelScene){
			((LevelScene) myHead).setStore(myStore);
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
			myHead = myHead.getNextScene();
			addStoreToLevel();
			return myHead.start(FRAME_RATE);
		}
		return myHead.getCurScene();
	}
	
	/**
	 * Scene complete.
	 *
	 * @return true, if successful
	 */
	public boolean sceneComplete(){
		return myHead.isComplete();
	}

	
}