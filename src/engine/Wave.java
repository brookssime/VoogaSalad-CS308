/*
 * 
 */
package engine;

import interfaces.Authorable;

import java.util.List;

public class Wave extends GameObject{
	
	/** The my name. */
	private String myName;
	
	/** The my enemies. */
	private List<Enemy> myEnemies;


	private String myPortName; //myPortName NEEDS TO BE UNIQUE FOR EACH PORT

	
	/** The my delays. */
	private List<Long> myDelays;
	
	/** The my current enemy. */
	private int myCurrentEnemy;
	
	/**
	 * Instantiates a new wave.
	 */
	public Wave(){
		
	}
	

	public void setPortName(String portName){
		myPortName = portName;
	}
	
	public void setEnemies(List<Enemy> enemies){
		myEnemies = enemies;
	}
	
	public void setDelays(List<Long> delays){
		myDelays = delays;
	}
	

	public List<Enemy> update(long startTime) {
		List<Enemy> toSpawn = null;
		long elapsedTime = startTime - System.nanoTime();
		for (int i = 0; i < myDelays.size(); i++) {
			if (myDelays.get(i) <= elapsedTime) {
				toSpawn.add(myEnemies.get(i));
			} else {
				break;
			}
		}
		return toSpawn;
	}

	/**
	 * Checks if is complete.
	 *
	 * @return true, if is complete
	 */
	public boolean isComplete() {
		if (myCurrentEnemy >= myEnemies.size()) {
			return true;
		}
		return false;
	}




}
