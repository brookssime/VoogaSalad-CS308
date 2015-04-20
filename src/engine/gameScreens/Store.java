package engine.gameScreens;

import java.util.Map;

import engine.gameLogic.GameObject;
import engine.sprites.Tower;

/**
 * The Class Store.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Store extends GameObject {

	/** The my towers on sale. */
	private Map<Tower, Integer> myTowersOnSale;
	
	/** The my money. */
	private Integer myMoney;
	
	/** The my background image path. */
	private String myBackgroundImagePath;
	
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
	 * Adds the money.
	 *
	 * @param moneyToBeAdded the money to be added
	 */
	public void addMoney(Integer moneyToBeAdded){
		myMoney += moneyToBeAdded;
	}
	
	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public Integer getMoney(){
		return myMoney;
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
}