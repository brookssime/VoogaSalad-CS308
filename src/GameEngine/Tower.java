package GameEngine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;

import interfaces.Collidable;
import interfaces.EditableTower;
import interfaces.Movable;

public class Tower implements Collidable, Movable, EditableTower{

	private String myImageString;
	private String myName;
	private List<Integer> myAccessList;
	private Integer myRange;
	private Integer myFireRate;
	private Point2D myLocation;
	private Integer myHealth;
	private Projectile myProjectile;
	private Point2D myHeading;
	private int myRad;
	private Shape myCollisionBounds;
	private int myRotationSpeed;

	//state?


	public Tower (String name, String imagePath,  List<Integer> accessList, int range, int health, int radius, int fireRate, Point2D location) {
		init(name, imagePath, accessList, range, health, radius, fireRate, location);
	}

	public Tower (XStream serializer, String data, Point2D location) {
		Tower incomplete = (Tower)serializer.fromXML(data);
		init(incomplete.myName, incomplete.myImageString, incomplete.myAccessList, incomplete.myRange, incomplete.myHealth, incomplete.myRad, incomplete.myFireRate, location);
	}

	public String getName() {
		return myName;
	}


	/**
	 * detectEnemy().getLocation();
	 * cos(theta) = (u*v) / (||u|| ||v||)
	 * u and v are vectors originating from the tower
	 */
	@Override
	public void move() {

	}

	/**
	 * Check if enemy is in range
	 * Maybe make this return an Enemy at which to shoot?
	 * TODO
	 * @return
	 */
	public boolean detectEnemy(){
		return false;
	}

	@Override
	public boolean evaluateCollision(Collidable collider) {
		return false;

	}

	/**
	 * Thoughts on how this would work?
	 * Could be accessed by the view somehow?
	 * This would return a projectile which could be used elsewhere
	 * TODO: Help idk how to fully implement this
	 */
	public Projectile spawnProjectile(){
		return myProjectile;
	}

	@Override
	public boolean isDead() {
		return (myHealth <= 0);
	}

	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);

	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
	public void init(String name, String imagePath,  List<Integer> accessList, int range, int health, int radius, int fireRate, Point2D location){
		myImageString = imagePath;
		myName = name;
		myAccessList = accessList;
		myRange = range;
		myFireRate = fireRate;
		myLocation = location;
		myHealth = health;
		myRad = radius;
		setCollisionBounds();
	}

	@Override
	public String setName() {
		return myName;
	}

	@Override
	public String setImageString() {
		return myImageString;
	}

	@Override
	public List<Integer> setAccessList() {
		return myAccessList;
	}

	@Override
	public Integer setRange() {
		return myRange;
	}

	@Override
	public Integer setFireRate() {
		return myFireRate;
	}

	@Override
	public Point2D setLocation() {
		return myLocation;
	}

	@Override
	public Integer setHealth() {
		return myHealth;
	}

	@Override
	public Integer setRad() {
		return myRad;
	}
}