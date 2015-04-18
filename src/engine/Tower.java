/*
 * 
 */
package engine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.EditableTower;
import interfaces.Movable;

// TODO: Auto-generated Javadoc
/**
 * The Class Tower.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */

public class Tower implements Movable, EditableTower, Authorable{



	/** The my name. */
	private String myName;
	
	/** The my image string. */
	private String myImageString;
	
	/** The my access list. */
	private List<Integer> myAccessList;
	
	/** The my fire rate. */
	private Integer myFireRate;
	
	/** The my location. */
	private Point2D myLocation;
	
	/** The my health. */
	private Integer myHealth;
	
	/** The my projectile. */
	private Projectile myProjectile;
	
	/** The my range object. */
	private Range myRangeObject;
	
	/** The my range. */
	private int myRange; // <<--only for Xstream purposes
	
	/** The my cur rotation. */
	private Double myCurRotation;
	
	/** The my target rotation. */
	private Double myTargetRotation;
	
	/** The my rotation speed. */
	private Double myRotationSpeed;
	
	/** The my rad. */
	private Integer myRad;

<<<<<<< HEAD
	/**
	 * Instantiates a new tower.
	 */
	public Tower(){
		
=======

	public Tower(int x, int y, int radius){ //default constructor for circular radius
		myLocation = new Point2D();
		myRangeObject = new Range(x, y, radius);
		myLocation.x = x;
		myLocation.y = y;
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
	}

	/**
	 * Instantiates a new tower.
	 *
	 * @param name the name
	 * @param imagePath the image path
	 * @param accessList the access list
	 * @param range the range
	 * @param health the health
	 * @param radius the radius
	 * @param fireRate the fire rate
	 * @param location the location
	 */
	public Tower (String name, String imagePath,  List<Integer> accessList, int range, int health, int radius, int fireRate, Point2D location) {
		init(name, imagePath, accessList, range, health, radius, fireRate, location);
	}

	/**
	 * Instantiates a new tower.
	 *
	 * @param serializer the serializer
	 * @param data the data
	 * @param location the location
	 */
	public Tower (XStream serializer, String data, Point2D location) {
		Tower incomplete = (Tower)serializer.fromXML(data);
		init(incomplete.myName, incomplete.myImageString, incomplete.myAccessList, incomplete.myRange, incomplete.myHealth, incomplete.myRad, incomplete.myFireRate, location);
	}

	/**
	 * Inits the.
	 *
	 * @param name the name
	 * @param imagePath the image path
	 * @param accessList the access list
	 * @param range the range
	 * @param health the health
	 * @param radius the radius
	 * @param fireRate the fire rate
	 * @param location the location
	 */
	public void init(String name, String imagePath,  List<Integer> accessList, int range, int health, int radius, int fireRate, Point2D location){
		myImageString = imagePath;
		myName = name;
		myAccessList = accessList;
		myRange = range;
		myFireRate = fireRate;
		myLocation = location;
		myHealth = health;
		myRad = radius;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#getName()
	 */
	public String getName() {
		return myName;
	}



	/* (non-Javadoc)
	 * @see interfaces.Movable#move()
	 */

	@Override
	public void move() {
		rotate();
		if(myCurRotation == myTargetRotation){
			fire();
			target();
		}
	}
	
	/**
	 * Rotate.
	 */
	private void rotate(){
		// TODO
		// increment myCurRotation based on targetRotation
		
		myCurRotation = myCurRotation + myRotationSpeed;
	}
	
	
	/**
	 * Fire.
	 */
	private void fire(){
		
		// TODO: implement this
		
	}
	
	/**
	 * Target.
	 */
	private void target(){
		ArrayList<Enemy> inRange = myRangeObject.getEnemiesInRange();
		Enemy e = selectTarget(inRange);
		setTargetRotation(calculateShot(e));
	}
	

	/**
	 * Sets the target rotation.
	 *
	 * @param targetAngle the new target rotation
	 */
	private void setTargetRotation(double targetAngle){
		myTargetRotation = targetAngle;
	}
	

	
<<<<<<< HEAD
	/**
	 * Calculate shot.
	 *
	 * @param e the e
	 * @return the double
	 */
	private Double calculateShot(Enemy e){
=======
	public Double calculateShot(Enemy e){
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
		
		// TODO: implement this
		// math involving the enemy's path, speed, projectile speed, rotation speed, current angle
		// this will be the FIRE RATE implementation as well
		
		// perhaps make turret rotation speed variable based on the time at which an enemy can be 
		// shot (based on fire rate, which will NOT be changing but instead fixed per type of tower)
		
		return Math.toDegrees(Math.atan2(myLocation.y-e.getLocation().y, myLocation.x-e.getLocation().x));
		
		
		
	}
	
	/**
	 * Select target.
	 *
	 * @param inRange the in range
	 * @return the enemy
	 */
	private Enemy selectTarget(ArrayList<Enemy> inRange){
		
		Enemy target = null;
		int i = -1;
		
		for (Enemy e : inRange){
			if(e.getTilesWalked() > i){
				target = e;
				i = e.getTilesWalked();
			}
		}
		
		if(isHittable(target))
			return target;
		inRange.remove(target);
		return selectTarget(inRange);
		
		}
		
	
	/**
	 * Checks if is hittable.
	 *
	 * @param e the e
	 * @return true, if is hittable
	 */
	private boolean isHittable(Enemy e){
		
		// TODO: implement this
		// determine, based on enemy path and other variables, if an enemy is hittable by this tower or not
		
		return true;
	}


	/**
	 * Checks if is dead.
	 *
	 * @return true, if is dead
	 */
	public boolean isDead() {
		return (myHealth <= 0);
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setImageString(java.lang.String)
	 */
	@Override
	public void setImageString(String imageString) {
		// TODO Auto-generated method stub
		myImageString = imageString;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setAccessList(java.util.List)
	 */
	@Override
	public void setAccessList(List<Integer> accessList) {
		// TODO Auto-generated method stub
		myAccessList = accessList;
	}


	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setRange(java.lang.Integer)
	 */

	@Override
	public void setRange(Integer range) {
		// TODO Auto-generated method stub
		myRange = range;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setFireRate(java.lang.Integer)
	 */
	@Override
	public void setFireRate(Integer fireRate) {
		// TODO Auto-generated method stub
		myFireRate = fireRate;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setLocation(com.sun.javafx.geom.Point2D)
	 */
	@Override
	public void setLocation(Point2D location) {
		// TODO Auto-generated method stub
		myLocation = location;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setHealth(java.lang.Integer)
	 */
	@Override
	public void setHealth(Integer health) {
		// TODO Auto-generated method stub
		myHealth = health;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setRadius(java.lang.Integer)
	 */
	@Override
	public void setRadius(Integer radius) {
		// TODO Auto-generated method stub
		myRad = radius;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setProjectile(engine.Projectile)
	 */
	@Override

	public void setProjectile(Projectile projectile) {
		// TODO Auto-generated method stub
		myProjectile = projectile;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#getImageString()
	 */
	@Override
	public String getImageString() {
		// TODO Auto-generated method stub
		return myImageString;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		myName = s;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}

}