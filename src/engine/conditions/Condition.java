package engine.conditions;

import engine.Grid;
import engine.GridManager;
import engine.NodeState;
import engine.gameScreens.Store;

public abstract class Condition {
	
	protected GridManager myGridManager;
	protected Grid myGrid;
	protected Store myStore;
	
	public Condition (Grid grid, GridManager gridManager, Store store){
		myGrid= grid;
		myGridManager = gridManager;
		myStore = store;
	}
	
	public abstract NodeState evaluate();

}