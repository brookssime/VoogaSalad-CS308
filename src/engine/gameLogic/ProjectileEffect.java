package engine.gameLogic;

import interfaces.MethodAnnotation;

import java.util.Timer;
import java.util.TimerTask;

public class ProjectileEffect extends GameObject{

	private Integer mySpeedDamage;
	private Long mySpeedFrequency;
	private Integer mySpeedReps;
	private Double mySpeedDuration;

	private Integer myHealthDamage;
	private Long myHealthFrequency;
	private Integer myHealthReps;

	private Timer effectTimer;

	private boolean myIsFinal;

	public ProjectileEffect(){

	}

	@MethodAnnotation(editor = true, name = "Set Speed Damage", type = "textfield", fieldName = "mySpeedDamage") 
	public void setSpeedDamage(int x){
		mySpeedDamage = x;
	}

	@MethodAnnotation(editor = true, name = "Set Speed Frequency", type = "slider", fieldName = "mySpeedFrequency") 
	public void setSpeedFrequency(Long x){
		mySpeedFrequency = x;
	}

	@MethodAnnotation(editor = true, name = "Set Speed Repetitions", type = "textfield", fieldName = "mySpeedReps") 
	public void setSpeedReps(int x){
		mySpeedReps = x;
	}

//	@MethodAnnotation(editor = true, name = "Set Speed Damage Duration", type = "slider", fieldName = "mySpeedDuration") 
//	public void setSpeedDamageDuration(Double x){
//		mySpeedDuration = x;
//	}

	@MethodAnnotation(editor = true, name = "Set Health Damage", type = "textfield", fieldName = "myHealthDamage") 
	public void setHealthDamage(int x){
		myHealthDamage = x;
	}

	@MethodAnnotation(editor = true, name = "Set Health Frequency", type = "slider", fieldName = "myHealthFrequency") 
	public void setHealthFrequency(Long x){
		myHealthFrequency = x;
	}

	@MethodAnnotation(editor = true, name = "Set Health Repetitions", type = "textfield", fieldName = "myHealthReps") 
	public void setHealthReps(int x){
		myHealthReps = x;
	}
	
	public int getSpeedDamage() {
		return mySpeedDamage;
	}
	
	public int getHealthDamage() {
		return myHealthDamage;
	}

	public boolean isFinal() {
		return myIsFinal;
	}
	
	class SpeedTask extends TimerTask {
		public void run() {
			getSpeedDamage();
		}
	}
	private void speedEffect(){
		for (int i = 0; i < mySpeedReps; i++){
			effectTimer.schedule(new SpeedTask(), mySpeedFrequency*1000);
		}

	}
	
	class HealthTask extends TimerTask {
		public void run() {
			getHealthDamage();
		}
	}
	private void healthEffect(){
		for (int i = 0; i < myHealthReps; i++){
			effectTimer.schedule(new HealthTask(), myHealthFrequency*1000);
		}

	}
	
	
}