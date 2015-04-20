package engine;

public class GameData {
	
	private int money;
	private int baseHealth;
	private int score;
	
	protected void updateMoney(int m){
		money += m;
		
	}
	
	protected Integer getMoney(){
		return money;
	};
	
	
	protected void updateBaseHealth(int b){
		baseHealth += b;
	}
	
	protected Integer getBaseHealth(){
		return baseHealth;
	}
	
	protected void updateScore(int s){
		score += s;
	}
	
	protected Integer getScore(){
		return score;
	}

}
