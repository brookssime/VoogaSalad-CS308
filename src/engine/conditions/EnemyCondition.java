package engine.conditions;

import engine.Grid;
import engine.GridManager;
import engine.NodeState;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;

public class EnemyCondition extends Condition{

	public EnemyCondition(LevelNode levelNode) {
		super(levelNode);
	}

	@Override
	public NodeState evaluate() {
		if(myLevelNode.getGrid().getWaves().isEmpty()){
			return NodeState.ENEMIES_DEAD;
		}
		else{
			return NodeState.RUNNING;
		}
	}

}
