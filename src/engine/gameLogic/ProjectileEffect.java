package engine.gameLogic;


import interfaces.Collidable;
import interfaces.MethodAnnotation;


import java.util.Timer;
import java.util.TimerTask;

import engine.sprites.Enemy;


public class ProjectileEffect extends GameObject{

	private Integer mySpeedDamage;
	private Double mySpeedFrequency;

//	private Integer mySpeedReps;
	private Double mySpeedDuration;

	private Integer myHealthDamage;
	private Double myHealthFrequency;
	private Integer myHealthReps;

	private Timer effectTimer;

	private boolean myIsFinal;

	public ProjectileEffect(){

	}

	@MethodAnnotation(editor = true, name = "Set Speed Damage", type = "textfield", fieldName = "mySpeedDamage") 
	public void setSpeedDamage(Integer x){
		mySpeedDamage = x;
	}

	@MethodAnnotation(editor = true, name = "Set Speed Frequency", type = "slider", fieldName = "mySpeedFrequency") 
	public void setSpeedFrequency(Double x){
		mySpeedFrequency = x;
	}

//	@MethodAnnotation(editor = true, name = "Set Speed Repetitions", type = "textfield", fieldName = "mySpeedReps") 
//	public void setSpeedReps(int x){
//		mySpeedReps = x;
//	}

	@MethodAnnotation(editor = true, name = "Set Speed Damage Duration", type = "slider", fieldName = "mySpeedDuration") 
	public void setSpeedDamageDuration(Double x){
		mySpeedDuration = x;
	}

	@MethodAnnotation(editor = true, name = "Set Health Damage", type = "textfield", fieldName = "myHealthDamage") 
	public void setHealthDamage(Integer x){
		myHealthDamage = x;
	}

	@MethodAnnotation(editor = true, name = "Set Health Frequency", type = "slider", fieldName = "myHealthFrequency") 
	public void setHealthFrequency(Double x){
		myHealthFrequency = x;
	}

	@MethodAnnotation(editor = true, name = "Set Health Repetitions", type = "textfield", fieldName = "myHealthReps") 
	public void setHealthReps(Integer x){
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
	
//	private void speedEffect(){
//		for (int i = 0; i < mySpeedReps; i++){
//			effectTimer.schedule(new SpeedTask(), (long) (mySpeedFrequency*1000));
//		}

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
	
//	private void healthEffect(){
//		for (int i = 0; i < myHealthReps; i++){
//			effectTimer.schedule(new HealthTask(), (long) (myHealthFrequency*1000));
//		}

	public void reverseHealthEffect(Enemy enemy){
		for (int i = 1; i <= myHealthReps; i++){
			effectTimer.schedule(new HealthTask(enemy), myHealthFrequency.longValue()*1000);
		}
	}

}