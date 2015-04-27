package engine;

import interfaces.Collidable;
import interfaces.Shootable;

import java.awt.Shape;
import java.awt.geom.Area;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.javafx.geom.Ellipse2D;

import engine.gameLogic.PathFinder;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Base;
import engine.sprites.Enemy;
import engine.sprites.Sprite;

public class GridManager {

	private Grid myGrid;
	private List<Shootable> myShootables;
	private List<Collidable> myCollidables;
	private Set<Collidable> myDeadCollidables;
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
		}
		return myGameWon;
	}

	public void setWaves(Queue<Wave> waves){
		myWaves = waves;
	}

	public Base getBase(){
		return myBase;
	}

	/**
	 * TODO: Clean this up??
	 */
	private void checkCollidables() {
		for (Collidable sprite : myCollidables) {
			for (Collidable collider : myCollidables) {
				if (!(sprite.equals(collider) && isCollision(sprite, collider))) {
					sprite.evaluateCollision(collider);
					if (sprite.isDead()) {
						myDeadCollidables.add(sprite);
					}
					if (collider.isDead()) {
						myDeadCollidables.add(collider);
					}
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
	private List<Collidable> getObjectsInRange(Shootable shootable){
		return shootable.getRangeObject().getObjectsInRange();
	}

	private void moveSprites() {
		for (Sprite sprite : mySprites) {
			myGrid.move(sprite, sprite.move()); 
		}
	}

	private void clearSprites() {
		myDeadCollidables.addAll(myCollidables.stream().filter(s -> s.isDead())
				.collect(Collectors.toSet())); // filter to find dead objects
		for (Collidable sprite : myDeadCollidables) {
			myCollidables.remove(sprite);
		}
		myDeadCollidables.clear();
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
	
	//TODO: THIS IS SOOOO TERRIBLEEEEEE
	private boolean isCollision(Collidable spriteCollidedWith, Collidable spriteCollider){
		Integer spriteCollidedWithX = myGrid.getPlacement(spriteCollidedWith).getLocation().x;
		Integer spriteCollidedWithY = myGrid.getPlacement(spriteCollidedWith).getLocation().y;
		Integer spriteColliderX = myGrid.getPlacement(spriteCollider).getLocation().x;
		Integer spriteColliderY = myGrid.getPlacement(spriteCollider).getLocation().y;
		
		Shape shapeA = (Shape) new Ellipse2D(spriteCollidedWithX, spriteCollidedWithY, spriteCollidedWith.getCollisionHeight(), spriteCollidedWith.getCollisionWidth());
		Shape shapeB = (Shape) new Ellipse2D(spriteColliderX, spriteColliderY, spriteCollider.getCollisionHeight(), spriteCollider.getCollisionWidth());
		Area areaA = new Area(shapeA);
		Area areaB = new Area(shapeB);
		areaA.intersect(areaB);
		return !areaA.isEmpty();
	}
}