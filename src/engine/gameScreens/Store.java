package engine.gameScreens;

import java.util.Map;
import java.util.Set;

import engine.gameLogic.GameObject;
import engine.sprites.Tower;

/**
 * The Class Store.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Store extends GameObject {

	
	private Map<Tower, Integer> myTowersOnSale;
	private Integer myMoney;
	private String myBackgroundImagePath;
	private Map<String, Tower> myTowerNames;
	
	/**
	 * Instantiates a new store.
	 */
	public Store(){
		
	}
	
	/**
	 * Instantiates a new store.
	 *
	 * @param towersOnSale the towers on sale
	 * @param backgroundImagePath the background image path
	 */
	public Store(Map<Tower, Integer> towersOnSale, String backgroundImagePath){
		myTowersOnSale = towersOnSale;
		myBackgroundImagePath = backgroundImagePath;
	}
	
	/**
	 * Is that OK to add method for get the whole list of towers on sale
	 * @return a set of towers
	 */
	public Set<Tower> getTowersOnSale(){
		return myTowersOnSale.keySet();
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
	
	/**
	 * Gets the image path.
	 *
	 * @return the image path
	 */
	public String getImagePath(){
		return myBackgroundImagePath;
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