
package engine.sprites;

import interfaces.Collidable;
import interfaces.MethodAnnotation;

import java.awt.Shape;
import java.awt.Point;

import interfaces.Collidable;
import engine.gameLogic.Placement;

public class Base extends Sprite implements Collidable{

	private Integer myHealth;
	private int myCollisionHeight;
	private int myCollisionWidth;
	private Point myLocation;
	
	public Base() {
		
	}
	
	public Base(String imageString, Integer health){
		myImagePath = imageString;
		myHealth = health;
	}
	
	@MethodAnnotation(editor=true, name = "Set Health", type = "textfield", fieldName = "myHealth")
	public void setHealth(int health){
		myHealth = health;
	}
	
//	@MethodAnnotation(editor=true, name = "Set Radius", type = "textfield", fieldName = "myRadius")
//	public void setRadius(int radius){
//		myRadius = radius;
//	}
	
	public int getHealth(){
		return myHealth;
	}
	
	@Override
	public void evaluateCollision(Collidable collider){
		if (collider.getClass().isAssignableFrom(Enemy.class)) {
			myHealth -= ((Enemy) collider).getEnemyDamage();
		}
	}

	@Override
	public boolean isDead() {
		return (myHealth<=0);
	}


	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Placement move() {
		return null;
	}

	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
		mySpriteInfo.put("Health", myHealth.toString());
	}

	@Override
	@MethodAnnotation(editor=true, name = "Set Collision Height", type = "textfield", fieldName = "myCollisionHeight")
	public void setCollisionHeight(Integer height) {
		myCollisionHeight = height;
	}

	@Override
	@MethodAnnotation(editor=true, name = "Set Collision Width", type = "textfield", fieldName = "myCollisionWidth")
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
	
	public Point getLocation(){
		return myLocation;
	}
	
	public void setLocation(Point location){
		myLocation = location;
	}
	
}