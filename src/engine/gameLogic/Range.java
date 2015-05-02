package engine.gameLogic;

import interfaces.Collidable;
import interfaces.MethodAnnotation;

import java.awt.Shape;
import java.util.ArrayList;

import com.sun.javafx.geom.Ellipse2D;

import engine.sprites.Sprite;

public class Range extends Sprite implements Collidable{

	private ArrayList<Collidable> objectsInRange = new ArrayList<Collidable>();
	private Integer myCollisionHeight;
	private Integer myCollisionWidth;
	private Shape myCollisionBounds;
	Placement myPlacement;

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
		return 0;
	}

	@Override
	public boolean isDead() {
		return false;
	}

	@Override
	@MethodAnnotation(editor=true, name="Set Collision Height", type="textfield", fieldName="myCollisionHeight")
	public void setCollisionHeight(Integer height) {
		myCollisionHeight = height;
	}

	@Override
	@MethodAnnotation(editor=true, name="Set Collision Width", type="textfield", fieldName="myCollisionWidth")
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

	@Override
	public void setCollisionBounds(Integer height, Integer width) {
		myCollisionBounds = (Shape) new Ellipse2D(myPlacement.getLocation().x, myPlacement.getLocation().y, myCollisionHeight, myCollisionWidth);
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	@Override
	public void setPlacement(Placement placement) {
		myPlacement = placement;
	}
}