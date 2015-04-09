package GameEngine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import interfaces.Collidable;
import interfaces.Movable;

public class Tower implements Collidable, Movable{

	private String myImageString;
	private List<Integer> myAccessList;
	private Integer myRange;
	private Integer myFireRate;
	private Point myLocation;
	private Integer myHealth;
	private Projectile myProjectile;
	private int myRad;
	private Shape myCollisionBounds;
	private int myRotationSpeed;
	
	
	/**
	 * detectEnemy().getLocation();
	 * cos(theta) = (u*v) / (||u|| ||v||)
	 * u and v are vectors originating from the tower
	 */
	@Override
	public void move() {
		
	}
	
	/**
	 * Check if enemy is in range
	 * Maybe make this return an Enemy at which to shoot?
	 * TODO
	 * @return
	 */
	public boolean detectEnemy(){
		 return false;
	}

	@Override
	public boolean evaluateCollision(Collidable collider) {
		return false;
		
	}
	
	/**
	 * Thoughts on how this would work?
	 * Could be accessed by the view somehow?
	 * This would return a projectile which could be used elsewhere
	 * TODO: Help idk how to fully implement this
	 */
	public Projectile spawnProjectile(){
		return myProjectile;
	}

	@Override
	public boolean isDead() {
		return (myHealth <= 0);
	}
	
	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);
		
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
}