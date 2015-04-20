/*
 * 
 */
package engine;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Projectile.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Projectile implements Collidable, Movable, Authorable{

	/** The my name. */
	private String myName;
	
	/** The my image string. */
	private String myImageString;
	
	/** The my access i ds. */
	private List<Integer> myAccessIDs;
	
	/** The my speed. */
	private Integer mySpeed; 
	
	/** The my effect. */
	public Effect myEffect;
	
	/** The my location. */
	private Point myLocation;
	
	/** The my rad. */
	private int myRad;
	
	/** The my direction. */
	private double myDirection;
	
	/** The my collision bounds. */
	private Shape myCollisionBounds;
	
	/**
	 * Instantiates a new projectile.
	 */
	public Projectile(){
		
	}
	
	/**
	 * Instantiates a new projectile.
	 *
	 * @param location the location
	 * @param speed the speed
	 * @param damage the damage
	 * @param duration the duration
	 * @param effect the effect
	 */
	public Projectile(Point location, Integer speed, Integer damage, Integer duration, Effect effect){
		myLocation = location; 
		mySpeed = speed; 
		myEffect = effect;
		myRad = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Movable#move()
	 */
	@Override
	public void move() {
		myLocation.x += mySpeed * Math.cos(myDirection);
		myLocation.y += mySpeed * Math.sin(myDirection);		
	}

	/**
	 * no method body because projectile's effect evaluated by enemy.
	 *
	 * @param collider the collider
	 * @return true, if successful
	 */
	@Override
	public boolean evaluateCollision(Collidable collider) {
		return isCollision(collider);
	}

	/**
	 * Maybe find a way to make it so projectiles are marked as dead upon collision?
	 * Instead of manually removing them like we do currently.
	 *
	 * @return true, if is dead
	 */
	@Override
	public boolean isDead(){
		return false;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Collidable#setCollisionBounds()
	 */
	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#getCollisionBounds()
	 */
	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		myName = s;
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return myName;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}

}