package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.util.List;

public class Enemy extends Sprite implements Collidable, Movable{

	private Integer mySpeed;
	private Integer myDamage;
	private List<Integer> myWalkable;
	private String myImageString;
	//State?
	//Path?
	

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void evaluateCollision(Object o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

}
