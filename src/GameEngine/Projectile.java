package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.util.List;

public class Projectile extends Sprite implements Collidable, Movable{

	private String myImageString;
	private List<Integer> myAccessIDs;
	private Integer mySpeed; //this and damage and duration could be put in an Effect object
	private Integer myDamage;
	private Integer myEffectDuration;
	
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
