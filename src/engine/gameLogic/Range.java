package engine.gameLogic;

import interfaces.Collidable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import engine.sprites.Enemy;

public class Range implements Collidable{

	private ArrayList<Collidable> objectsInRange = new ArrayList<Collidable>();
	private Shape myCollisionBounds;
	private Point myLocation;
	private int myRadius;

	public Range(int x, int y, int r){
		myCollisionBounds = new Ellipse2D.Double(x, y, r, r);
	}

	public ArrayList<Collidable> getObjectsInRange(){
		ArrayList<Collidable> newObjectsInRange =  objectsInRange;
		objectsInRange.clear();
		return newObjectsInRange;		
	}

	//TODO: REFACTOR THIS to allow for use by BOTH ENEMIES AND TOWERS--ie discriminate based on ID, name, etc.
	@Override
	public boolean evaluateCollision(Collidable collider) {
		if(!(collider.getClass() == Enemy.class)){
			objectsInRange.add(collider); 
			return true;
		}
		return false;
	}

	/**
	 * Refresh enemies.
	 * TODO: Finish this
	 */
	private void refreshObjects(){
		objectsInRange.clear(); // TODO figure out where this gets called in the loop -- currently nowhere
	}

	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRadius*2, myRadius*2);
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}