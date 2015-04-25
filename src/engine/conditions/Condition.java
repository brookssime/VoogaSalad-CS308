package engine.conditions;

import engine.Environment;
import engine.Grid;
import engine.GridManager;
import engine.gameScreens.Store;

public abstract class Condition {
	
	private GridManager myGridManager;
	private Grid myGrid;
	private Store myStore;
	
	public Condition (Environment gameData){
		gameData.getGridManager();
		gameData.getGrid();
		gameData.getStore();
	}
	
	public abstract boolean evaluate();

}