/*
 * 
 */
package interfaces;

public interface Collidable extends Comparable{

	void evaluateCollision(Collidable collider);
	void setCollisionHeight(Integer height);
	void setCollisionWidth(Integer width);
	Integer getCollisionHeight();
	Integer getCollisionWidth();
	boolean isDead();
	
	
}