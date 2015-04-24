package engine.sprites;

import interfaces.Collidable;
import interfaces.Movable;
import interfaces.MovementStrategy;

import java.awt.Shape;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import engine.Path;
import engine.gameLogic.Placement;

public class Enemy extends Sprite implements Collidable, Movable {


	private Integer mySpeed;
	private MovementStrategy myMovement;
	private Integer myDamage;
	private Integer myHealth;
	private Shape myCollisionBounds;
	private LinkedList<Tile> myTilePath;
	//private int myRad; //TODO: Purpose of this?
	private Timer timer; //TODO: Do we need this in the EnemyClass?
	//private Double distanceWalked; //TODO: Purpose of this?
	private Path myPath;

	public Enemy(){
		myTilePath = new LinkedList<Tile>();
	}

	public void setHealth(int x){
		myHealth = x;
	}
	
	public void setSpeed(int x){
		mySpeed = x;
	}
	
	public void setDamage(int x){
		myDamage = x;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	public int getSpeed(){
		return mySpeed;
	}
	
	public int getDamage(){
		return myDamage;
	}
	
	//TODO: Fix this with new projectile info
	public void executeEffect(Projectile projectile) {
	/*	// change stuff
		mySpeed -= projectile.myEffect.getSpeedDamage();
		// if its not final do stuff
		if (!projectile.myEffect.isFinal()) {
			timer = new Timer();
			timer.schedule(
					new reverseEffect(projectile.myEffect.getSpeedDamage()),
					projectile.myEffect.getDuration());
		}
		*/
	}

	
	public void setSteps(LinkedList<Tile> steps) {
		myTilePath = steps;
	}

	public List<String> getWalkables() {
		return myAccessNames;
	}

	public void setPath(Path p) {
		myPath = p.generateNew();
	}

	public List<Tile> getTilePath() {
		return myTilePath;

	}

	public void setTilePath(LinkedList<Tile> tilePath) {
		myTilePath = tilePath;
	}

	public Integer getEnemyDamage() {
		return myDamage;
	}

	//TODO: Is this class required?
	class reverseEffect extends TimerTask {

		private Integer speedChange;

		private reverseEffect(Integer speed) {
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
		// myCollisionBounds = new Ellipse2D.Double(myLocation.x,
		// myLocation.y,myRad * 2, myRad * 2);

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Placement move() {
		return myPath.getNext();
	}

	@Override
	public boolean evaluateCollision(Collidable collider) {
		// TODO Auto-generated method stub
		return false;
	}

	public MovementStrategy getMovement() {
		return myMovement;
	}
}