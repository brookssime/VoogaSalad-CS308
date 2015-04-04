package GameEngine;

import java.awt.Shape;

import interfaces.Collidable;

public class Base extends Sprite implements Collidable{

	private String imageString;
	private Integer baseID;
	
	public Base(){
		
	}

	@Override
	public void evaluateCollision(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
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
