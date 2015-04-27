package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public class HealthCondition extends Condition{

	public HealthCondition() {
		super();
	}
	

	@Override
	public NodeState evaluate(LevelNode levelNode) {
		if(levelNode.getGrid().getBaseHealth()==0){
			return NodeState.BASE_DEAD;
		}
		else{
			return NodeState.RUNNING;
		}
	}

}
