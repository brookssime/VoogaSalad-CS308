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
public abstract class GameNode extends GameObject {

	// TODO INITIALIZE THE GUI ONCE WE HAVE THE IMPLEMENTATION FROM FANGYI +
	// SAJAL

	private List<NodeButton> myNodeButtons;
	private Map<Double, GameNode> nextNodes;
	protected boolean myHasCompleted;
	private KeyFrame myScene;
	protected boolean myGameLost;
	protected boolean myGameWon;
	protected NodeState myState;

	public GameNode() {
		myNodeButtons = new ArrayList<NodeButton>();
		myState = NodeState.RUNNING;
	}

	public KeyFrame start(double frameRate) {
		myScene = new KeyFrame(Duration.millis(frameRate * 10), e -> update());
		return myScene;
	}

	public abstract void update(); // this gets called in a loop

	public abstract NodeState checkState();

	public abstract void render();

	public GameNode getNextNode(Double key) {
		return nextNodes.get(key);
	}

	public void addNewNode(Double key, GameNode gameNode) {
		nextNodes.put(key, gameNode);
	}

}