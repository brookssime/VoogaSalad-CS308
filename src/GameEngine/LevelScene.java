package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class LevelScene extends GameScene{

	private List<Movable> myMovables; 
	private List<Collidable> myCollidables;
	private Base myBase;
	private Set<Collidable> toRemove;
	
	public LevelScene(){
		myMovables = new ArrayList<Movable>();
		myCollidables = new ArrayList<Collidable>();
		toRemove = new HashSet<Collidable>();
	}
	
	public void update(){	
		moveSprites();
		checkCollisions();
		clearSprites();
		spawnEnemies();
		deployTimeBasedEffects();
		checkComplete();
	}

	private void moveSprites() {
		for(Movable sprite: myMovables){
			sprite.move();
		}
	}

	/**
	 * TODO: Clean this up?
	 * Make it less indented
	 */
	private void checkCollisions() {
		for(Collidable sprite: myCollidables){
			for(Collidable collider: myCollidables){
				if(!(sprite.equals(collider))){
					if(sprite.evaluateCollision(collider) && collider.getClass().isAssignableFrom(Projectile.class)){
						toRemove.add(collider);
					}	
				}
			}
		}
	}

	private void clearSprites() {
		toRemove.addAll(myCollidables.stream()
				.filter(s -> s.isDead()).collect(Collectors.toSet())); //filter to find dead objects
		for(Collidable sprite: toRemove){
			myCollidables.remove(sprite);
		}
		toRemove.clear();
	}

	/**
	 * TODO: Figure out timing and how to space out enemies within wave
	 * What data structure do we use for waves?
	 */
	private void spawnEnemies() {
		// TODO Auto-generated method stub
	}

	/**
	 * To be implemented later
	 */
	private void deployTimeBasedEffects() {
		
	}

	/**
	 * TODO: How do we determine if level is won?
	 */
	@Override
	public void checkComplete() {
		if(myBase.isDead()){
			//myNext = gameOverScene;
			hasCompleted = true;
		}
		//else if level is won
		//change hasCompleted to true
		else{
			hasCompleted = false;
		}
	}	
}