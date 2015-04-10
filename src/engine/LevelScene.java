package engine;

import interfaces.Collidable;
import interfaces.Movable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LevelScene extends GameScene {

	private List<Movable> myMovables;
	private List<Collidable> myCollidables;
	private LinkedList<Wave> myWaves;
	private Base myBase;
	private Set<Collidable> mySpritesToRemove;
	private String myLevelTitle; 
	private Store myCurrentStore;
	private Grid myGrid;
	

	/**
	 * TODO: How are all of these lists being populated?
	 * TODO: Where do we initialize Grid? XStream?
	 */
	public LevelScene() {
		super();
		myMovables = new ArrayList<Movable>();
		myCollidables = new ArrayList<Collidable>();
		mySpritesToRemove = new HashSet<Collidable>();
	}

	public void setStore(Store store){
		myCurrentStore = store;
	}
	
	private void setGrid(Grid newGrid){
		myGrid = newGrid;
		//myGridManager = new GridManager(newGrid);
	}
	
	public void update(){	
		checkCollisions();
		moveSprites();
		clearSprites();
		spawnEnemies();
		deployTimeBasedEffects();
		checkComplete();
	}

	private void moveSprites() {
		for (Movable sprite : myMovables) {
			sprite.move();
		}
	}

	/**
	 * Clean this up if time?
	 */
	private void checkCollisions() {
		for (Collidable sprite : myCollidables) {
			for (Collidable collider : myCollidables) {
				if (!(sprite.equals(collider))
						&& mySpritesToRemove.contains(collider)
						&& sprite.evaluateCollision(collider)
						&& collider.getClass().isAssignableFrom(
								Projectile.class)) {
					mySpritesToRemove.add(collider);
				}
			}
		}
	}

	private void clearSprites() {
		mySpritesToRemove.addAll(myCollidables.stream().filter(s -> s.isDead())
				.collect(Collectors.toSet())); // filter to find dead objects
		for (Collidable sprite : mySpritesToRemove) {
			myCollidables.remove(sprite);
		}
		mySpritesToRemove.clear();
	}

	/**
	 * TODO: Figure out timing and how to space out enemies within wave What
	 * data structure do we use for waves?
	 */
	private void spawnEnemies() {
		while (!myWaves.peek().isComplete()) {
			List<Enemy> spawnedEnemies = myWaves.peek().update(myStartTime);
			while (spawnedEnemies != null) {
				myMovables.addAll(spawnedEnemies);
				myCollidables.addAll(spawnedEnemies);
			}
		}
		myWaves.pop();

	}

	/**
	 * To be implemented later
	 */
	private void deployTimeBasedEffects() {

	}

	@Override
	public void checkComplete() {
		if (myBase.isDead()) {
			myGameLost = true;
			myHasCompleted = true;
		} else if (myGameWon == true) {
			myHasCompleted = true;
		} else {
			myHasCompleted = false;
		}
	}

}