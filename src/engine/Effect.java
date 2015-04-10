package engine;

public class Effect {
	private Integer mySpeedDamage;
	private Integer myHealthDamage;
	private boolean isPermanent;
	private long myDuration;
	
	public Integer getSpeedDamage(){
		return mySpeedDamage;
		
	}
	public Integer getHealthDamage(){
		return myHealthDamage;
		
	}
	public Boolean isPermanent(){
		return isPermanent;
	}
	public long getDuration(){
		return myDuration;
	}
}
