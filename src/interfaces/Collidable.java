/*
 * 
 */
package interfaces;
import java.awt.geom.*;
import java.awt.Shape;

import engine.gameLogic.Effect;


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
	 * Checks if is dead.
	 *
	 * @return true, if is dead
	 */
	boolean isDead(); //TODO: maybe make this a default method?
	
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
		Shape shapeA = c.getCollisionBounds();
		Shape shapeB = this.getCollisionBounds();
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
	    return !areaA.isEmpty();
	}
	
}