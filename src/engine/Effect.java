package engine;

import interfaces.Authorable;

import java.util.List;
import java.util.TimerTask;

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


	
	
}