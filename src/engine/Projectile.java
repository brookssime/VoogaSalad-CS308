package engine;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Projectile extends GridObject implements Collidable, Movable{

	
	private String myImageString;
	private Integer mySpeed; 
	public Effect myEffect;
	private int myRadius;
	private Shape myCollisionBounds;
	private Path myPath;
	
	public Projectile(){
		
	}
	
	public Projectile(Point location, Integer speed, Integer damage, Integer duration, Effect effect){
		
		mySpeed = speed; 
		myEffect = effect;
		myRadius = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	
	public Projectile(Projectile projectile) {
		this.myName = projectile.myName;
		this.myImageString = projectile.myImageString;
		this.mySpeed = projectile.mySpeed;
		this.myEffect = projectile.myEffect;
		this.myRadius = projectile.myRadius;
		this.myCollisionBounds = projectile.myCollisionBounds;
		this.myAccessNames = projectile.myAccessNames;
		this.myName = projectile.myName;
		this.myAccessNames = projectile.myAccessNames;
		
	}
	
	public void setPath(Path p){
		myPath = p;
	}

	public void setRadius(int x){
		myRadius = x;
	}

	
	@Override
	public Placement move() {
		/*myLocation.x += mySpeed * Math.cos(myDirection);
		myLocation.y += mySpeed * Math.sin(myDirection);	*/	
		return myPath.getNext();
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
		// myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRadius*2, myRadius*2);
		
	}
	
	public int getRadius(){
		return myRadius;
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}



}