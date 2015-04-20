/*
 * 
 */
package engine.sprites;

import interfaces.Collidable;

import java.awt.Point;
import java.awt.Shape;

/**
 * The Class Base.
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Base extends GridObject implements Collidable{
	
	/** The my name. */
	private String myName;
	
	/** The my image string. */
	private String myImageString;
	
	/** The my health. */
	private Integer myHealth;
	
	/** The my base id. */
	private Integer myBaseID; //not sure when/if this will be used yet
	
	/** The my rad. */
	private int myRadius;
	
	/** The my collision bounds. */
	private Shape myCollisionBounds;

	/** The my location. */
	private Point myLocation;
		
	/**
	 * Instantiates a new base.
	 */
	public Base(){
		
	}
	

	/**
	 * Instantiates a new base.
	 *
	 * @param imageString the image string
	 * @param health the health
	 * 
	 */
	
	public Base(String imageString, Integer health){
		myImagePath = imageString;
		myHealth = health;
	}
	
	public void setHealth(int health){
		myHealth = health;
	}
	
	public void setRadius(int radius){
		myRadius = radius;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	public int getRadius(){
		return myRadius;
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#evaluateCollision(interfaces.Collidable)
	 */
	@Override
	public boolean evaluateCollision(Collidable collider){
		if(isCollision(collider)){
			if (collider.getClass().isAssignableFrom(Enemy.class)) { 
				myHealth -= ((Enemy) collider).getEnemyDamage(); 
			}
			return true;
		}
		return false; 
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#isDead()
	 */
	@Override
	public boolean isDead() {
		return (myHealth<=0);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Collidable#setCollisionBounds()
	 */
	public void setCollisionBounds() {
		//myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);

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
		
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}