/*
 * 
 */
package engine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import interfaces.Authorable;
import interfaces.Collidable;

// TODO: Auto-generated Javadoc
/**
 * The Class Range.
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 * 
 */
public class Range implements Collidable, Authorable{
	
	/** The my name. */
	private String myName;
	
	/** The enemies in range. */
	private ArrayList<Enemy> enemiesInRange = new ArrayList<Enemy>();
	
	/** The my collision bounds. */
	private Shape myCollisionBounds;
	
	/** The my location. */
	private Point myLocation;
	
	/** The my rad. */
	private int myRad;
	
<<<<<<< HEAD
	/**
	 * Instantiates a new range.
	 */
	public Range(){
		
=======
	public Range(int x, int y, int r){
		myCollisionBounds = new Ellipse2D.Double(x, y, r, r);
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
	}

	/**
	 * Gets the enemies in range.
	 *
	 * @return the enemies in range
	 */
	public ArrayList<Enemy> getEnemiesInRange(){
		return enemiesInRange;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Collidable#evaluateCollision(interfaces.Collidable)
	 */
	@Override
	public boolean evaluateCollision(Collidable collider) {
		if(!(collider.getClass() == Enemy.class)){
			enemiesInRange.add((Enemy)collider); 
			return true;
		}
			return false;
	}
	
	/**
	 * Refresh enemies.
	 */
	private void refreshEnemies(){
		// clear enemies that have died / left range --> updating enemiesInRange
		// alternatively, clear it on every cycle and simply re-add enemies? probably not
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#isDead()
	 */
	@Override
	public boolean isDead() {
		return true; // THIS SHOULDNT HAVE A DEAD FIELD
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
