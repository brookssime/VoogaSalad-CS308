package engine;

import interfaces.Collidable;
import interfaces.Movable;
import interfaces.Shootable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import engine.gameLogic.Path;
import engine.gameLogic.PathFinder;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Base;
import engine.sprites.Enemy;
import engine.sprites.GridObject;
import engine.sprites.Projectile;

/**
 * The Class GridManager.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class GridManager {

	private Grid myGrid;
	private HashMap<String, Path> myEnemyPaths;
	private List<Movable> myMovables;
	private List<Shootable> myShootables;
	private List<Collidable> myCollidables;
	private Set<GridObject> myGridObjectsToRemove;
	private List<GridObject> myGridObjects; //consider this replacing myCollidables
	private Queue<Wave> myWaves;
	private long myStartTime;
	private PathFinder myPathFinder;
	private Base myBase;
	private boolean myGameWon; //remove these

	public GridManager(Grid g){
		//myGrid = g;
		sortObjects(g.getGridObjectMap());
		myPathFinder = new PathFinder(g);
	}

	public void sortObjects(Map<GridObject, Placement> map){
		for (GridObject o : map.keySet()){
			if(Arrays.asList(o.getClass().getClasses()).contains(Movable.class)){
				myMovables.add((Movable) o);
			}
			if(Arrays.asList(o.getClass().getClasses()).contains(Collidable.class)){
				myCollidables.add((Collidable) o);
			}
			if(Arrays.asList(o.getClass().getClasses()).contains(Shootable.class)){
				myShootables.add((Shootable) o);
			}
			if(Arrays.asList(o.getClass().getClasses()).contains(GridObject.class)){
				myGridObjects.add((GridObject) o);
			}
		}
	}

	public void update(){
		checkCollidables();
		moveSprites();
		checkShootables();
		clearSprites();
		spawnEnemies();
	}

	public void start(){
		myStartTime = System.nanoTime();
	}

	public boolean isComplete() {
		if (myBase.isDead()) {
			return true;
		} else if (myGameWon == true) {
			return true;
		} 
		return false;
		
	}

	public void setWaves(Queue<Wave> waves){
		myWaves = waves;
	}

	public Base getBase(){
		return myBase;
	}

	/**
	 * TODO: Clean this up
	 * Get rid of casting to GridObject as well as massive if statement
	 */
	private void checkCollidables() {
		for (Collidable sprite : myCollidables) {
			for (Collidable collider : myCollidables) {
				if (!(sprite.equals(collider))
						&& myGridObjectsToRemove.contains(collider)
						&& sprite.evaluateCollision(collider)
						&& collider.getClass().isAssignableFrom(
								Projectile.class)) {
					myGridObjectsToRemove.add((GridObject) collider);
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

	private void clearSprites() {
		myGridObjectsToRemove.addAll(myGridObjects.stream().filter(s -> s.isDead())
				.collect(Collectors.toSet())); // filter to find dead objects
		for (GridObject sprite : myGridObjectsToRemove) {
			myCollidables.remove(sprite);
		}
		myGridObjectsToRemove.clear();
	}

	private void spawnEnemies() {
		while (!myWaves.peek().isComplete()) {
			Wave w = myWaves.peek();
			List<Enemy> spawnedEnemies = w.update(myStartTime);
			for (Enemy e : spawnedEnemies){
				myPathFinder.setEnemyPath(e, w);
			}
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