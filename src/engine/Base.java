package engine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import interfaces.Authorable;
import interfaces.Collidable;

public class Base extends GridObject implements Collidable{

	private Integer myHealth;
	private int myRadius;
	private Shape myCollisionBounds;
	private Point myLocation;
	
	
	public Base(){
		
	}
	
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
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRadius*2, myRadius*2);

	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}