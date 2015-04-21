package engine.gameScreens;

import interfaces.GameObject;

import java.util.List;
import java.util.Queue;

import javafx.animation.KeyFrame;
import engine.Grid;
import engine.GridManager;
import engine.gameLogic.Wave;

/**
 * The Class LevelScene.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class LevelScene extends GameScene implements GameObject {

	private String myName;
	private String myLevelTitle; 
	private Store myStore;
	private Grid myGrid;
	private GridManager myGridManager;

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

	@Override
	public void setName(String name) {
		myName = name;
	}

	@Override
	public String getName() {
		return myName;
	}

	//TODO: Purpose of this?
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
	}
}