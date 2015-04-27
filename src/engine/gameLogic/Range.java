package engine.gameLogic;

import interfaces.Collidable;

import java.util.ArrayList;

import engine.sprites.Sprite;

public class Range extends Sprite implements Collidable{

	private ArrayList<Collidable> objectsInRange = new ArrayList<Collidable>();
	private Integer myCollisionHeight;
	private Integer myCollisionWidth;

	public Range(){
		
	}

	public ArrayList<Collidable> getObjectsInRange(){
		ArrayList<Collidable> newObjectsInRange =  objectsInRange;
		objectsInRange.clear();
		return newObjectsInRange;		
	}

	@Override
	public void evaluateCollision(Collidable collider) {
		objectsInRange.add(collider); 
	}

	public void refreshObjects(){
		objectsInRange.clear();
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

	@Override
	public void setCollisionHeight(Integer height) {
		myCollisionHeight = height;
	}

	@Override
	public void setCollisionWidth(Integer width) {
		myCollisionWidth = width;	
	}

	@Override
	public Integer getCollisionHeight() {
		return myCollisionHeight;
	}

	@Override
	public Integer getCollisionWidth() {
		return myCollisionWidth;
	}

	@Override
	public Placement move() {
		return null;
	}

	@Override
	public void fillSpriteInfo() {
		
	}
}