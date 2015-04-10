package engine;

import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Enemy implements Collidable, Movable {

	private final int DEFAULT = 5;
	private String myName;
	private Integer mySpeed;
	private Integer myDamage;
	private Integer myHealth;
	private List<Integer> myWalkable;
	private String myImageString;
	private Shape myCollisionBounds;
	private Point myLocation;
	private LinkedList<Point> myPath;
	private LinkedList<Tile> mySteps;
	private int myRad;
	private int tilesWalked;
	private Integer myID; // IMPLEMENT CREATING THIS
	//orientation??
	//State?
	private Timer timer;

	public Enemy(Point location, LinkedList<Point> path) {
		myLocation = location;
		myPath = path;
		myRad = 5; // DEFAULT VAL FOR THIS CONSTRUCTOR
		setCollisionBounds();
		tilesWalked = 0;
	}

	

	public void setSteps(LinkedList<Tile> steps){
		mySteps = steps;
	}
	
	public Integer getID(){
		return myID;
	}
	


	@Override
	public void move() {
		myLocation = myPath.removeFirst();
		tilesWalked++;
	}

	public int getTilesWalked() {
		return tilesWalked;
	}

	public Point getLocation() {
		return myLocation;
	}

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
	
	public Integer getEnemyDamage(){
		return myDamage;
	}

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

	class reverseEffect extends TimerTask {
		private Integer speedChange;

		reverseEffect(Integer speed) {
			speedChange = speed;
		}

		public void run() {
			mySpeed += speedChange;
			timer.cancel();
		}
	}

	@Override
	public boolean isDead() {
		if (myHealth <= 0) {
			return true;
		}
		return false;
	}

	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

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

}
