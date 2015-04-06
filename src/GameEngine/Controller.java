package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Controller {

	List<Movable> myMovables; 
	List<Collidable> myCollidables;
	
	
	public Controller(){
		myMovables = new ArrayList<Movable>();
		myCollidables = new ArrayList<Collidable>();
	}
	
	public void update(){
		moveSprites();
		checkCollisions();
		clearSprites();
		spawnEnemies();
		deployTimeBasedEffects();
		
	}

	private void moveSprites() {
		for(Movable sprite: myMovables){
			sprite.move();
		}
	}

	private void checkCollisions() {
		Set<Collidable> toRemove = new HashSet<Collidable>();
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
		List<Collidable> spritesToRemove = myCollidables.stream()
				.filter(s -> s.isDead()).collect(Collectors.toList());
		for(Collidable sprite: spritesToRemove){
			myCollidables.remove(sprite);
			//remove from view possibly?
		}
	}

	private void spawnEnemies() {
		// TODO Auto-generated method stub
		
	}

	private void deployTimeBasedEffects() {
		//to be implemented later
	}	
}