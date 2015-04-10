package GameEngine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.List;

import com.sun.javafx.geom.Point2D;

public class Enemy implements Collidable, Movable{

	private final int DEFAULT = 5;
	private String myName;
	private Integer mySpeed;
	private Integer myDamage;
	private Integer myHealth;
	private List<Integer> myWalkable;
	private String myImageString;
	private Shape myCollisionBounds;
	private Point2D myLocation;
	private LinkedList<Point2D> myPath;
	private Integer myRad;
	//orientation??
	//State?
	
	public Enemy(String name, int speed, int damage, int health, List<Integer> walkable, String imageString, 
			Point2D location, LinkedList<Point2D>path, int rad){
		init(name, speed, damage, health, walkable, imageString, location, path, rad);
		
	}
	/**
	 * Constructor overloading so that enemy can be implemented with a default
	 */
	public Enemy (String name, List<Integer> walkable, String imageString, Point2D location, LinkedList<Point2D>path){
		mySpeed = DEFAULT;
		myDamage = DEFAULT;
		myHealth = DEFAULT;
		myRad = DEFAULT;
		init(name, mySpeed, myDamage, myHealth, walkable, imageString, location, path, myRad);
		
	}
	
	public void init (String name, int speed, int damage, int health, List<Integer> walkable, String imageString, 
			Point2D location, LinkedList<Point2D>path, int rad){
		myName = name;
		mySpeed = speed;
		myDamage = damage;
		myHealth = health;
		myWalkable = walkable;
		myImageString = imageString;
		myLocation = location;
		myPath = path;
		myRad = rad;
		setCollisionBounds();
			
	}

	@Override
	public void move() {
		myLocation = myPath.removeFirst();
	}
	
	public Point2D getLocation(){
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
