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
	public void placeSprite(String spriteID, Placement place);
	public void purchaseObject(String spriteID);
	public void sellObject(String spriteID, Placement place);
	public void examinSprite(String SpriteID, Placement place);
	public void increaseGameSpeed();
	public void decreaseGameSpeed();
	
	
}
