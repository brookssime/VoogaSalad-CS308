package GameEngine;

import groovy.swing.factory.CollectionFactory;
import interfaces.Collidable;
import interfaces.Movable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.converters.collections.CollectionConverter;

public class Controller {

	List<Sprite> mySprites;
	List<Movable> myMovables; 
	List<Collidable> myCollidables;
	
	
	public Controller(){
		mySprites = new ArrayList<Sprite>();
		myMovables = new ArrayList<Movable>();
	}
	
	public void update(){
		moveSprites();
		checkCollisions();
		clearSprites();
		dispenseNewEnemies();
		deployTimeBasedEffects();
		
	}

	private void moveSprites() {
		for(Movable sprite: myMovables){
			sprite.move();
		}
	}

	private void checkCollisions() {
		for(Collidable sprite: myCollidables){
			for(Collidable collider: myCollidables){
				if(!(sprite.equals(collider))){
					sprite.evaluateCollision(collider);
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

	private void dispenseNewEnemies() {
		// TODO Auto-generated method stub
		
	}

	private void deployTimeBasedEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
