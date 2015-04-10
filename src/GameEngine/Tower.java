package GameEngine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import interfaces.Collidable;
import interfaces.Movable;

public class Tower implements Movable{

	private String myImageString;
	private List<Integer> myAccessList;
	private Integer myFireRate;
	private Point myLocation;
	private Integer myHealth;
	private Projectile myProjectile;
	private Range myRange;
	private Double myCurRotation;
	private Double myTargetRotation;
	private Double myRotationSpeed;
	//state?
	
	
	/**
	 * detectEnemy().getLocation();
	 * cos(theta) = (u*v) / (||u|| ||v||)
	 * u and v are vectors originating from the tower
	 */
	
	@Override
	public void move() {
		rotate();
		if(myCurRotation == myTargetRotation){
			fire();
			target();
		}
	}
	
	private void rotate(){
		// TODO
		// increment myCurRotation based on targetRotation
		
		myCurRotation = myCurRotation + myRotationSpeed;
	}
	
	
	private void fire(){
		
		// TODO: implement this
		
	}
	
	private void target(){
		ArrayList<Enemy> inRange = myRange.getEnemiesInRange();
		Enemy e = selectTarget(inRange);
		setTargetRotation(calculateShot(e));
	}
	

	private void setTargetRotation(double targetAngle){
		myTargetRotation = targetAngle;
	}
	

	
	private Double calculateShot(Enemy e){
		
		// TODO: implement this
		// math involving the enemy's path, speed, projectile speed, rotation speed, current angle
		// this will be the FIRE RATE implementation as well
		
		// perhaps make turret rotation speed variable based on the time at which an enemy can be 
		// shot (based on fire rate, which will NOT be changing but instead fixed per type of tower)
		
		return Math.atan2(myLocation.y-e.getLocation().y, myLocation.x-e.getLocation().x);
		
		
		
	}
	
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
		
	
	private boolean isHittable(Enemy e){
		
		// TODO: implement this
		// determine, based on enemy path and other variables, if an enemy is hittable by this tower or not
		
		return true;
	}
	
	
	
	/**
	 * Check if enemy is in range
	 * Maybe make this return an Enemy at which to shoot?
	 * TODO: Brooks yay
	 * @return
	 */
	public boolean detectEnemy(){
		//1. Determine a list of possible enemies to target, instead of checking every possible enemy
		//2. Determine which of these should be selected--furthest along the path? closest?u
		//3. Determine the location to target, based on enemy's speed, location, projected path, etc.
		//4. Support targeting multiple enemies, for towers that might shoot multiple projectiles simultaneously
		
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


	public boolean isDead() {
		return (myHealth <= 0);
	}
	

}