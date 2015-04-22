package engine.sprites;

import interfaces.Collidable;
import interfaces.Movable;
import interfaces.Shootable;

import java.util.Collections;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;

import engine.gameLogic.Path;
import engine.gameLogic.Placement;
import engine.gameLogic.Range;

/**
 * The Class Tower.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Tower extends Sprite implements Shootable, Movable{

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
	private boolean isReady;
	private Path myPath;
	
	/**
	 * Default Constructor
	 */
	public Tower() {
		
	}

	/**
	 * Instantiates a new tower.
	 */
	public Tower(int x, int y, int radius){ //default constructor for circular radius
		myRangeObject = new Range(x, y, radius);	
	}

	public Tower (String name, String imagePath,  List<String> accessList, int range, int health, int radius, int fireRate, Point2D location) {	
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
		init(incomplete.myName, incomplete.myImagePath, incomplete.myAccessNames, incomplete.myRange, incomplete.myHealth, incomplete.myRad, incomplete.myFireRate, location);
	}

	public void init(String name, String imagePath,  List<String> accessNames, int range, int health, int radius, int fireRate, Point2D location){
		myImagePath = imagePath;
		myName = name;
		myAccessNames = accessNames;
		myRange = range;
		myFireRate = fireRate;		
		myHealth = health;
		myRad = radius;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Movable#move()
	 */
	@Override
	public Placement move() {
		rotate();
		if(myCurRotation == myTargetRotation){
			isReady = true;
		}
		return myPath.getNext();
	}
	
	@Override
	public void update() {
		// TODO set myPath up here
	}
	
	/**
	 * Rotate.
	 */
	private void rotate(){
		// TODO
		// increment myCurRotation based on targetRotation
		myCurRotation = myCurRotation + myRotationSpeed;
	}
	
	public Projectile fire(){
		return myProjectile;
		
	}
	
	/**
	 * Sets the target rotation.
	 *
	 * @param targetAngle the new target rotation
	 */
	private void setTargetRotation(double targetAngle){
		myTargetRotation = targetAngle;
	}
	
	//public Double calculateShot(Collidable c){

		// TODO: implement this
		// math involving the enemy's path, speed, projectile speed, rotation speed, current angle
		// this will be the FIRE RATE implementation as well
		
		// perhaps make turret rotation speed variable based on the time at which an enemy can be 
		// shot (based on fire rate, which will NOT be changing but instead fixed per type of tower)
		
		//return Math.toDegrees(Math.atan2(myLocation.y-e.getLocation().y, myLocation.x-e.getLocation().x));	
	//}
	
	/**
	 * Select target.
	 *
	 * @param targets
	 * @return list of targets
	 */
	//private Sprite selectTarget(ArrayList<Enemy> inRange){
	
	@SuppressWarnings("unchecked")
	@Override
	public Collidable selectTarget(List<Collidable> targets) {
		Collections.sort(targets);		
		Collidable target = targets.get(targets.size()-1); //should get the furthest along, for enemies
		if(isHittable(target)){
			return target;
		}
		targets.remove(target);
		return selectTarget(targets);
	}
		
	/**
	 * Checks if is hittable.
	 *
	 * @param e the e
	 * @return true, if is hittable
	 */
	
	private boolean isHittable(Collidable c){
		// TODO: implement this, if necessary 
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

	public void setFireRate(Integer fireRate) {
		myFireRate = fireRate;
	}
	
	public Integer getFireRate(){
		return myFireRate;
	}

	public void setHealth(Integer health) {
		myHealth = health;
	}

	public Integer getRange(){
		return myRange;
	}
	
	public void setRange(Integer range){
		myRange = range;
	}

	/* (non-Javadoc)
	 * @see interfaces.EditableTower#getImageString()
	 */
	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public Range getRangeObject() {
		// TODO Auto-generated method stub
		return myRangeObject;
	}
}