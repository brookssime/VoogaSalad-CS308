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
public class Range implements Collidable{

	/** The my name. */
	private String myName;
	

	/** The objects in range. */
	private ArrayList<Collidable> objectsInRange = new ArrayList<Collidable>();

	/** The my collision bounds. */
	private Shape myCollisionBounds;

	
	


	/** The my location. */
	private Point myLocation;

	/** The my rad. */
	private int myRad;


	/**
	 * Instantiates a new range.
	 */
	public Range(){

	}

	public Range(int x, int y, int r){
		myCollisionBounds = new Ellipse2D.Double(x, y, r, r);
	}

	public ArrayList<Collidable> getObjectsInRange(){
		return objectsInRange;
	}


	//REFACTOR THIS to allow for use by BOTH ENEMIES AND TOWERS--ie discriminate based on ID, name, etc.
	
	@Override
	public boolean evaluateCollision(Collidable collider) {
		if(!(collider.getClass() == Enemy.class)){
			objectsInRange.add(collider); 
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

	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
