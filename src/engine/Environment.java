package engine;

import engine.gameScreens.Store;

/**
 * This includes the Grid, Store, and HUD
 * Other objects could be added to this in the future
 * 
 * @author brookssime and Sid
 *
 */
public class Environment {
	
	private Grid myGrid;
	private Store myStore;
	private HeadsUpDisplay myHUD;
	private GridManager myGridManager;
	
	public Environment(){
		init();
	}
	
	private void init(){
		myGrid = new Grid(myGrid, myGridManager);
		myStore  = new Store();
		myHUD = new HeadsUpDisplay();
	}

	public Grid getGrid(){
		return myGrid;
	}
	
	public Store getStore(){
		return myStore;
	}
	
	public HeadsUpDisplay getHUD(){
		return myHUD;
	}

	public GridManager getGridManager() {
		return myGridManager;
	}
}