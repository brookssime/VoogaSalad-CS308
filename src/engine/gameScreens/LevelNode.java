package engine.gameScreens;


import java.util.Queue;

import engine.Grid;
import engine.GridManager;
import engine.HeadsUpDisplay;
import engine.gameLogic.Wave;

public class LevelNode extends GameNode  {

	//private String myLevelTitle; TODO - why
	private Store myStore;
	private Grid myGrid;
	private HeadsUpDisplay myHUD;
	private GridManager myGridManager;
	//private GridManager myGridManager; TODO - why

	public LevelNode() {
		super();
	}
	


	@Override
	public void render() {
		// TODO Fill in with appropriate calls as we get a Player API
		
	}
	
	private void init(){
		myGrid = new Grid(myGrid, myGridManager);
		myStore  = new Store();
		myHUD = new HeadsUpDisplay();
	}

	
	public HeadsUpDisplay getHUD(){
		return myHUD;
	}

	public GridManager getGridManager() {
		return myGridManager;
	}
	
	public void setStore(Store store){
		myStore = store;
	}
	
	//TODO: MAKE SURE this is all that needs to be set up
	public void setGrid(Grid grid){
		myGrid = new Grid(grid, new GridManager(myGrid));
	}
	
	//TODO: make sure this is the right way to handle this
	public void setWaves(Queue<Wave> waves){
		myGrid.setWaves(waves);
	}
	
	public Grid getGrid(){
		return myGrid;
	}
	
	public Queue<Wave> getWaves(){
		return myGrid.getWaves();
	}
	
	public Store getStore(){
		return myStore;
	}

	public void update(){	
		myGrid.update();
	}

	public boolean isComplete(){
		return myGrid.isComplete();
	}



}