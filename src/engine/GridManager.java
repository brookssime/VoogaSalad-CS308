package engine;

import interfaces.Collidable;
import interfaces.Movable;
import interfaces.Shootable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

// TODO: Auto-generated Javadoc
/**
 * The Class GridManager.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class GridManager {


	/** The my grid. */
	private Grid myGrid;

	/** The my enemy paths. */
	private HashMap<String, Path> myEnemyPaths;

	/** The my movables. */




	private List<Movable> myMovables;

	/** The my shootables. */
	private List<Shootable> myShootables;
	private List<Collidable> myCollidables;

	/** The my sprites to remove. */
	private Set<Collidable> mySpritesToRemove;

	/** The my waves. */
	private Queue<Wave> myWaves;

	/** The my start time. */
	private long myStartTime;




	private PathFinder myPathFinder;


	/** The my base. */
	private Base myBase;
	private boolean myGameLost; //remove these 
	private boolean myHasCompleted; // remove these 
	private boolean myGameWon; //remove these


	/**
	 * TODO: How are all of these lists being populated?
	 * TODO: Where do we initialize Grid? XStream?.
	 *
	 * @param g the g
	 */

	public GridManager(Grid g){
		//myGrid = g;
		sortObjects(g.getGridObjectMap());
		myPathFinder = new PathFinder(g);
	}

	public void sortObjects(Map<GridObject, Placement> map){
		for (GridObject o : map.keySet()){
			if(Arrays.asList(o.getClass().getClasses()).contains(Movable.class))
				myMovables.add((Movable) o);
			if(Arrays.asList(o.getClass().getClasses()).contains(Collidable.class))
				myCollidables.add((Collidable) o);
			if(Arrays.asList(o.getClass().getClasses()).contains(Shootable.class))
				myShootables.add((Shootable) o);
		}
	}

	/**
	 * Update.
	 */
	public void update(){
		checkCollidables();
		moveSprites();
		checkShootables();
		clearSprites();
		spawnEnemies();
	}


	/**
	 * Start.
	 */
	public void start(){
		myStartTime = System.nanoTime();
	}

	public boolean isComplete() {
		return myHasCompleted;
	}

	public void setWaves(Queue<Wave> waves){
		myWaves = waves;
	}

	/**
	 * Gets the base.
	 *
	 * @return the base
	 */
	public Base getBase(){
		return myBase;
	}

	/**
	 * Clean this up if time?.
	 */
	private void checkCollidables() {
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


	private void checkShootables(){
		for (Shootable s : myShootables){
			s.update();
			if(s.isReady())
				fireSequence(s);
		}
	}

	private void fireSequence(Shootable s){
		Collidable c = s.selectTarget(getObjectsInRange(s));
		myPathFinder.generateProjectile(s.fire(), myPathFinder.target(s, c));
	}


	//TODO: Come back such that we don't have to return the range...then take getRange out of the interface
	private List<Collidable> getObjectsInRange(Shootable c){
		return c.getRangeObject().getObjectsInRange();
	}



	private void moveSprites() {
		for (Movable sprite : myMovables) {
			sprite.move();
		}
	}

	/**
	 * Clear sprites.
	 */
	private void clearSprites() {
		mySpritesToRemove.addAll(myCollidables.stream().filter(s -> s.isDead())
				.collect(Collectors.toSet())); // filter to find dead objects
		for (Collidable sprite : mySpritesToRemove) {
			myCollidables.remove(sprite);
		}
		mySpritesToRemove.clear();
	}


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

	/**
	 * TODO: Figure out timing and how to space out enemies within wave What
	 * data structure do we use for waves?.
	 */
	private void spawnEnemies() {
		while (!myWaves.peek().isComplete()) {
			Wave w = myWaves.peek();
			List<Enemy> spawnedEnemies = w.update(myStartTime);
			//List<Enemy> spawnedEnemies = myWaves.peek().update(myStartTime);
			for (Enemy e : spawnedEnemies)
				myPathFinder.setEnemyPath(e, w);
			while (spawnedEnemies != null) {
				myMovables.addAll(spawnedEnemies);
				myCollidables.addAll(spawnedEnemies);
			}
		}
		myWaves.poll();
	}


	public Queue<Wave> getWaves() {
		return myWaves;
	}


}