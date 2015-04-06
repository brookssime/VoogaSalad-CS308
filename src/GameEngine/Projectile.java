package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.util.List;

public class Projectile implements Collidable, Movable{

	private String myImageString;
	private List<Integer> myAccessIDs;
	private Integer mySpeed; //this and damage and duration could be put in an Effect object
	private Integer myDamage;
	private Integer myEffectDuration;
	private Point myLocation;
	private int myRadius;
	private double myDirection;
	
	public Projectile(Point location, Integer speed, Integer damage, Integer duration){
		myLocation = location; 
		mySpeed = speed; 
		myDamage = damage; 
		myEffectDuration = duration;
		myRadius = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	
	@Override
	public void move() {
		myLocation.x += mySpeed * Math.cos(myDirection);
		myLocation.y += mySpeed * Math.sin(myDirection);		
	}

	@Override
	public boolean evaluateCollision(Collidable collider) {
		//no method body because projectile's effect evaluated by enemy
		return isCollision(collider);
		
	}

	@Override
	public boolean isDead(){
		return false;
	}
	
	public void setCollisionBounds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape getCollisionBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
