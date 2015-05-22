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
	void placeSprite(String spriteID, Placement place);
	void purchaseObject(String spriteID);
	void sellObject(String spriteID, Placement place);
	void examinSprite(String SpriteID, Placement place);
	void increaseGameSpeed();
	void decreaseGameSpeed();
	
	
}
