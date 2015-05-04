// This entire file is part of my masterpiece.
// Patrick Wickham
package engine.gameScreens;

import java.util.ArrayList;
import java.util.List;
import player.manager.PlayerManager;
import engine.NodeState;

/**
 * The Class GameNode.
 * 
 * @author Patrick
 * 
 * An abstract class to encapsulate the shared behaviors of various 
 * Game scenes--example subclasses include LevelNode, PauseScene, and DialogueNode
 * 
 */
public abstract class GameNode {

	private List<NodeButton> myNodeButtons;
	protected NodeState myState;

	public GameNode() {
		myNodeButtons = new ArrayList<NodeButton>();
		myState = NodeState.RUNNING;
	}

	/*
	 * appropriately updates subclass-specific state
	 */
	public abstract void update();

	/*
	 * forces the called node to check its own state in a subclass-specific way
	 */
	public abstract NodeState checkState();

	/*
	 * updates subclass-specific GUI components
	 */
	public abstract void render(PlayerManager playerManager);

	/*
	 * default, updates the NodeButtons in the Player
	 */
	public void refreshNodeButtons(PlayerManager playerManager){
		playerManager.makeNodeButton(myNodeButtons);
	}
	
	// for use by the author
	public void setNodeButtons(List<NodeButton> nodeButtons){
		myNodeButtons = nodeButtons;
	}


}