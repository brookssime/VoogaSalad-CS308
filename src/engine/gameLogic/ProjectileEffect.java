package engine.gameLogic;

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

	public void setSpeedDamage(int x){
		mySpeedDamage = x;
	}

	public void setSpeedFrequency(Long x){
		mySpeedFrequency = x;
	}

	public void setSpeedReps(int x){
		mySpeedReps = x;
	}

//	public void setSpeedDamageDuration(Double x){
//		mySpeedDuration = x;
//	}

	
	public void setHealthDamage(int x){
		myHealthDamage = x;
	}

	public void setHealthFrequency(Long x){
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

	public Long getSpeedFrequency(){
		return mySpeedFrequency;
	}

	public Double getSpeedDuration(){
		return mySpeedDuration;
	}

	public Long getHealthFrequency(){
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