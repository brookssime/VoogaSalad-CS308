package engine;

import engine.gameLogic.LevelStats;

/**
 * TODO: Does this class work? The methods don't seem to make full sense yet.
 * The display that holds mutable game info such as health of the base, score,
 * money gained through killing enemies, beating levels, etc.
 * Will be displayed on every level.
 * @author brookssime
 * 
 */
public class HeadsUpDisplay {
	
	/**
	 * GameData object
	 */
	
	private LevelStats data;
	
	public int displayMoney(){
		int money = data.getMoney();
		return money;
	}
	
	public int displayHealth(){
		int health = data.getBaseHealth();
		return health;
		
	}
	
	public void displayTime(){
		//TODO: Where is the timer?
	}
	
	public int displayScore(){
		int score = data.getScore();
		return score;
	}
	
	
}