/*
 * 
 */
package engine.sprites;

import interfaces.Collidable;

import java.awt.Point;
import java.awt.Shape;

public class Base extends Sprite implements Collidable{
	
	private String myName;
	private String myImageString;
	private Integer myHealth;
	private Integer myBaseID; //not sure when/if this will be used yet
	private int myRadius;
	private Shape myCollisionBounds;
	private Point myLocation;

	public Base(String imageString, Integer health){
		myImagePath = imageString;
		myHealth = health;
	}
	
	public void setHealth(int health){
		myHealth = health;
	}
	
	public void setRadius(int radius){
		myRadius = radius;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	public int getRadius(){
		return myRadius;
	}

	@Override
	public boolean evaluateCollision(Collidable collider){
		if(isCollision(collider)){
			if (collider.getClass().isAssignableFrom(Enemy.class)) { 
				myHealth -= ((Enemy) collider).getEnemyDamage(); 
			}
			return true;
		}
		return false; 
	}

	@Override
	public boolean isDead() {
		return (myHealth<=0);
	}

	public void setCollisionBounds() {
		//myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);

	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}