package engine.gameScreens;

import engine.NodeState;

public class PauseScene extends GameNode{
	
	public PauseScene(){
		super();
	}

	@Override
	public void render() {
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
