
package engine.gameLogic;

import interfaces.MethodAnnotation;

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
	
	@MethodAnnotation(editor=true, name = "Set Port", type = "textfield", fieldName = "myPortName")
	public void setPortName(String portName){
		myPortName = portName;
	}
	
	@MethodAnnotation(editor=true, name = "Add Enemies", type = "queueeditor", fieldName = "myEnemies")
	public void addEnemy(Enemy enemy){
		myEnemies.add(enemy);
	}
	
	@MethodAnnotation(editor=true, name = "Add Delays", type = "queueeditor", fieldName = "myDelays")
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
		return myCurrentEnemy >= myEnemies.size();
	}
}