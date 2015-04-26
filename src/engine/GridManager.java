package engine;

import interfaces.Collidable;
import interfaces.Shootable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import engine.gameLogic.PathFinder;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Base;
import engine.sprites.Enemy;
import engine.sprites.Projectile;
import engine.sprites.Sprite;

/**
 * The Class GridManager.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 */
public class GridManager {

	private Grid myGrid;
	private List<Shootable> myShootables;
	private List<Collidable> myCollidables;
	private Set<Sprite> mySpritesToRemove;
	private List<Sprite> mySprites;
	private Queue<Wave> myWaves;
	private long myStartTime;
	private PathFinder myPathFinder;
	private Base myBase;
	private boolean myGameWon; //remove these

	public GridManager(Grid g){
		myGrid = g;
		sortObjects(g.getSpriteMap());
		myPathFinder = new PathFinder(g);
	}

	public void sortObjects(Map<Sprite, Placement> map){
		for (Sprite o : map.keySet()){
			if(Arrays.asList(o.getClass().getClasses()).contains(Collidable.class)){
				myCollidables.add((Collidable) o);
			}
			if(Arrays.asList(o.getClass().getClasses()).contains(Shootable.class)){
				myShootables.add((Shootable) o);
			}
			if(Arrays.asList(o.getClass().getClasses()).contains(Sprite.class)){
				mySprites.add((Sprite) o);
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
	 * Get rid of casting to Sprite as well as massive if statement
	 */
	private void checkCollidables() {
		for (Collidable sprite : myCollidables) {
			for (Collidable collider : myCollidables) {
				if (!(sprite.equals(collider))
						&& mySpritesToRemove.contains(collider)
						&& sprite.evaluateCollision(collider)
						&& collider.getClass().isAssignableFrom(
								Projectile.class)) {
					mySpritesToRemove.add((Sprite) collider);
				}
			}
		}
	}

	private void checkShootables(){
		for (Shootable s : myShootables){
			s.update();
			if(s.isReady()){
				fireSequence(s);
			}	
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
		for (Sprite sprite : mySprites) {
			//myGrid.move(sprite, sprite.move()); //TODO figure this out -- how to we add objects to the Grid?
		}
	}

	private void clearSprites() {
		mySpritesToRemove.addAll(mySprites.stream().filter(s -> s.isDead())
				.collect(Collectors.toSet())); // filter to find dead objects
		for (Sprite sprite : mySpritesToRemove) {
			myCollidables.remove(sprite);
		}
		mySpritesToRemove.clear();
	}

	private void spawnEnemies() {
		while (!myWaves.peek().isComplete()) {
			Wave w = myWaves.peek();
			List<Enemy> spawnedEnemies = w.update(myStartTime);
			for (Enemy e : spawnedEnemies){
				myPathFinder.setEnemyPath(e, w);
			}
			while (spawnedEnemies != null) {
				mySprites.addAll(spawnedEnemies);
				myCollidables.addAll(spawnedEnemies);
			}
		}
		myWaves.poll();
	}

	public Queue<Wave> getWaves() {
		return myWaves;
	}
}