package engine.gameScreens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import engine.NodeState;
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
	
	// TODO INITIALIZE THE GUI ONCE WE HAVE THE IMPLEMENTATION FROM FANGYI + SAJAL
	
	private List<NodeButton> myNodeButtons;

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
		myNodeButtons = new ArrayList<NodeButton>();
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
	public abstract void update(); // this gets called in a loop
	
	/**
	 * Check complete.
	 */
	public abstract NodeState checkState();
	
	public abstract void render();

	/**
	 * Gets the next scene.
	 *
	 * @return the next scene
	 */
	public GameNode getNextNode(Double key){
		return nextNodes.get(key);
	}
	

	/**
	 * Sets the next scene.
	 *
	 * @param gameNode the new next scene
	 */
	public void addNewNode(Double key, GameNode gameNode){
		nextNodes.put(key, gameNode);
	}
	
	
}