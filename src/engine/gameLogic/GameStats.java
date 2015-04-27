package engine.gameLogic;

/**
 * @author Brooks and Sid
 */
public class GameStats {
	
	private int myMoney;
	private int myBaseHealth;
	private int myScore;
	private long myTimeElapsed;
	
	public void updateMoney(int money){
		myMoney += money;
	}
	
	public Integer getMoney(){
		return myMoney;
	}
	
	public void updateBaseHealth(int healthChange){
		myBaseHealth += healthChange;
	}
	
	public Integer getBaseHealth(){
		return myBaseHealth;
	}
	
	public void updateScore(int score){
		myScore += score;
	}
	
	public Integer getScore(){
		return myScore;
	}
	
	public long getTimeElapsed(long startTime){
		myTimeElapsed = System.nanoTime() - startTime;
		return myTimeElapsed;
	}
}