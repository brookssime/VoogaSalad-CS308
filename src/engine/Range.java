package GameEngine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import interfaces.Collidable;

public class Range implements Collidable{
	
	private ArrayList<Enemy> enemiesInRange = new ArrayList<Enemy>();
	private Shape myCollisionBounds;
	private Point myLocation;
	private int myRad;
	
	public Range(){
		
	}

	public ArrayList<Enemy> getEnemiesInRange(){
		return enemiesInRange;
	}
	
	@Override
	public boolean evaluateCollision(Collidable collider) {
		if(!(collider.getClass() == Enemy.class)){
			enemiesInRange.add((Enemy)collider); 
			return true;
		}
			return false;
	}
	
	private void refreshEnemies(){
		// clear enemies that have died / left range --> updating enemiesInRange
		// alternatively, clear it on every cycle and simply re-add enemies? probably not
	}

	@Override
	public boolean isDead() {
		return true; // THIS SHOULDNT HAVE A DEAD FIELD
	}

	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);
		
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
}
