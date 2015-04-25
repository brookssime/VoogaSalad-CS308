package engine.sprites;

import engine.gameLogic.Placement;

/**
 * The Class Port.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Port extends Sprite{

	public Port(){
		
	}

	/**
	 * Could be a later feature to have ports die
	 * Towers could kill enemy ports to win a level, for example
	 */
	@Override
	public boolean isDead() {
		return false;
	}

	@Override
	public Placement move() {
		// TODO Auto-generated method stub
		return null;
	}
}