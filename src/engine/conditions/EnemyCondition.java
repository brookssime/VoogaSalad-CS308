package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public class EnemyCondition extends Condition{

	public EnemyCondition() {
		super();
	}

	@Override
	public NodeState evaluate(LevelNode levelNode) {
		if(levelNode.getGridManager().getWaves().isEmpty()){
			return NodeState.ENEMIES_DEAD;
		}
		else{
			return NodeState.RUNNING;
		}
	}

}
