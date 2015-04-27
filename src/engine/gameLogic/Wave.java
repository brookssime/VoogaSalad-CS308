
package engine.gameLogic;

import java.util.ArrayList;
import java.util.List;

import engine.sprites.Enemy;

public class Wave extends GameObject{
	
	private List<Enemy> myEnemies;
	private String myPortName;
	private List<Long> myDelays;
	private int myCurrentEnemy;

	public Wave(){
		myEnemies = new ArrayList<Enemy>();
		myDelays = new ArrayList<Long>();
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
	
	public void addEnemy(Enemy enemy){
		myEnemies.add(enemy);
	}
	public void addDelay(Long delay){
		myDelays.add(delay);
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