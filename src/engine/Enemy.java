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

public class Enemy implements Collidable, Movable, Authorable {

	private String myName;
	private Integer mySpeed;
	private Integer myDamage;
	private Integer myHealth;
	private List<Integer> myWalkable;
	private String myImageString;
	private Shape myCollisionBounds;
	private Point myLocation;
	private LinkedList<Point> myPath;
	private LinkedList<Tile> myTilePath;
	private LinkedList<Tile> mySteps;
	private int myRad;
	private int tilesWalked;

	private Integer myID; // IMPLEMENT CREATING THIS
	private Timer timer;
	//orientation??
	//State?
	
	public Enemy(){
		myWalkable = new ArrayList<Integer>();
		myTilePath = new LinkedList<Tile>();
	}
	
	public Enemy(Point location, LinkedList<Point> path){
		myLocation = location; 
		myPath = path;
		myWalkable = new ArrayList<Integer>();
		
	}
	
	public List<Integer> getWalkables(){
		return myWalkable;
	}

	
	public void setSteps(LinkedList<Tile> steps){
		mySteps = steps;
	}
	
	public Integer getID(){
		return myID;
	}
	
	public List<Tile> getTilePath(){
		return myTilePath;
	}
	
	public void setTilePath(LinkedList<Tile> l){
		myTilePath = l; 
	}
	

	@Override
	public void move() {
		myLocation = myTilePath.removeFirst().getLocation();
		//myLocation.translate();
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

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}

}
