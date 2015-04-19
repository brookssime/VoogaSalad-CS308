package engine;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.Movable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.animation.KeyFrame;

public class LevelScene extends GameScene implements Authorable {

	private String myLevelTitle; 
	private Store myStore;
	private Grid myGrid;
	//private Queue<Wave> myWaves;
	//private GridManager myGridManager;

	public LevelScene() {
		super();

	}
	
	@Override
	public KeyFrame start(double frameRate){
		myGrid.start();
		return super.start(frameRate);
		
	}

	public void setStore(Store store){
		myStore = store;
	}
	
	//TODO: MAKE SURE this is all that needs to be set up
	private void setGrid(Grid grid){
		myGrid = new Grid(grid, new GridManager(myGrid));
		//myGridManager = new GridManager(grid);
	}
	
	//TODO: make sure this is the right way to handle this
	private void setWaves(Queue<Wave> waves){
		myGrid.setWaves(waves);
		//myWaves = waves;
	}
	
	public void update(){	
		myGrid.update();
		//checkComplete();
	}

	public boolean isComplete(){
		return myGrid.isComplete();
	}

	/*@Override
	public void checkComplete() {
		if (myGridManager.getBase().isDead()) {
			myGameLost = true;
			myHasCompleted = true;
		} else if (myGameWon == true) {
			myHasCompleted = true;
		} else {
			myHasCompleted = false;
		}
	}*/

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}

}