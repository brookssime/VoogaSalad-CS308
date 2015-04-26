/*
 * 
 */
package interfaces;
import java.awt.Shape;
import java.awt.geom.Area;


// TODO: Auto-generated Javadoc
/**
 * The Interface Collidable.
 */

public interface Collidable extends Comparable{

	/**
	 * Evaluate collision.
	 *
	 * @param collider the collider
	 * @return true, if successful
	 */
	boolean evaluateCollision(Collidable collider);
	

	
	/**
	 * Sets the collision bounds.
	 */
	void setCollisionBounds();
	
	/**
	 * Gets the collision bounds.
	 *
	 * @return the collision bounds
	 */
	Shape getCollisionBounds();
	
	
	/**
	 * Checks if is collision.
	 *
	 * @param c the c
	 * @return true, if is collision
	 */
	default boolean isCollision(Collidable c){
		Shape shapeA = c.getCollisionBounds(); //doesn't work without location
		Shape shapeB = this.getCollisionBounds();
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
	    return !areaA.isEmpty();
	}
	
}