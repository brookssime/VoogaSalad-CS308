package engine;

import java.util.Observable;

/**
 * This class will hold objects that are observable by the view
 * This includes the Grid, Store, and HUD
 * Other objects could be added to this in the future
 * 
 * @author brookssime AND SID jeez #pairprogramming
 *
 */

public class Environment extends Observable {
	
	public Grid myGrid;
	public Store myStore;
	public HeadsUpDisplay myHUD;
	
	
	/**
	 * Environment constructor, initiates the class
	 */
	
	public Environment(){
		init();
	}
	
	/**
	 * Observer for changes to environment
	 * OVERSEES
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
		myGrid = new Grid();
		myStore  = new Store();
		myHUD = new HeadsUpDisplay();
	}
	
}
