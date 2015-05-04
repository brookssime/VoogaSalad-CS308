// This entire file is part of my masterpiece.
// Brooks Sime

package engine.gameLogic;

import interfaces.MethodAnnotation;

/**
 * @author Brooks and Sid
 */
public class LevelStats {
	
	private int myMoney;
	private int myBaseHealth;
	private int myScore;
	private long myTimeElapsed;
	private int myMaxScore;
	
	public LevelStats(){
		myMoney = 1000;
	}
	
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
	
	@MethodAnnotation(editor=true, name = "Set Maximum Score", type = "textfield", fieldName = "myScore")
	public void setMaxScore(Integer x){
		myMaxScore = x;
		
	}
	
	public boolean maxScoreReached(){
		return (myScore >= myMaxScore);
	}
	
	public long getTimeElapsed(long startTime){
		myTimeElapsed = System.nanoTime() - startTime;
		return myTimeElapsed;
	}
}