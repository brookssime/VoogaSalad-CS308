package engine.gameScreens;

import player.manager.PlayerManager;
import engine.NodeState;

public class PauseScene extends GameNode{
	
	public PauseScene(){
		super();
	}

	@Override
	public void renderLevel(PlayerManager playerManager) {
		// REVIEW: make sure these having nothing is fully functional
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public NodeState checkState() {
		return NodeState.RUNNING;
	}



}
