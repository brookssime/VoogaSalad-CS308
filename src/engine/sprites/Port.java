package engine.sprites;

/**
 * The Class Port.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Port extends GridObject{

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
}