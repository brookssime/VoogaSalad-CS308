package engine;

import java.util.List;

import engine.gameScenes.GameScene;
import engine.gameScenes.LevelScene;
import engine.gameScenes.Store;
import interfaces.Authorable;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * The Class Game.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class Game implements Authorable {
	
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
	 */
	public Game(){
		
	}
	
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