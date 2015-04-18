/*
 * 
 */
package engine;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
 * 
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 *
 * 
 */

public class Enemy implements Collidable, Movable, Authorable {

	private String myName;
	
	/** The my speed. */
	private Integer mySpeed;
	
	/** The my damage. */
	private Integer myDamage;
	
	/** The my health. */
	private Integer myHealth;
	
	/** The my walkable. */
	private List<Integer> myWalkable;
	
	/** The my image string. */
	private String myImageString;
	
	/** The my collision bounds. */
	private Shape myCollisionBounds;
	
	/** The my location. */
	private Point myLocation;
	
	/** The my path. */
	private LinkedList<Point> myPath;
<<<<<<< HEAD
	
	/** The my steps. */
=======
	private LinkedList<Tile> myTilePath;
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
	private LinkedList<Tile> mySteps;
	
	/** The my rad. */
	private int myRad;
	
	/** The tiles walked. */
	private int tilesWalked;
	private Integer myID; // IMPLEMENT CREATING THIS
	
	/** The timer. */
	private Timer timer;
	//orientation??
	//State?

	
	/**
	 * Instantiates a new enemy.
	 */
	public Enemy(){
		myWalkable = new ArrayList<Integer>();
		myTilePath = new LinkedList<Tile>();
	}
	
	/**
	 * Instantiates a new enemy.
	 *
	 * @param location the location
	 * @param path the path
	 */
	public Enemy(Point location, LinkedList<Point> path){
		myLocation = location; 
		myPath = path;
		myWalkable = new ArrayList<Integer>();
		
	}
	
	public List<Integer> getWalkables(){
		return myWalkable;
	}

	

	/**
	 * Sets the steps.
	 *
	 * @param steps the new steps
	 */

	public void setSteps(LinkedList<Tile> steps){
		mySteps = steps;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getID(){
		return myID;
	}
	
	public List<Tile> getTilePath(){
		return myTilePath;
	}
	
	public void setTilePath(LinkedList<Tile> l){
		myTilePath = l; 
	}
	

	/* (non-Javadoc)
	 * @see interfaces.Movable#move()
	 */
	@Override
	public void move() {
		myLocation = myTilePath.removeFirst().getLocation();
		//myLocation.translate();
		tilesWalked++;
	}

	/**
	 * Gets the tiles walked.
	 *
	 * @return the tiles walked
	 */
	public int getTilesWalked() {
		return tilesWalked;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Point getLocation() {
		return myLocation;
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#evaluateCollision(interfaces.Collidable)
	 */
	@Override
	public boolean evaluateCollision(Collidable collider) {
		if (isCollision(collider)) {
			if (collider.getClass().isAssignableFrom(Projectile.class)) {
				executeEffect((Projectile) collider);
			}
			return true;
		}
		return false;

	}
	
	/**
	 * Gets the enemy damage.
	 *
	 * @return the enemy damage
	 */
	public Integer getEnemyDamage(){
		return myDamage;
	}

	/**
	 * Execute effect.
	 *
	 * @param projectile the projectile
	 */
	public void executeEffect(Projectile projectile) {
		// change stuff
		mySpeed -= projectile.myEffect.getSpeedDamage();
		// if its not final do stuff
		if (!projectile.myEffect.isFinal()) {
			timer = new Timer();
			timer.schedule(
					new reverseEffect(projectile.myEffect.getSpeedDamage()),
					projectile.myEffect.getDuration());
		}
	}

	/**
	 * The Class reverseEffect.
	 */
	class reverseEffect extends TimerTask {
		
		/** The speed change. */
		private Integer speedChange;

		/**
		 * Instantiates a new reverse effect.
		 *
		 * @param speed the speed
		 */
		reverseEffect(Integer speed) {
			speedChange = speed;
		}

		/* (non-Javadoc)
		 * @see java.util.TimerTask#run()
		 */
		public void run() {
			mySpeed += speedChange;
			timer.cancel();
		}
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#isDead()
	 */
	@Override
	public boolean isDead() {
		if (myHealth <= 0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#getCollisionBounds()
	 */
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	/* (non-Javadoc)
	 * @see interfaces.Collidable#setCollisionBounds()
	 */
	@Override
	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y,
				myRad * 2, myRad * 2);

	}
	
//	public Enemy(String name, int speed, int damage, int health, List<Integer> walkable, String imageString, 
//			Point location, LinkedList<Point>path, int rad){
//		init(name, speed, damage, health, walkable, imageString, location, path, rad);
//		
//	}
	
//	public void init (String name, int speed, int damage, int health, List<Integer> walkable, String imageString, 
//	Point location, LinkedList<Point>path, int rad){
//myName = name;
//mySpeed = speed;
//myDamage = damage;
//myHealth = health;
//myWalkable = walkable;
//myImageString = imageString;
//myLocation = location;
//myPath = path;
//myRad = rad;
//setCollisionBounds();
//	
//}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}

}
