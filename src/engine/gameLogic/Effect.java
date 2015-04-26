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
	
	@MethodAnnotation(editor = true, name = "Name", type = "textfield", fieldName = "setter") 
	public void setName(@ParameterAnnotation(name="Name") String name) {
		myName = name;
	}
	
	@MethodAnnotation(editor = true, name = "Name", type = "textfield", fieldName = "getter") 
	public String getName() {
		return myName;
	}
	
	@MethodAnnotation(editor = true, name = "SpeedDamage", type = "textfield", fieldName = "setter") 
	public void setSpeedDamage(@ParameterAnnotation(name="Speed Damage") Integer x){
		mySpeedDamage = x;
	}
	
	@MethodAnnotation(editor = true, name = "SppedFrequency", type = "textfield", fieldName = "setter") 
	public void setSpeedFrequency(@ParameterAnnotation(name="Speed Frequency") Double x){
		mySpeedFrequency = x;
	}

	@MethodAnnotation(editor = true, name = "SpeedReps", type = "textfield", fieldName = "setter") 
	public void setSpeedReps(@ParameterAnnotation(name="Speed Reps") Integer x){
		mySpeedReps = x;
	}
	
	@MethodAnnotation(editor = true, name = "SpeedDuration", type = "textfield", fieldName = "setter") 
	public void setSpeedDuration(@ParameterAnnotation(name="Speed Duration") Double x){
		mySpeedDuration = x;
	}
	
	@MethodAnnotation(editor = true, name = "HealtDamage", type = "textfield", fieldName = "setter") 
	public void setHealthDamage(@ParameterAnnotation(name="Health Damage") Integer x){
		myHealthDamage = x;
	}
	
	@MethodAnnotation(editor = true, name = "HealtFrequency", type = "textfield", fieldName = "setter") 
	public void setHealthFrequency(@ParameterAnnotation(name="Health Frequency") Double x){
		myHealthFrequency = x;
	}
	
	@MethodAnnotation(editor = true, name = "HealtReps", type = "textfield", fieldName = "setter") 
	public void setHealthReps(@ParameterAnnotation(name="Health Reps") Integer x){
		myHealthReps = x;
	}
	
	@MethodAnnotation(editor = true, name = "SpeedDamage", type = "textfield", fieldName = "getter") 
	public Integer getSpeedDamage(){
		return mySpeedDamage;	
	}
	
	@MethodAnnotation(editor = true, name = "HealtDamage", type = "textfield", fieldName = "getter") 
	public Integer getHealthDamage(){
		return myHealthDamage;	
	}
	
	@MethodAnnotation(editor = true, name = "SpeedFrequency", type = "textfield", fieldName = "getter") 
	public Double getSpeedFrequency(){
		return mySpeedFrequency;
	}

	@MethodAnnotation(editor = true, name = "SpeedDuration", type = "textfield", fieldName = "getter") 
	public Double getSpeedDuration(){
		return mySpeedDuration;
	}
	
	@MethodAnnotation(editor = true, name = "HealtFrequency", type = "textfield", fieldName = "getter") 
	public Double getHealthFrequency(){
		return myHealthFrequency;
	}
	
	@MethodAnnotation(editor = true, name = "HealtReps", type = "textfield", fieldName = "getter") 
	public Integer getHealthReps(){
		return myHealthReps;
	}
	
	public int getSpeedReps(){
		return mySpeedReps;
	}
}