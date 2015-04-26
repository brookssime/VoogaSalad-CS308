package engine.sprites;

import interfaces.Collidable;

import java.awt.Shape;

import engine.Path;
import engine.gameLogic.Placement;
import engine.gameLogic.ProjectileEffect;

/**
 * The Class Projectile.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Projectile extends Sprite implements Collidable{
	
	private String myName;
	private String myImageString;
	private Integer mySpeed; 
	private ProjectileEffect myEffect;
	private int myRadius;
	private Shape myCollisionBounds;
	private Path myPath;
	
	public Projectile(){
		
	}
	
	public Projectile(Projectile projectile) {
		this.myName = projectile.myName;
		this.myImageString = projectile.myImageString;
		this.mySpeed = projectile.mySpeed;
		this.myEffect = projectile.myEffect;
		this.myRadius = projectile.myRadius;
		this.myCollisionBounds = projectile.myCollisionBounds;
		this.myAccessNames = projectile.myAccessNames;
		this.myName = projectile.myName;
		this.myAccessNames = projectile.myAccessNames;
	}
	
	public void setPath(Path p){
		myPath = p;
	}

	public void setRadius(int x){
		myRadius = x;
	}

	@Override
	public Placement move() {
		return myPath.getNextPlacement();
	}

	/**
	 * no method body because projectile's effect evaluated by enemy.
	 *
	 * @param collider the collider
	 * @return true, if successful
	 */
	@Override
	public boolean evaluateCollision(Collidable collider) {
		return isCollision(collider);
	}

	/**
	 * Maybe find a way to make it so projectiles are marked as dead upon collision?
	 * Instead of manually removing them like we do currently.
	 *
	 * @return true, if is dead
	 */
	@Override
	public boolean isDead(){
		return false;
	}
	
	public void setCollisionBounds() {
		// myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRadius*2, myRadius*2);		
	}
	
	public int getRadius(){
		return myRadius;
	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
	
	public ProjectileEffect getEffect(){
		return myEffect;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
		mySpriteInfo.put("Speed", mySpeed.toString());
	}
}