// This entire file is part of my masterpiece.
// SID GOPINATH

package engine;

import interfaces.Collidable;
import interfaces.Shootable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import engine.gameLogic.PathFinder;
import engine.gameLogic.Placement;
import engine.gameLogic.Wave;
import engine.sprites.Base;
import engine.sprites.Enemy;
import engine.sprites.Sprite;
import engine.sprites.Tile;

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
		myPathFinder = new PathFinder(grid);
		for(Wave wave: myGrid.getWaves()){
			myWaves.add(wave);
		}
	}

	/*******Called by Grid********/
	public void update(){
		checkCollidables();
		checkShootables();
		moveSprites();
		clearSprites();
		spawnEnemies();
		myGrid.refreshHeadings();
		sortObjects(myGrid.getSpriteMap());
	}

	private void checkCollidables() {
		for (Collidable sprite : myCollidables) {
			for (Collidable collider : myCollidables) {
				if (!sprite.equals(collider)) {
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
		for (Shootable shootable : myShootables){
			shootable.update();
			if(shootable.isReady()){
				fireSequence(shootable);
			}	
		}
	}

	private void moveSprites() {
		for (Sprite sprite : mySprites) {
			myGrid.move(sprite, sprite.move()); 
		}
	}

	private void clearSprites() { 
		myCollidables.removeAll(myDeadCollidables);
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

	private void fireSequence(Shootable s){
		Collidable c = s.selectTarget(getObjectsInRange(s));
		myPathFinder.generateProjectile(s.fire(), myPathFinder.target(s, c));
	}
	
	private List<Collidable> getObjectsInRange(Shootable c){
		return c.getRangeObject().getObjectsInRange();
	}

	public void addWave(Wave wave){
		myWaves.add(wave);
	}
	
	public Queue<Wave> getWaves() {
		return myWaves;
	}
	
	public int calculateBaseHealth() {
			return myBases.stream().mapToInt(b -> b.getHealth()).sum();
		}

	public Map<Sprite, Placement> getSpriteMap() {
		return myGrid.getSpriteMap();
	}

	public Tile[][] getMyTiles() {
		return myGrid.getMyTiles();
	}
}