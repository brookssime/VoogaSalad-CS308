package GameEngine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import interfaces.Collidable;

public class Base implements Collidable{

	private String myImageString;
	private Integer myHealth;
	private Integer myBaseID; //not sure when/if this will be used yet
	private int myRad;
	private Shape myCollisionBounds;
	private Point myLocation;
	
	
	public Base(String imageString, Integer health, Integer baseID){
		myImageString = imageString;
		myHealth = health;
		myBaseID = baseID;
	}

	@Override
	public boolean evaluateCollision(Collidable collider){
		if(isCollision(collider)){
			//TODO: COLLIDE
			return true;
		}
		return false; 
	}

	@Override
	public boolean isDead() {
		return (myHealth<=0);
	}
	
	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);

	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
}