package engine.conditions;

import engine.Environment;
import engine.Grid;
import engine.GridManager;
import engine.gameScreens.Store;

public abstract class Condition {
	
	protected GridManager myGridManager;
	protected Grid myGrid;
	protected Store myStore;
	
	public Condition (Environment gameData){
		gameData.getGridManager();
		gameData.getGrid();
		gameData.getStore();
	}
	
	public abstract boolean evaluate();

}