package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.List;

public class Enemy implements Collidable, Movable{

	private Integer mySpeed;
	private Integer myDamage;
	private List<Integer> myWalkable;
	private String myImageString;
	private Shape myCollisionBounds;
	private Point myLocation;
	private LinkedList<Point> myPath;
	private int myRad;
	//State?
	
	public Enemy(Point location, LinkedList<Point> path){
		myLocation = location; myPath = path;
		myRad = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
	}
	

	@Override
	public void move() {
		myLocation = myPath.removeFirst();
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
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);
		
	}

}
