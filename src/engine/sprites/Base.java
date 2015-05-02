
package engine.sprites;

import interfaces.Collidable;
import interfaces.MethodAnnotation;

import java.awt.Point;
import java.awt.Shape;

import com.sun.javafx.geom.Ellipse2D;

import engine.gameLogic.Placement;

public class Base extends Sprite implements Collidable{

	private Integer myHealth;
	private Point myLocation;
	protected Placement myPlacement;
	private Integer myCollisionHeight;
	private Integer myCollisionWidth;
	private Shape myCollisionBounds;
	
	public Base() {
		
	}
	
	public Base(String imageString, Integer health){
		myImagePath = imageString;
		myHealth = health;
	}
	
	@MethodAnnotation(editor=true, name = "Set Health", type = "textfield", fieldName = "myHealth")
	public void setHealth(Integer health){
		myHealth = health;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	@Override
	public void evaluateCollision(Collidable collider){
		if (isCollision(collider) && collider.getClass().isAssignableFrom(Enemy.class)) {
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
	
	public Point getLocation(){
		return myLocation;
	}
	
	public void setLocation(Point location){
		myLocation = location;
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
	public void setCollisionHeight(Integer height) {
		myCollisionHeight = height;
		
	}

	@Override
	public void setCollisionWidth(Integer width) {
		myCollisionWidth = width;
		
	}

	@Override
	public void setCollisionBounds(Integer height, Integer width) {
		myCollisionBounds = (Shape) new Ellipse2D(myPlacement.getLocation().x, myPlacement.getLocation().y, myCollisionHeight, myCollisionWidth);
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	/**
	 * this and other set methods would be used by GAE
	 * @param placement
	 */
	@Override
	public void setPlacement(Placement placement) {
		myPlacement = placement;
	}	
}