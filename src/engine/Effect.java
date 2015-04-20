
package engine;

import interfaces.Authorable;

import java.util.List;
import java.util.TimerTask;


// TODO: Auto-generated Javadoc
/**
 * The Class Effect.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 * 
 */
public class Effect extends GameObject{
	
	/** The my name. */
	private String myName;
	
	/** The my speed damage. */
	private Integer mySpeedDamage;
	private Double mySpeedFrequency;
	private Integer mySpeedReps;
	private Double mySpeedDuration;
	
	/** The my health damage. */
	private Integer myHealthDamage;
	private Double myHealthFrequency;
	private Integer myHealthReps;
	
	/** The is final. */
	private boolean isFinal;
	
	/** The my duration. */
	private long myDuration;



	
	/**
	 * Instantiates a new effect.
	 */
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