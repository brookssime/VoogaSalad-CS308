package engine.conditions;

import engine.Grid;
import engine.GridManager;
import engine.NodeState;
import engine.gameScreens.Store;

public class EnemyCondition extends Condition{

	public EnemyCondition(Grid grid, GridManager gridManager, Store store) {
		super(null);
	}

	@Override
	public NodeState evaluate() {
		return NodeState.RUNNING;
	}

}
