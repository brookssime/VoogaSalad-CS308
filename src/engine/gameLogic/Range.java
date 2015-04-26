package engine.gameLogic;

import interfaces.Collidable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

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

	@Override
	public boolean evaluateCollision(Collidable collider) {
		if((isCollision(collider))){
			objectsInRange.add(collider); 
			return true;
		}
		return false;
	}

	public void refreshObjects(){
		objectsInRange.clear();
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

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}
}