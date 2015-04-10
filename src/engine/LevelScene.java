package engine;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.Movable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.animation.KeyFrame;

public class LevelScene extends GameScene implements Authorable {

	private String myName;
	private String myLevelTitle; 
	private Store myCurrentStore;
	private Grid myGrid;
	private GridManager myGridManager;

	public LevelScene() {
		super();

	}
	
	@Override
	public KeyFrame start(double frameRate){
		myGridManager.start();
		return super.start(frameRate);
		
		
	}

	public void setStore(Store store){
		myCurrentStore = store;
	}
	
	private void setGrid(Grid newGrid){
		myGrid = newGrid;
		//myGridManager = new GridManager(newGrid);
	}
	
	public void update(){	
		myGridManager.update();
		checkComplete();
	}


	@Override
	public void checkComplete() {
		if (myGridManager.getBase().isDead()) {
			myGameLost = true;
			myHasCompleted = true;
		} else if (myGameWon == true) {
			myHasCompleted = true;
		} else {
			myHasCompleted = false;
		}
	}

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