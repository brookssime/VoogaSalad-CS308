package engine;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Projectile extends GridObject implements Collidable, Movable{

	private String myName;
	private String myImageString;
	private List<String> myAccessIDs;
	private Integer mySpeed; 
	public Effect myEffect;
	private Point myLocation;
	private int myRadius;
	private double myDirection;
	private Shape myCollisionBounds;
	
	public Projectile(){
		
	}
	
	public Projectile(Point location, Integer speed, Integer damage, Integer duration, Effect effect){
		myLocation = location; 
		mySpeed = speed; 
		myEffect = effect;
		myRadius = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	
	public void setRadius(int x){
		myRadius = x;
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
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRadius*2, myRadius*2);
		
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}



}