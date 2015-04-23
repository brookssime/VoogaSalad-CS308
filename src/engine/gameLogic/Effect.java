package engine.gameLogic;

import interfaces.MethodAnnotation;
import interfaces.ParameterAnnotation;


/**
 * The Class Effect.
 * 
 * @author Brooks, Patrick, Robert, and Sid. 
 */
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
	
	@MethodAnnotation(editor = true, name = "Name", type = "textfield", gsType = "setter") 
	public void setName(String name) {
		myName = name;
	}
	
	@MethodAnnotation(editor = true, name = "Name", type = "textfield", gsType = "getter") 
	public String getName() {
		return myName;
	}
	
	@MethodAnnotation(editor = true, name = "SpeedDamage", type = "textfield", gsType = "setter") 
	public void setSpeedDamage(Integer x){
		mySpeedDamage = x;
	}
	
	@MethodAnnotation(editor = true, name = "SppedFrequency", type = "textfield", gsType = "setter") 
	public void setSpeedFrequency(Double x){
		mySpeedFrequency = x;
	}

	@MethodAnnotation(editor = true, name = "SpeedReps", type = "textfield", gsType = "setter") 
	public void setSpeedReps(Integer x){
		mySpeedReps = x;
	}
	
	@MethodAnnotation(editor = true, name = "SpeedDuration", type = "textfield", gsType = "setter") 
	public void setSpeedDuration(Double x){
		mySpeedDuration = x;
	}
	
	@MethodAnnotation(editor = true, name = "HealtDamage", type = "textfield", gsType = "setter") 
	public void setHealthDamage(Integer x){
		myHealthDamage = x;
	}
	
	@MethodAnnotation(editor = true, name = "HealtFrequency", type = "textfield", gsType = "setter") 
	public void setHealthFrequency(Double x){
		myHealthFrequency = x;
	}
	
	@MethodAnnotation(editor = true, name = "HealtReps", type = "textfield", gsType = "setter") 
	public void setHealthReps(Integer x){
		myHealthReps = x;
	}
	
	@MethodAnnotation(editor = true, name = "SpeedDamage", type = "textfield", gsType = "getter") 
	public Integer getSpeedDamage(){
		return mySpeedDamage;	
	}
	
	@MethodAnnotation(editor = true, name = "HealtDamage", type = "textfield", gsType = "getter") 
	public Integer getHealthDamage(){
		return myHealthDamage;	
	}
	
	@MethodAnnotation(editor = true, name = "SpeedFrequency", type = "textfield", gsType = "getter") 
	public Double getSpeedFrequency(){
		return mySpeedFrequency;
	}

	@MethodAnnotation(editor = true, name = "SpeedDuration", type = "textfield", gsType = "getter") 
	public Double getSpeedDuration(){
		return mySpeedDuration;
	}
	
	@MethodAnnotation(editor = true, name = "HealtFrequency", type = "textfield", gsType = "getter") 
	public Double getHealthFrequency(){
		return myHealthFrequency;
	}
	
	@MethodAnnotation(editor = true, name = "HealtReps", type = "textfield", gsType = "getter") 
	public Integer getHealthReps(){
		return myHealthReps;
	}
	
	public int getSpeedReps(){
		return mySpeedReps;
	}
}