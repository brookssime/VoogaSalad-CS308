package interfaces;
import java.awt.geom.*;
import java.awt.Shape;

import engine.Effect;

public interface Collidable extends Comparable{

	boolean evaluateCollision(Collidable collider);
	boolean isDead(); //TODO: maybe make this a default method?
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