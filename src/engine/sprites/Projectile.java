package engine.sprites;

import interfaces.Collidable;
import interfaces.MethodAnnotation;
import interfaces.TypeAnnotation;

import java.awt.Shape;

import com.sun.javafx.geom.Ellipse2D;

import engine.Path;
import engine.gameLogic.Placement;
import engine.gameLogic.ProjectileEffect;

/**
 * The Class Projectile.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Projectile extends Sprite implements Collidable{
	
	private String myImageString; //Necessary?
	private Integer mySpeed; 
	private ProjectileEffect myEffect;
	private int myRadius; //RADIUS AND COLLISION HEIGHT/WIDTH?
	private Shape myCollisionBounds;
	private Path myPath;
	private Integer myCollisionHeight;
	private Integer myCollisionWidth;
	protected Placement myPlacement;
	
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

	@MethodAnnotation(editor=true, name = "Set Radius", type = "textfield", fieldName = "myRadius")
	public void setRadius(Integer x){
		myRadius = x;
	}

	@Override
	public Placement move() {
		return myPath.getNextPlacement();
	}

	/**
	 * no method body because projectile's effect evaluated by enemy.
	 */
	@Override
	public void evaluateCollision(Collidable collider) {
		
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
	
	public int getRadius(){
		return myRadius;
	}

	@MethodAnnotation(editor=true, name = "Set Effect", type = "singleselect", fieldName = "myEffect")
	@TypeAnnotation(type="ProjectileEffect")
	public void setEffect(ProjectileEffect pe) {
		myEffect = pe;
	}
	
	public ProjectileEffect getEffect(){
		return myEffect;
	}
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
		mySpriteInfo.put("Speed", mySpeed.toString());
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
	
	public void setImageString(String image){
		myImageString = image;
	}
	
	public void setSpeed(int speed){
		mySpeed = speed;
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