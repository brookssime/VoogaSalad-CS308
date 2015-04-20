/*
 * 
 */
package gae;

// TODO: Auto-generated Javadoc
/**
 * This interface contains the methods that need to
 * be implemented in the projectile class
 * and that will allow the designer to set the parameters.
 *
 * @author reyinasenatus
 */

public interface EditableProjectile {
	
	/**
	 * Sets the shape.
	 *
	 * @param shape the new shape
	 */
	void setShape(String shape); //the shape of the projectile (circle, rectangle)
	
	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	void setSpeed(double speed); //the speed of the projectile
	
	/**
	 * Damage.
	 *
	 * @param num the num
	 */
	void damage(double num); //the amount of damage the projectile can inflict on an enemy
	
	/**
	 * Duration.
	 *
	 * @param time the time
	 */
	void duration(double time); //the time the damage inflicted to the enemy will last
	
}
