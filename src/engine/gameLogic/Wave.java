
package engine.gameLogic;

import java.util.List;

import engine.sprites.Enemy;

public class Wave extends GameObject{
	
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
	
	public String getPortName(){
		return myPortName;
	}
	
	public List<Enemy> getEnemies(){
		return myEnemies;
	}
	
	public List<Long> myDelays(){
		return myDelays;
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