package engine.sprites;

import interfaces.Collidable;

import java.awt.Shape;

import engine.Path;
import engine.gameLogic.Placement;
import engine.gameLogic.ProjectileEffect;

/**
 * The Class Projectile.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Projectile extends Sprite implements Collidable{

	/** The my name. */
	private String myName;
	
	/** The my image string. */
	private String myImageString;
	
	/** The my speed. */
	private Integer mySpeed; 
	
	/** The my effect. */
	public ProjectileEffect myEffect;
	
	/** The my rad. */
	private int myRadius;
	
	/** The my collision bounds. */
	private Shape myCollisionBounds;
	private Path myPath;
	
	/**
	 * Instantiates a new projectile.
	 */
	public Projectile(){
		
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
		return myPath.getNextPlacement();
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
		// myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRadius*2, myRadius*2);		
	}
	
	public int getRadius(){
		return myRadius;
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#getCollisionBounds()
	 */
	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
	
	public ProjectileEffect getEffect(){
		return myEffect;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}