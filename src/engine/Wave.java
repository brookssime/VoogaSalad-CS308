/*
 * 
 */
package engine;

import interfaces.Authorable;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Wave.
 */
public class Wave implements Authorable{
	
	/** The my name. */
	private String myName;
	
	/** The my enemies. */
	private List<Enemy> myEnemies;
	
	/** The my delays. */
	private List<Long> myDelays;
	
	/** The my current enemy. */
	private int myCurrentEnemy;
	
	/**
	 * Instantiates a new wave.
	 */
	public Wave(){
		
	}
	
	/**
	 * Update.
	 *
	 * @param startTime the start time
	 * @return the list
	 */
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
