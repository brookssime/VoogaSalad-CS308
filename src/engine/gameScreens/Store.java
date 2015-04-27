package engine.gameScreens;

import interfaces.MethodAnnotation;
import interfaces.TypeAnnotation;

import java.util.List;
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

	public Set<Tower> getTowersOnSale(){
		return myTowersOnSale.keySet();
	}
	
	@MethodAnnotation(editor=true, name="Set Towers and Prices", type="multiselect", fieldName="myTowersOnSale")
	@TypeAnnotation(type="Tower")
	public void setTowersOnSale(List<Tower> towers) {
		for (Tower tower : towers) {
			myTowersOnSale.put(tower, tower.getMyPrice());
		}
	}
	
	@MethodAnnotation(editor=true, name="Set Background Image", type="image", fieldName="myBackgroundImagePath")
	public void setBackgroundImage(String image) {
		myBackgroundImagePath = image;
	}
	
	@MethodAnnotation(editor=true, name="Set Sell Percentage", type="textfield", fieldName="mySellPercentage")
	public void setSellPercentage(int sellpercent) {
		mySellPercentage = sellpercent;
	}
	
	public Tower getTowerFromName(String ID){
		return myTowerNames.get(ID);
		// TODO make this CLONE the object instead of returning the same instance
	}
	
	/**
	 * Gets the tower cost.
	 *
	 * @param tower the tower
	 * @return the tower cost
	 */
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