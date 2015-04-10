package engine;

import java.util.TimerTask;

public class Effect {
	private Integer mySpeedDamage;
	private Integer myHealthDamage;
	private boolean isFinal;
	private long myDuration;
	
	public Integer getSpeedDamage(){
		return mySpeedDamage;
		
	}
	public Integer getHealthDamage(){
		return myHealthDamage;
		
	}
	
	public long getDuration(){
		return myDuration;
	}
	public boolean isFinal() {
		return isFinal;
	}
	
	
}