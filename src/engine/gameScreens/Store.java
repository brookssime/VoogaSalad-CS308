package engine.gameScreens;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import engine.gameLogic.GameObject;
import engine.sprites.Tower;

public class Store extends GameObject {
	
	private Map<Tower, Integer> myTowersOnSale;
	private String myBackgroundImagePath;
	private Map<String, Tower> myTowerNames;
	private Integer mySellPercentage;
	
	public Store(){
		
	}
	
	public Store(Map<Tower, Integer> towersOnSale, String backgroundImagePath){
		myTowersOnSale = towersOnSale;
		myBackgroundImagePath = backgroundImagePath;
	}

	public void setTowersOnSale(HashMap<Tower, Integer> towerOnSaleMap){
		myTowersOnSale = towerOnSaleMap;
	}
	
	public Set<Tower> getTowersOnSale(){
		return myTowersOnSale.keySet();
	}
	
	public Tower getTowerFromName(String ID){
		return myTowerNames.get(ID);
		// TODO make this CLONE the object instead of returning the same instance
	}
	
	public void setBackgroundImagePath(String imagePath){
		myBackgroundImagePath = imagePath;
	}
	
	public void setSellPercentage(Integer sellPercentage){
		mySellPercentage = sellPercentage;
	}
	
	public Integer getTowerCost(Tower tower){
		return myTowersOnSale.get(tower);
	}

	public String getImagePath(){
		return myBackgroundImagePath;
	}
	
	public Integer getSellPercentage(){
		return mySellPercentage;
	}
	
	public Tower getFromID(String TowerID){
		for (String myTower: myTowerNames.keySet()){
			if (myTower == TowerID){
				return myTowerNames.get(myTower);
			}
		}
		return null;
	}
}