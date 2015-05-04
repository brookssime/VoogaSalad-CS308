package engine;

import interfaces.Collidable;
import interfaces.Shootable;

import java.awt.Shape;
import java.awt.geom.Area;
import java.util.Arrays;
import java.util.LinkedList;
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
	private List<Base> myBases;

	public GridManager(Grid grid){
		myGrid = grid;
		myWaves = new LinkedList<>();
		//sortObjects(grid.getSpriteMap());
		myPathFinder = new PathFinder(grid);
	}

	/****Helpers--called locally**********/
	
	private void sortObjects(Map<Sprite, Placement> map){
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

	private void checkCollidables() {
		if(myCollidables == null) return;
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
		if(myShootables == null) return;
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
	
	private List<Collidable> getObjectsInRange(Shootable c){
		return c.getRangeObject().getObjectsInRange();
	}

	private void moveSprites() {
		if(mySprites == null) return;
		for (Sprite sprite : mySprites) {
			myGrid.move(sprite, sprite.move()); 
		}
	}

	// REVIEW this currently doesn's do anything to the Grid
	private void spawnEnemies() {
		if(myWaves == null || myWaves.isEmpty()) return;
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
	
	// REVIEW is this intended to remove them from the Grid? It currently is not doing that
	private void clearSprites() { 
		if(myCollidables == null) return;
		myDeadCollidables.addAll(myCollidables.stream().filter(s -> s.isDead())
				.collect(Collectors.toSet())); // filter to find dead objects
		for (Collidable sprite : myDeadCollidables) {
			myCollidables.remove(sprite);
		}
		myDeadCollidables.clear();
	}
	
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
	
	/*******Called by Grid********/
	
	public void update(){
		checkCollidables();
		checkShootables();
		moveSprites();
		clearSprites();
		spawnEnemies();
	}

	public void addWave(Wave wave){
		myWaves.add(wave);
	}
	
	// REVIEW: this ONLY exists here for the sake of conditions--is there a workaround?
	public Queue<Wave> getWaves() {
		return myWaves;
	}
	
	// REVIEW: this ONLY exists here for the sake of conditions--is there a workaround?
	public int calculateBaseHealth() {
			return myBases.stream().mapToInt(b -> b.getHealth()).sum();
		}

	public void updateSpriteMap(Map<Sprite, Placement> mySpriteMap) {
		sortObjects(mySpriteMap);
		
	}


	

	
	
}