package engine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Projectile implements Collidable, Movable{

	private String myImageString;
	private List<Integer> myAccessIDs;
	private Integer mySpeed; //this and damage and duration could be put in an Effect object
	private Integer myDamage;
	private Integer myEffectDuration;
	private Point myLocation;
	private int myRad;
	private double myDirection;
	private Shape myCollisionBounds;
	
	public Projectile(Point location, Integer speed, Integer damage, Integer duration){
		myLocation = location; 
		mySpeed = speed; 
		myDamage = damage; 
		myEffectDuration = duration;
		myRad = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	
	@Override
	public void move() {
		myLocation.x += mySpeed * Math.cos(myDirection);
		myLocation.y += mySpeed * Math.sin(myDirection);		
	}

	/**
	 * no method body because projectile's effect evaluated by enemy
	 */
	@Override
	public boolean evaluateCollision(Collidable collider) {
		return isCollision(collider);
	}

	/**
	 * Maybe find a way to make it so projectiles are marked as dead upon collision?
	 * Instead of manually removing them like we do currently
	 */
	@Override
	public boolean isDead(){
		return false;
	}
	
	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);
		
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
}