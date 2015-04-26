package engine.gameLogic;

import interfaces.MethodAnnotation;

import java.util.Timer;
import java.util.TimerTask;

public class ProjectileEffect extends GameObject{

	private Integer mySpeedDamage;
 	private Long mySpeedFrequency;
	private Integer mySpeedReps;
	private Long mySpeedDuration;

	private Integer myHealthDamage;
	private Long myHealthFrequency;
	private Integer myHealthReps;

	private Timer effectTimer;

	private boolean myIsFinal;

	public ProjectileEffect(){

	}

	@MethodAnnotation(editor = true, name = "Speed Damage", type = "slider", fieldName = "mySpeedDamage") 
	public void setSpeedDamage(int x){
		mySpeedDamage = x;
	}


	@MethodAnnotation(editor = true, name = "Speed Frequency", type = "slider", fieldName = "mySpeedFrequency") 
	public void setSpeedFrequency(Long x){
		mySpeedFrequency = x;
	}




	@MethodAnnotation(editor = true, name = "Speed Repetitions", type = "slider", fieldName = "mySpeedReps") 
	public void setSpeedReps(int x){
		mySpeedReps = x;
	}


	@MethodAnnotation(editor = true, name = "Health Damage", type = "slider", fieldName = "myHealthDamage") 
	public void setSpeedDamageDuration(Long x){
		mySpeedDuration = x;
	}


	public void setHealthDamage(int x){
		myHealthDamage = x;
	}

	@MethodAnnotation(editor = true, name = "Health Frequency", type = "textfield", fieldName = "myHealthFrequency") 
	public void setHealthFrequency(Long x){
		myHealthFrequency = x;
	}

	@MethodAnnotation(editor = true, name = "Health Repetitions", type = "textfield", fieldName = "myHealthReps") 
	public void setHealthReps(int x){
		myHealthReps = x;
	}


	public Integer getSpeedDamage(){
		return mySpeedDamage;	
	}

	public Integer reverseSpeedDamage(){
		return mySpeedDamage*-1;
	}


//	public Long getSpeedFrequency(){
//		return mySpeedFrequency;
//	}

	public Long getSpeedDuration(){
		return mySpeedDuration;
	}

	public Long getHealthFrequency(){
		return myHealthFrequency;
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

	class ReverseSpeedTask extends TimerTask {
		public void run() {
			reverseSpeedDamage();
		}
	}
	private void speedEffect(){
		effectTimer.schedule(new SpeedTask(), mySpeedDuration*1000);
		effectTimer.schedule(new ReverseSpeedTask(), 0);
	}



	class HealthTask extends TimerTask {
		public void run() {
			getHealthDamage();
		}
	}

	private void healthEffect(){
		for (int i = 1; i <= myHealthReps; i++){
			effectTimer.schedule(new HealthTask(), myHealthFrequency*1000);
		}

	}

}