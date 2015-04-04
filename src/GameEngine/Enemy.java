package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Enemy extends Sprite implements Collidable, Movable{

	private Integer mySpeed;
	private Integer myDamage;
	private List<Integer> myWalkable;
	private String myImageString;
	private Shape myCollisionBounds;
	private int myX;
	private int myY;
	private int myRad;
	//State?
	//Path?
	
	public Enemy(int x, int y){
		myX = x; myY = y;
		myRad = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
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
	
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
	@Override
	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myX, myY, myRad*2, myRad*2);
		
	}

}
