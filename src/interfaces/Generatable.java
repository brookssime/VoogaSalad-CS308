package interfaces;

/**
 * The objects that are generated by other objects.
 * ex. An enemy that was made by other enemies
 * ex. An projectile made by a tower
 * ex. a tower made by the store
 * @author brookssime
 *
 */

public interface Generatable {
	
	void setInitialPosition(double x, double y);
	void setMover(Mover mover);
	void dispatch();

}
