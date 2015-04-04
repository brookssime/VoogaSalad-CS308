package GameEngine;

import java.util.ArrayList;
import java.util.List;

public class Controller {

	List<Sprite> mySprites;
	
	
	public Controller(){
		mySprites = new ArrayList<Sprite>();
	}
	
	public void update(){
		moveSprites();
		checkCollisions();
		clearProjectiles();
		clearDeadEnemies();
		dispenseNewEnemies();
		deployTimeBasedEffects();
		
	}

	private void moveSprites() {
		// TODO Auto-generated method stub
		
	}

	private void checkCollisions() {
		// TODO Auto-generated method stub
		
	}

	private void clearProjectiles() {
		// TODO Auto-generated method stub
		
	}

	private void clearDeadEnemies() {
		// TODO Auto-generated method stub
		
	}

	private void dispenseNewEnemies() {
		// TODO Auto-generated method stub
		
	}

	private void deployTimeBasedEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
