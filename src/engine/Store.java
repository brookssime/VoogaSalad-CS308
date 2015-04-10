package engine;

import java.util.Map;

public class Store {

	private Map<Tower, Integer> myTowersOnSale;
	private Integer myMoney;
	private String myBackgroundImagePath;
	
	
	public Store(Map<Tower, Integer> towersOnSale, String backgroundImagePath){
		myTowersOnSale = towersOnSale;
		myBackgroundImagePath = backgroundImagePath;
	}
	
	public void addMoney(Integer moneyToBeAdded){
		myMoney += moneyToBeAdded;
	}
	
	public Integer getMoney(){
		return myMoney;
	}
	
	public Integer getTowerCost(Tower tower){
		return myTowersOnSale.get(tower);
	}
	
	public String getImagePath(){
		return myBackgroundImagePath;
	}
}