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
	private Set<Sprite> myDeadSprites;
	private List<Sprite> mySprites;
	private Queue<Wave> myWaves;
	private long myStartTime;
	private PathFinder myPathFinder;
	private Base myBase;
	private boolean myGameWon; //remove these

	public GridManager(Grid grid){
		myGrid = grid;
		sortObjects(grid.getSpriteMap());
		myPathFinder = new PathFinder(grid);
	}

	public void sortObjects(Map<Sprite, Placement> map){
		for (Sprite o : map.keySet()){
			if(Arrays.asList(o.getClass().getClasses()).contains(Collidable.class)){
				myCollidables.add((Collidable) o);
			}
			if(Arrays.asList(o.getClass().getClasses()).contains(Shootable.class)){
				myShootables.add((Shootable) o);
				myCollidables.add(((Shootable) o).getRangeObject()); //add a shootable's range object to collidables
				
			}
			if(Arrays.asList(o.getClass().getClasses()).contains(Sprite.class)){
				mySprites.add(o);
			}
		}
	}

	public void update(){
		checkCollidables();
		checkShootables();
		moveSprites();
		clearSprites();
		spawnEnemies();
	}

	public void start(){
		myStartTime = System.nanoTime();
	}

	public boolean isComplete() {
		if (myBase.isDead()) {
			return true;
		} else
			return (myGameWon);
		
	
		
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
				if (!(sprite.equals(collider) 
						&& isCollision(sprite, collider))){
					//evaluate collision
					//if sprite or collider isDead, add to spritesToRemove
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
			myGrid.move(sprite, sprite.move()); 
		}
	}

	private void clearSprites() {
		myDeadSprites.addAll(mySprites.stream().filter(s -> s.isDead())
				.collect(Collectors.toSet())); // filter to find dead objects
		for (Sprite sprite : myDeadSprites) {
			myCollidables.remove(sprite);
		}
		myDeadSprites.clear();
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
	
	private boolean isCollision(Collidable spriteCollidedWith, Collidable spriteCollider){
		
		return false;
	}
}