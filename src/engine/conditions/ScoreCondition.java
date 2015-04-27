package engine.conditions;

import engine.Grid;
import engine.GridManager;
import engine.NodeState;
import engine.gameScreens.Store;

public class ScoreCondition extends Condition{

	public ScoreCondition(Grid grid, GridManager gridManager, Store store) {
		super(null);
	}

	@Override
	public NodeState evaluate() {
		return NodeState.RUNNING;
	}

}
