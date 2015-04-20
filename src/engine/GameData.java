package engine;

public class GameData {
	
	private int myMoney;
	private int myBaseHealth;
	private int myScore;
	
	protected void updateMoney(int money){
		myMoney += money;
	}
	
	protected Integer getMoney(){
		return myMoney;
	}
	
	protected void updateBaseHealth(int healthChange){
		myBaseHealth += healthChange;
	}
	
	protected Integer getBaseHealth(){
		return myBaseHealth;
	}
	
	protected void updateScore(int score){
		myScore += score;
	}
	
	protected Integer getScore(){
		return myScore;
	}
}