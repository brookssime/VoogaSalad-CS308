// This entire file is part of my masterpiece.
// SID GOPINATH

package interfaces;

import java.awt.Shape;
import java.awt.geom.Area;

import engine.gameLogic.Placement;

public interface Collidable extends Comparable{

	void evaluateCollision(Collidable collider);
	void setCollisionHeight(Integer height);
	void setCollisionWidth(Integer width);
	void setCollisionBounds(Integer height, Integer width);
	Integer getCollisionHeight();
	Integer getCollisionWidth();
	Shape getCollisionBounds();
	void setPlacement(Placement placement);
	abstract boolean isDead();
	
	default boolean isCollision(Collidable collider){
		Shape spriteCollidedWith = this.getCollisionBounds();
		Shape spriteCollider = collider.getCollisionBounds();
		Area areaA = new Area(spriteCollidedWith);
		Area areaB = new Area(spriteCollider);
		areaA.intersect(areaB);
		return !areaA.isEmpty();
	}	
}