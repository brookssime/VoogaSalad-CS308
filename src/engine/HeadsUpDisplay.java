package engine;

import engine.gameLogic.LevelStats;

/**
 * TODO: Can we get rid of this? Just getters for GameData
 * @author brookssime
 * 
 */
public class HeadsUpDisplay {
	
	private LevelStats myData;
	
	public void setLevelStats(LevelStats data){
		myData = data;
	}
	
	public int displayMoney(){
		 return myData.getMoney();
	}
	
	public int displayHealth(){
		return myData.getBaseHealth();
	}
	
	public void displayTime(){
		//TODO: fix this somehow
	}
	
	public int displayScore(){
		return myData.getScore();
	}
	
	
}