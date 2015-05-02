package engine.sprites;

import interfaces.Collidable;
import interfaces.MethodAnnotation;
import interfaces.MovementStrategy;

import java.awt.Shape;
import java.util.List;

import com.sun.javafx.geom.Ellipse2D;

import engine.Path;
import engine.gameLogic.Placement;
import engine.gameLogic.ProjectileEffect;

public class Enemy extends Sprite implements Collidable {

	private Integer mySpeed;
	private MovementStrategy myMovement;
	private Integer myDamage;
	private Integer myHealth;
	private Path myPath;
	private Integer myCollisionHeight;
	private Integer myCollisionWidth;
	protected Placement myPlacement;
	private Shape myCollisionBounds;
	
	
	public Enemy(){
		
	}

	@MethodAnnotation(editor=true, name = "Set Health", type = "textfield", fieldName = "myHealth")
	public void setHealth(Integer x){
		myHealth = x;
	}
	
	@MethodAnnotation(editor=true, name = "Set Speed", type = "textfield", fieldName = "mySpeed")
	public void setSpeed(Integer x){
		mySpeed = x;
	}
	
	@MethodAnnotation(editor=true, name = "Set Damage", type = "textfield", fieldName = "myDamage")
	public void setDamage(Integer x){
		myDamage = x;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	public int getSpeed(){
		return mySpeed;
	}
	
	
	public void executeEffect(Projectile projectile) {
		ProjectileEffect currentEffect = projectile.getEffect();
		mySpeed -= currentEffect.getSpeedDamage();
			if (!currentEffect.isFinal()){
				currentEffect.reverseSpeedEffect(this);
			}
		currentEffect.causeHealthDamage(this);
		}
		
	

	public List<String> getWalkables() {
		return myAccessNames;
	}

	public void setPath(Path p) {
		myPath = p;
	}
	public Integer getEnemyDamage() {
		return myDamage;
	}


	@Override
	public boolean isDead() {
		return myHealth <= 0;
	}

	@Override
	public int compareTo(Object o) {
		return (this.myPath.size().compareTo(((Enemy) o).myPath.size()));
	}

	@Override
	public Placement move() {
		return myPath.getNextPlacement();
	}

	@Override
	public void evaluateCollision(Collidable collider) {
		if (isCollision(collider) && collider.getClass().isAssignableFrom(Projectile.class)) {
			executeEffect((Projectile) collider);
		}
	}

	public MovementStrategy getMovement() {
		return myMovement;
	}

	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
		mySpriteInfo.put("Health", myHealth.toString());
		mySpriteInfo.put("Speed", mySpeed.toString());
		mySpriteInfo.put("Damage", myDamage.toString());
	}

	@Override
	public Integer getCollisionHeight() {
		return myCollisionHeight;
	}

	@Override
	public Integer getCollisionWidth() {
		return myCollisionWidth;
	}
	
	public void setMovement(MovementStrategy movement){
		myMovement = movement;
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

	@Override
	public void setPlacement(Placement placement) {
		myPlacement = placement;
	}
}