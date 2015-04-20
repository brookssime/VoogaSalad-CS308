package engine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.EditableTower;
import interfaces.Movable;
import interfaces.Shootable;



public class Tower extends GridObject implements Shootable, Movable{

	
	private Integer myFireRate;
	//private Point2D myLocation;
	private Integer myHealth;
	private Projectile myProjectile;
	private Range myRangeObject;
	private int myRange; // <<--only for Xstream purposes
	private Double myCurRotation;
	private Double myTargetRotation;
	private Double myRotationSpeed;
	private Integer myRad;
	private boolean isReady;
	private Path myPath;


	public Tower(int x, int y, int radius){ //default constructor for circular radius
		//myLocation = new Point2D();
		myRangeObject = new Range(x, y, radius);
		//myLocation.x = x;
		//myLocation.y = y;
	}


	public Tower (String name, String imagePath,  List<String> accessList, int range, int health, int radius, int fireRate, Point2D location) {	
		init(name, imagePath, accessList, range, health, radius, fireRate, location);		
	}

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
		//myLocation = location;
		myHealth = health;
		myRad = radius;
	}

	public String getName() {
		return myName;
	}


	
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
		// TODO Auto-generated method stub		
	}
	
	private void rotate(){
		// TODO
		// increment myCurRotation based on targetRotation
		
		myCurRotation = myCurRotation + myRotationSpeed;
	}
	
	
	public Projectile fire(){
		return myProjectile;
		
	}

	

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
	
	//private GridObject selectTarget(ArrayList<Enemy> inRange){
	@SuppressWarnings("unchecked")
	@Override
	public Collidable selectTarget(List<Collidable> targets) {

		Collections.sort(targets);		
		Collidable target = targets.get(targets.size()-1); //should get the furthest along, for enemies
		if(isHittable(target))
			return target;
		targets.remove(target);
		return selectTarget(targets);
		
		}
		
	
	private boolean isHittable(Collidable c){
		
		// TODO: implement this, if necessary 
		// determine, based on enemy path and other variables, if an enemy is hittable by this tower or not
		
		return true;
	}



	public boolean isDead() {
		return (myHealth <= 0);
	}


	public void setFireRate(Integer fireRate) {
		// TODO Auto-generated method stub
		myFireRate = fireRate;
	}


/*	@Override
	public void setHealth(Integer health) {
		// TODO Auto-generated method stub
		myHealth = health;
	}
*/



	@Override
	public boolean isReady() {
		return isReady;
	}


	@Override
	public Range getRange() {
		// TODO Auto-generated method stub
		return null;
	}



	

}