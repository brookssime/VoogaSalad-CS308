package engine;

/**
 * The display that holds mutable game info such as health of the base, score,
 * money gained through killing enemies, beating levels, etc.
 * 
 * Will be displayed on every level.
 * 
 * @author brookssime
 * 
 */
public class HeadsUpDisplay {
	
	/**
	 * GameData object
	 */
	private GameData data;
	
	public void displayMoney(){
		int money = data.getMoney();
	}
	
	public void displayHealth(){
		int health = data.getBaseHealth();
		
	}
	
	public void displayTime(){
		//TODO: Where is the timer?
	}
	
	public void displayScore(){
		int score = data.getScore();
	}
}
