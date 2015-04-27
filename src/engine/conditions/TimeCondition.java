package engine.conditions;

import engine.Grid;
import engine.GridManager;
import engine.NodeState;
import engine.gameScreens.Store;

public class TimeCondition extends Condition{

	public TimeCondition(Grid grid, GridManager gridManager, Store store) {
		super(grid, gridManager, store);
	}

	@Override
	public NodeState evaluate() {
		return NodeState.RUNNING;
	}

}
