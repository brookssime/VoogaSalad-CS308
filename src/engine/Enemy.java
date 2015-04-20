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

public class Enemy extends GridObject implements Collidable, Movable {


	private Integer mySpeed;
	private Integer myDamage;
	private Integer myHealth;
	private Shape myCollisionBounds;
	private LinkedList<Tile> myTilePath;
	private int myRad;
	private Double distanceWalked;
	private Timer timer;
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
		}*/
	}
	

	public List<String> getWalkables(){
		return myAccessNames;
	}

	
	void setPath(Path p){
		myPath = p.generateNew();
		
	}
	
	public List<Tile> getTilePath(){
		return myTilePath;
	}
	
	public void setTilePath(LinkedList<Tile> l){
		myTilePath = l; 
	}
	

	@Override
	public Placement move() {
		
		//TODO: INCREMENT distancewalked so compareTo stays useful
		
		return myPath.getNext();
		//myLocation.translate();
		//tilesWalked++;
		
		
	}

/*	public int getTilesWalked() {
		return distanceWalked;
	}
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
	
	public Integer getEnemyDamage(){
		return myDamage;
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
		//myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y,myRad * 2, myRad * 2);

	}

	@Override
	public int compareTo(Object o) {
		
		//MAKE SURE this works
		
		return (this.distanceWalked).compareTo((((Enemy)o).distanceWalked));
	}


	


}
