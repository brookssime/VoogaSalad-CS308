package engine.conditions;

import engine.Grid;
import engine.GridManager;
import engine.NodeState;
import engine.gameScreens.Store;

public class HealthCondition extends Condition{

	public HealthCondition(Grid grid, GridManager gridManager, Store store) {
		super(grid, gridManager, store);
	}
	

	@Override
	public NodeState evaluate() {
		if(myGridManager.calculateBaseHealth()==0){
			return NodeState.BASE_DEAD;
		}
		else{
			return NodeState.RUNNING;
		}
	}

}
