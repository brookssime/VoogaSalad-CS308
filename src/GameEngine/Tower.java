package GameEngine;

import java.awt.Point;
import java.awt.Shape;
import java.util.List;

import interfaces.Collidable;
import interfaces.Movable;

public class Tower implements Collidable, Movable{

	private String myImageString;
	private List<Integer> myAccessList;
	private Integer myRange;
	private Integer myFireRate;
	private Point myLocation;
	//projectile?
	//state?
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean evaluateCollision(Collidable collider) {
		return false;
		
	}
	
	public void fire(){
		
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
