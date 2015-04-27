package engine.gameLogic;

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

	public void setSpeedDamage(int x){
		mySpeedDamage = x;
	}

	public void setSpeedFrequency(Long x){
		mySpeedFrequency = x;
	}

	public void setSpeedReps(int x){
		mySpeedReps = x;
	}

	public void setSpeedDamageDuration(Long x){
		mySpeedDuration = x;
	}


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

	public Integer reverseSpeedDamage(){
		return mySpeedDamage*-1;
	}

	public Integer getHealthDamage(){
		return myHealthDamage;	
	}

	public Long getSpeedFrequency(){
		return mySpeedFrequency;
	}

	public Long getSpeedDuration(){
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

	class ReturnOriginalSpeedTask extends TimerTask {
		public void run() {
			reverseSpeedDamage();
		}
	}
	
	//TODO: SPEED POISON?
	private void speedEffect(){
		getSpeedDamage();
		if (!myIsFinal){
			effectTimer.schedule(new ReturnOriginalSpeedTask(), mySpeedDuration*1000);
		}

	}
	class HealthTask extends TimerTask {
		public void run() {
			getHealthDamage();
		}
	}

	private void healthEffect(){
		getHealthDamage();
		for (int i = 1; i <= myHealthReps-1; i++){
			effectTimer.schedule(new HealthTask(), myHealthFrequency*1000);
		}
	}

}