// This entire file is part of my masterpiece.
// Brooks Sime

package engine.sprites;

import interfaces.Collidable;
import interfaces.MethodAnnotation;
import interfaces.MovementStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import engine.Path;
import engine.gameLogic.LevelStats;
import engine.gameLogic.Placement;
import engine.gameLogic.ProjectileEffect;

public class Enemy extends Sprite implements Collidable {

	private Integer mySpeed;
	private MovementStrategy myMovement;
	private Integer myDamage;
	private Integer myHealth;
	//private List<Tile> myTilePath;
	private Timer myTimer;
	private Path myPath;
	private Integer myCollisionHeight;
	private Integer myCollisionWidth;
	private Integer myScore;
	private LevelStats myGameStats;
	
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
	
	@MethodAnnotation(editor=true, name = "Set Score", type = "textfield", fieldName = "myScore")
	public void setScore (Integer x){
		myScore = x;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	public int getSpeed(){
		return mySpeed;
	}
	
	public int getScore(){
		
		return myScore;
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



	//public void setTilePath(LinkedList<Tile> tilePath) {
		//myTilePath = tilePath;
	//}

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
		mySpriteInfo.put("Score", myScore.toString());
		
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
	
	public void setMovement(MovementStrategy movement){
		myMovement = movement;
	}

	@Override
	public void addToMoney() {
		if (isDead()){
			myGameStats.updateScore(getScore());
		}
		
	}
}