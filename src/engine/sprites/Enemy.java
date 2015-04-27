package engine.sprites;

import interfaces.Collidable;
import interfaces.MethodAnnotation;
import interfaces.MovementStrategy;

import java.awt.Shape;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import engine.Path;
import engine.gameLogic.Placement;
import engine.gameLogic.ProjectileEffect;

public class Enemy extends Sprite implements Collidable {

	private Integer mySpeed;
	private MovementStrategy myMovement;
	private Integer myDamage;
	private Integer myHealth;
	private Shape myCollisionBounds;
	private List<Tile> myTilePath;
	private Timer myTimer; //TODO: Do we need this in the EnemyClass?
	private Path myPath;

	public Enemy(){
		
	}

	@MethodAnnotation(editor=true, name = "Set Health", type = "textfield", fieldName = "myHealth")
	public void setHealth(int x){
		myHealth = x;
	}
	
	@MethodAnnotation(editor=true, name = "Set Speed", type = "textfield", fieldName = "mySpeed")
	public void setSpeed(int x){
		mySpeed = x;
	}
	
	@MethodAnnotation(editor=true, name = "Set Damage", type = "textfield", fieldName = "myDamage")
	public void setDamage(int x){
		myDamage = x;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	public int getSpeed(){
		return mySpeed;
	}
	
	public int getDamage(){
		return myDamage;
	}
	
	//TODO: Fix this with new projectile info
	public void executeEffect(Projectile projectile) {
		ProjectileEffect currentEffect = projectile.getEffect();
		if(currentEffect.isFinal()){
			mySpeed -= currentEffect.getSpeedDamage();
			myHealth -= currentEffect.getHealthDamage();
		}
		
	/*	else{
			myTimer = new Timer();
			myTimer.schedule(
					new reverseEffect(currentEffect.getSpeedDamage()),
					currentEffect.getDuration());
		}*/	
	}

	public List<String> getWalkables() {
		return myAccessNames;
	}

	public void setPath(Path p) {
		myPath = p;
	}

	public List<Tile> getTilePath() {
	return myTilePath;

	}

	public void setTilePath(LinkedList<Tile> tilePath) {
		myTilePath = tilePath;
	}

	public Integer getEnemyDamage() {
		return myDamage;
	}

	//TODO: Is this class required?
	class reverseEffect extends TimerTask {

		private Integer speedChange;

		private reverseEffect(Integer speed) {
			speedChange = speed;
		}

		public void run() {
			mySpeed += speedChange;
			myTimer.cancel();
		}
	}

	@Override
	public boolean isDead() {
		return myHealth <= 0;
	}

	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}

	@Override
	public void setCollisionBounds() {
		// TODO FIX THIS bc enemies no longer know where they are

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
	public boolean evaluateCollision(Collidable collider) {
		// TODO Auto-generated method stub
		return false;
	}

	public MovementStrategy getMovement() {
		return myMovement;
	}

	//TODO: Find a better way to do this?
	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
		mySpriteInfo.put("Health", myHealth.toString());
		mySpriteInfo.put("Speed", mySpeed.toString());
		mySpriteInfo.put("Damage", myDamage.toString());
	}
}