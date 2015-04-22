package engine.gameScreens;

import java.util.Map;

import engine.gameLogic.GameObject;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * The Class GameScene.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 * 
 */
public abstract class GameNode extends GameObject{

	private Map<Double, GameNode> nextNodes;
	
	/** The my has completed. */
	protected boolean myHasCompleted;
	
	/** The my scene. */
	private KeyFrame myScene;
	
	/** The my game lost. */
	protected boolean myGameLost;
	
	/** The my game won. */
	protected boolean myGameWon;

	
	/**
	 * Instantiates a new game scene.
	 */
	public GameNode(){
		//myGameLost = false;
	}

	/**
	 * Start.
	 *
	 * @param frameRate the frame rate
	 * @return the key frame
	 */
	public KeyFrame start(double frameRate) {
		myScene = new KeyFrame(Duration.millis(frameRate * 10), e -> update());
		return myScene;
	}

	/**
	 * Update.
	 */
	public abstract void update();
	
	/**
	 * Check complete.
	 */
	public abstract boolean isComplete();

	/**
	 * Gets the next scene.
	 *
	 * @return the next scene
	 */
	public GameNode getNextNode(String key){
		return nextNodes.get(key);
	}
	
	/**
	 * Gets the cur scene.
	 *
	 * @return the cur scene
	 */
	public KeyFrame getCurScene(){
		return myScene;
	}
		
	/**
	 * Sets the next scene.
	 *
	 * @param gameScene the new next scene
	 */
	public void setNextScene(GameNode gameScene){
		myNext = gameScene;
	}
}