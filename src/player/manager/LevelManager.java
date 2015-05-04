// This entire file is part of my masterpiece.
// Fangyi Chen
package player.manager;

import engine.gameLogic.Placement;
import engine.sprites.Tower;

/**
 * 
 * Interface for levelscene class to call the controller methods
 * 
 * @author Fangyi Chen
 *
 */

public interface LevelManager extends NodeManager{
	/**
	 * @param spriteID
	 * @param place
	 * place a sprite to the grid
	 */
	public void placeSprite(String spriteID, Placement place);
	/**
	 * @param spriteID
	 * @param place
	 * sell a sprite
	 */
	public void sellObject(String spriteID, Placement place);
	/**
	 * @param SpriteID
	 * @param place
	 * check the information of the sprite
	 */
	public void examinSprite(String SpriteID, Placement place);
	/**
	 * increase game speed
	 */
	public void increaseGameSpeed();
	/**
	 * decrease game speed
	 */
	public void decreaseGameSpeed();
	
	/**
	 * @param spriteID
	 * @param p
	 * purchase a sprite
	 */
	public void purchaseObject(String spriteID, Placement p);
	
	
}
