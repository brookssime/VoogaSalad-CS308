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

// TODO: Auto-generated Javadoc
/**
 * The Class LevelScene.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class LevelScene extends GameScene implements Authorable {


	/** The my name. */
	private String myName;
	
	/** The my level title. */
	private String myLevelTitle; 
	
	/** The my current store. */
	private Store myStore;
	
	/** The my grid. */
	private Grid myGrid;
	
	/** The my grid manager. */
	private GridManager myGridManager;


	/**
	 * Instantiates a new level scene.
	 */
	public LevelScene() {
		super();

	}
	
	/* (non-Javadoc)
	 * @see engine.GameScene#start(double)
	 */
	@Override
	public KeyFrame start(double frameRate){
		myGrid.start();
		return super.start(frameRate);
		
	}

	/**
	 * Sets the store.
	 *
	 * @param store the new store
	 */
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
	
	/* (non-Javadoc)
	 * @see engine.GameScene#update()
	 */
	public void update(){	
		myGrid.update();
		//checkComplete();
	}

	public boolean isComplete(){
		return myGrid.isComplete();
	}


	/*@Override
>>>>>>> game_engine
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

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}

}