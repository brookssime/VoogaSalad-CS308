package engine.sprites;

import interfaces.Collidable;
import interfaces.MovementStrategy;

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
	private List<Tile> myTilePath;
	private Timer myTimer;
	private Path myPath;
	private Integer myCollisionHeight;
	private Integer myCollisionWidth;

	public Enemy(){
		
	}

	public void setHealth(int x){
		myHealth = x;
	}
	
	public void setSpeed(int x){
		mySpeed = x;
	}
	
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
		if (collider.getClass().isAssignableFrom(Projectile.class)) {
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
}