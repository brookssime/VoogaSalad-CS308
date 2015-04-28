package engine.gameScreens;

import java.util.ArrayList;
import java.util.List;

import player.manager.PlayerManager;
import engine.NodeState;
import engine.gameLogic.GameObject;
/**
 * The Class GameScene.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 * 
 */
public abstract class GameNode extends GameObject {


	//protected PlayerManager myPlayerManager; 
	// TODO ensure that this ^^ is set correctly AFTER the node is recreated from Xstream
	private List<NodeButton> myNodeButtons;
	protected NodeState myState;

	public GameNode() {
		myNodeButtons = new ArrayList<NodeButton>();
		myState = NodeState.RUNNING;
	}

	public abstract void update();

	public abstract NodeState checkState();

	public abstract void render(PlayerManager playerManager);

	public void refreshNodeButtons(PlayerManager p){
		// TODO : once PlayerManager has the method written, write in the NodeButtons
	}
	
	// for use by the author
	public void setNodeButtons(List<NodeButton> nodeButtons){
		myNodeButtons = nodeButtons;
	}

	// for use by the player
	public List<NodeButton> getNodeButtons() {
		return myNodeButtons;
	}

}