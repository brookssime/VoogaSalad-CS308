package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Shape;
import java.util.List;

public class Projectile extends Sprite implements Collidable, Movable{

	private String myImageString;
	private List<Integer> myAccessIDs;
	private Integer mySpeed; //this and damage and duration could be put in an Effect object
	private Integer myDamage;
	private Integer myEffectDuration;
	private int myX;
	private int myY;
	private int myRad;
	
	public Projectile(int x, int y){
		myX = x; myY = y;
		myRad = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evaluateCollision(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCollisionBounds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape getCollisionBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
