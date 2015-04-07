package GameEngine;

import java.awt.Shape;

import interfaces.Collidable;

public class Base implements Collidable{

	private String myImageString;
	private Integer myHealth;
	private Integer myBaseID; //not sure when/if this will be used yet
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape getCollisionBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}