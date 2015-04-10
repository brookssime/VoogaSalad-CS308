package engine;

import interfaces.Authorable;

import java.util.List;
import java.util.Map;

public class Store implements Authorable {

	private String myName;
	private Map<Tower, Integer> myTowersOnSale;
	private Integer myMoney;
	private String myBackgroundImagePath;
	
	public Store(){
		
	}
	
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

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}