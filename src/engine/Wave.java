package engine;

import interfaces.Authorable;

import java.util.List;

public class Wave extends GameObject{
	private String myPortName;
	private List<Enemy> myEnemies;
	private List<Long> myDelays;
	private int myCurrentEnemy;
	
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

	public boolean isComplete() {
		if (myCurrentEnemy >= myEnemies.size()) {
			return true;
		}
		return false;
	}



}
