package interfaces;
import java.awt.geom.*;
import java.awt.Shape;

public interface Collidable {

	boolean evaluateCollision(Collidable collidable);
	boolean isDead();
	void setCollisionBounds();
	Shape getCollisionBounds();
	
	
	default boolean isCollision(Collidable c){
		Shape shapeA = c.getCollisionBounds();
		Shape shapeB = this.getCollisionBounds();
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
	    return !areaA.isEmpty();
	}
	
}
