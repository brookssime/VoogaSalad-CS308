package engine.gameLogic;

public class Effect extends GameObject{

	private Integer mySpeedDamage;
	private Double mySpeedFrequency;
	private Integer mySpeedReps;
	private Double mySpeedDuration;

	private Integer myHealthDamage;
	private Double myHealthFrequency;
	private Integer myHealthReps;

	public Effect(){
		
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
}