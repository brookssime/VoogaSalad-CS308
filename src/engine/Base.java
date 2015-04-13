/*
 * 
 */
package engine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import interfaces.Authorable;
import interfaces.Collidable;

// TODO: Auto-generated Javadoc
/**
 * The Class Base.
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Base implements Collidable, Authorable{

	/** The my name. */
	private String myName;
	
	/** The my image string. */
	private String myImageString;
	
	/** The my health. */
	private Integer myHealth;
	
	/** The my base id. */
	private Integer myBaseID; //not sure when/if this will be used yet
	
	/** The my rad. */
	private int myRad;
	
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
	 * @param baseID the base id
	 */
	public Base(String imageString, Integer health, Integer baseID){
		myImageString = imageString;
		myHealth = health;
		myBaseID = baseID;
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
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}