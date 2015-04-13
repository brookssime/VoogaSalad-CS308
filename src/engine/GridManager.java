package engine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GridManager {
	
	private Grid myGrid;
	private HashMap<Integer, LinkedList<Tile>> myEnemyPaths;
	private List<Movable> myMovables;
	private List<Collidable> myCollidables;
	private Set<Collidable> mySpritesToRemove;
	private LinkedList<Wave> myWaves;
	private long myStartTime;
	private Base myBase;
	

	/**
	 * TODO: How are all of these lists being populated?
	 * TODO: Where do we initialize Grid? XStream?
	 */
	
	public GridManager(Grid g){
		myGrid = g;
	}
	
	public void update(){
		checkCollisions();
		moveSprites();
		clearSprites();
		spawnEnemies();
	}
	
	public void start(){
		myStartTime = System.nanoTime();
	}
	
	public Base getBase(){
		return myBase;
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
	
	private void moveSprites() {
		for (Movable sprite : myMovables) {
			sprite.move();
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

	private void setEnemyPath(Enemy enemy){
		if(myEnemyPaths.containsKey(enemy.getID()))
			enemy.setSteps(myEnemyPaths.get(enemy.getID()));
		else
			myEnemyPaths.put(enemy.getID(), (LinkedList)findPath(enemy));
	}

	
	public List<Tile> findPath(Enemy enemy){
		Tile current = myGrid.getPort();
		List<Tile> path = new LinkedList<Tile>();
		boolean pathFound = false;
		
		while(!pathFound){
			path.add(current);
			current = findNextTile(current, enemy);
			if (current == null) // perhaps give Tile a way to check if it has a Tower on it...?
				pathFound = true;
		}
		
		return path;
	}
	
	private Tile findNextTile(Tile current, Enemy enemy){
		
		// TODO
		// SHOULD return null if no next tile is found, or if this tile is a base..there is a null check in findPath
		
		return null;
	}
	
}
	
	
	