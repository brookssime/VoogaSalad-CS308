package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public class HealthCondition extends Condition{

	public HealthCondition(LevelNode levelNode) {
		super(levelNode);
	}
	

	@Override
	public NodeState evaluate() {
		if(myLevelNode.getGrid().getBaseHealth()==0){
			return NodeState.BASE_DEAD;
		}
		else{
			return NodeState.RUNNING;
		}
	}

}
