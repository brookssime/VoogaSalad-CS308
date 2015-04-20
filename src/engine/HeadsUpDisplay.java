package engine;

public class HeadsUpDisplay {
	
	private GameData data;
	
	public void displayMoney(){
		int money = data.getMoney();
	}
	
	public void displayHealth(){
		
		int health = data.getBaseHealth();
		
	}
	
	public void displayTime(){
	
	}
	
	public void displayScore(){
		int score = data.getScore();
	}
}
