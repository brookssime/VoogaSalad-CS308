package engine.gameInfo;

import java.util.Observable;

import engine.gameScenes.Store;

/**
 * This class will hold objects that are observable by the view
 * This includes the Grid, Store, and HUD
 * Other objects could be added to this in the future
 * 
 * @author brookssime and Sid
 *
 */
public class Environment extends Observable {
	
	//TODO: may need to make these public. will have to mess around with this.
	private Grid myGrid;
	private Store myStore;
	private HeadsUpDisplay myHUD;
	private GridManager myGridManager;
	
	/**
	 * Environment constructor, initiates the class
	 */
	public Environment(){
		init();
	}
	
	/**
	 * Observer for changes to environment
	 * Oversees:
	 * Grid changes (instances of objects on grid like placing a tower)
	 * Store changes (ex. cost of store objects)
	 * HUD changes (change in score, time, money, base health)
	 */
	public void updateObserver(){
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	/**
	 * Initializes the environment
	 */
	private void init(){
		myGrid = new Grid(myGrid, myGridManager);
		myStore  = new Store();
		myHUD = new HeadsUpDisplay();
	}
}