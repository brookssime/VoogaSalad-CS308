package engine;

import interfaces.Authorable;

import java.util.List;
import java.util.TimerTask;

public class Effect implements Authorable{
	private String myName;
	private Integer mySpeedDamage;
	private Integer myHealthDamage;
	private boolean isFinal;
	private long myDuration;
	
	public Effect(){
		
	}
	
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
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
	
	
}