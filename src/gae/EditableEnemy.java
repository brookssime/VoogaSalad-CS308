/*
 * 
 */
package gae;

// TODO: Auto-generated Javadoc
/**
 * This interface contains the methods that need to
 * be implemented in the enemy class
 * and that will allow the designer to set the parameters.
 *
 * @author reyinasenatus
 */

public interface EditableEnemy {
	
	/**
	 * Sets the image.
	 */
	void setImage(); //the image of the tower
	
	/**
	 * Sets the health.
	 *
	 * @param health the new health
	 */
	void setHealth(double health); //set the health of the enemy
	
	/**
	 * Inits the location.
	 *
	 * @param x the x
	 * @param y the y
	 */
	void initLocation(double x, double y); //sets the initial location of the enemy
	
	//TODO: Determine what parameters are needed for the path
	/**
	 * Sets the path.
	 */
	void setPath(); //sets the path of the enemy
	
	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	void setSpeed(double speed); //sets the speed of an enemy (default 0 for non walkable)
	
	/**
	 * Sets the damage.
	 *
	 * @param damage the new damage
	 */
	void setDamage(double damage); //sets the amount of damage the enemy inflicts
	
}
