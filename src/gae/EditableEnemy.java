package gae;

/**
 * This interface contains the methods that need to
 * be implemented in the enemy class
 * and that will allow the designer to set the parameters
 * 
 * @author reyinasenatus
 *
 */

public interface EditableEnemy {
	
	void setImage(); //the image of the tower
	
	void setHealth(double health); //set the health of the enemy
	
	void initLocation(double x, double y); //sets the initial location of the enemy
	
	//TODO: Determine what parameters are needed for the path
	void setPath(); //sets the path of the enemy
	
	void setSpeed(double speed); //sets the speed of an enemy (default 0 for non walkable)
	
	void setDamage(double damage); //sets the amount of damage the enemy inflicts
	
}
