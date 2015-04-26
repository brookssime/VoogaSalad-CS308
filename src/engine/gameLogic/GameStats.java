package engine.gameLogic;

/**
 * TODO: Is it okay that this is basically just geters and setters?
 * @author Brooks and Sid
 */
public class GameStats {
	
	private int myMoney;
	private int myBaseHealth;
	private int myScore;
	
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
}