package engine;

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
	private Integer myHealth;
	private List<Integer> myWalkable;
	private String myImageString;
	private Shape myCollisionBounds;
	private Point myLocation;
	private LinkedList<Point> myPath;
	private int myRad;
	private int tilesWalked;
	//orientation??
	//State?
	
	public Enemy(Point location, LinkedList<Point> path){
		myLocation = location; myPath = path;
		myRad = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
		tilesWalked = 0;
	}
	

	@Override
	public void move() {
		myLocation = myPath.removeFirst();
		tilesWalked++;
	}
	
	public int getTilesWalked(){
		return tilesWalked;
	}
	
	public Point getLocation(){
		return myLocation;
	}
	
	@Override
	public boolean evaluateCollision(Collidable collider) {
		if(isCollision(collider)){
			//TODO: COLLIDEEEEEE
			return true;
		}
		return false;
		
	}
	@Override

	public boolean isDead() {
		if(myHealth <= 0){
			return true;
		}
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
