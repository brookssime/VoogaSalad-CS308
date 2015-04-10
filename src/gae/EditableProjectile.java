package gae;

/**
 * This interface contains the methods that need to
 * be implemented in the projectile class
 * and that will allow the designer to set the parameters
 * 
 * @author reyinasenatus
 *
 */

public interface EditableProjectile {
	
	void setShape(String shape); //the shape of the projectile (circle, rectangle)
	
	void setSpeed(double speed); //the speed of the projectile
	
	void damage(double num); //the amount of damage the projectile can inflict on an enemy
	
	void duration(double time); //the time the damage inflicted to the enemy will last
	
}
