/*
 * 
 */
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
public class Effect implements Authorable{
	
	/** The my name. */
	private String myName;
	
	/** The my speed damage. */
	private Integer mySpeedDamage;
	
	/** The my health damage. */
	private Integer myHealthDamage;
	
	/** The is final. */
	private boolean isFinal;
	
	/** The my duration. */
	private long myDuration;
	
	/**
	 * Instantiates a new effect.
	 */
	public Effect(){
		
	}
	
	/**
	 * Gets the speed damage.
	 *
	 * @return the speed damage
	 */
	public Integer getSpeedDamage(){
		return mySpeedDamage;
		
	}
	
	/**
	 * Gets the health damage.
	 *
	 * @return the health damage
	 */
	public Integer getHealthDamage(){
		return myHealthDamage;
		
	}
	
	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public long getDuration(){
		return myDuration;
	}
	
	/**
	 * Checks if is final.
	 *
	 * @return true, if is final
	 */
	public boolean isFinal() {
		return isFinal;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
	
	
}