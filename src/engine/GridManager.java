package engine;

import interfaces.Collidable;
import interfaces.Shootable;

import java.awt.Shape;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;






import com.sun.javafx.geom.Area;

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
	 * TODO: Clean this up
	 */
	private void checkCollidables() {
		for (Collidable sprite : myCollidables) {
			for (Collidable collider : myCollidables) {
				if (!(sprite.equals(collider) 
						&& isCollision(sprite, collider))){
					
					//evaluate collision
					
					if(sprite.isDead()){
						myDeadCollidables.add(sprite);
					}
					if(collider.isDead()){
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

	private List<Collidable> getObjectsInRange(Shootable c){
		return c.getRangeObject().getObjectsInRange();
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
	
	private boolean isCollision(Collidable spriteCollidedWith, Collidable spriteCollider){
		//have author set collision bounds
		Shape shapeA = spriteCollidedWith.getCollisionBounds();
		Shape shapeB = spriteCollider.getCollisionBounds();
		Area areaA = new Area();
		Area areaB = new Area();
		areaA.intersect(areaB);
		return areaA.isEmpty();
	
	}
}