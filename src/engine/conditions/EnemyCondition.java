package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public class EnemyCondition extends Condition{

	public EnemyCondition() {
		super();
	}

	@Override
	public NodeState evaluate(LevelNode levelNode) {
		if(levelNode.getGrid().getWaves().isEmpty()){
			return NodeState.ENEMIES_DEAD;
			//return NodeState.RUNNING; //for testing
		}
		else{
			return NodeState.RUNNING;
		}
	}

}
