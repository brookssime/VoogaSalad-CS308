/*
 * 
 */
package interfaces;
import java.awt.Shape;
import java.awt.geom.Area;

public interface Collidable extends Comparable{

	boolean evaluateCollision(Collidable collider);
	void setCollisionBounds();
	Shape getCollisionBounds();
	abstract boolean isDead();
	
	default boolean isCollision(Collidable c){
		Shape shapeA = c.getCollisionBounds(); //doesn't work without location
		Shape shapeB = this.getCollisionBounds();
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
	    return !areaA.isEmpty();
	}
	
}