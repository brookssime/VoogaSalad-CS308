package engine.gameLogic;

import interfaces.Collidable;

import java.util.Timer;
import java.util.TimerTask;

import engine.sprites.Enemy;


public class ProjectileEffect extends GameObject{

	private Integer mySpeedDamage;
	private Double mySpeedFrequency;
	private Integer mySpeedReps;
	private Double mySpeedDuration;

	private Integer myHealthDamage;
	private Double myHealthFrequency;
	private Integer myHealthReps;

	private Timer effectTimer;

	private boolean myIsFinal;

	public ProjectileEffect(){

	}

	public void setSpeedDamage(int x){
		mySpeedDamage = x;
	}

	public void setSpeedFrequency(Double x){
		mySpeedFrequency = x;
	}

	public void setSpeedReps(int x){
		mySpeedReps = x;
	}

	public void setSpeedDamageDuration(Double x){
		mySpeedDuration = x;
	}


	public void setHealthDamage(int x){
		myHealthDamage = x;
	}

	public void setHealthFrequency(Double x){
		myHealthFrequency = x;
	}

	public void setHealthReps(int x){
		myHealthReps = x;
	}

	public Integer getSpeedDamage(){
		return mySpeedDamage;	
	}

	public Integer getHealthDamage(){
		return myHealthDamage;	
	}

	public Double getSpeedFrequency(){
		return mySpeedFrequency;
	}

	public Double getSpeedDuration(){
		return mySpeedDuration;
	}

	public Double getHealthFrequency(){
		return myHealthFrequency;
	}

	public int getHealthReps(){
		return myHealthReps;
	}

	public int getSpeedReps(){
		return mySpeedReps;
	}

	public boolean isFinal() {
		return myIsFinal;
	}

	public void reverseSpeedDamage(Enemy enemy){
		int originalSpeed = enemy.getSpeed();
		originalSpeed += mySpeedDamage;
		enemy.setSpeed(originalSpeed);
	}
	
	class SpeedTask extends TimerTask {
		
		private Enemy enemy;
		
		SpeedTask (Enemy enemy){
			this.enemy = enemy;
		}
		public void run() {
			reverseSpeedDamage(enemy);
			
		}
	}

	public void reverseSpeedEffect(Enemy enemy){
		effectTimer.schedule(new SpeedTask(enemy), mySpeedDuration.longValue()*1000);
		
	}
	
	public void causeHealthDamage(Enemy enemy){
		int newHealth = enemy.getHealth();
		newHealth -= myHealthDamage;
		enemy.setHealth(newHealth);
	}
	
	class HealthTask extends TimerTask {
		
		private Enemy enemy;
		
		HealthTask (Enemy enemy){
			this.enemy = enemy;
		}
		public void run() {
			causeHealthDamage(enemy);
		}
	}

	public void reverseHealthEffect(Enemy enemy){
		for (int i = 1; i <= myHealthReps; i++){
			effectTimer.schedule(new HealthTask(enemy), myHealthFrequency.longValue()*1000);
		}
		
		
	}


}