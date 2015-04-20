package engine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import interfaces.Authorable;
import interfaces.Collidable;

public class Range implements Collidable, Authorable{
	
	private String myName;
	private ArrayList<Collidable> objectsInRange = new ArrayList<Collidable>();
	private Shape myCollisionBounds;
	private Point myLocation;
	private int myRad;
	
	public Range(int x, int y, int r){
		myCollisionBounds = new Ellipse2D.Double(x, y, r, r);
	}

	public ArrayList<Collidable> getObjectsInRange(){
		return objectsInRange;
	}
	
	
	//REFACTOR THIS to allow for use by BOTH ENEMIES AND TOWERS--ie discriminate based on ID, name, etc.
	@Override
	public boolean evaluateCollision(Collidable collider) {
		if(!(collider.getClass() == Enemy.class)){
			objectsInRange.add(collider); 
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
