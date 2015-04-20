package engine.testing;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * List of names of all instantiable classes. 
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 *
 */
public class GameEngineInventory {
	
	/** The my inventory. */
	private static List<String> myInventory = new ArrayList<String>();
	
	/**
	 * Gets the inventory.
	 *
	 * @return the inventory
	 */
	public static List<String> getInventory(){
		populateInventory();
		return myInventory;
	}
	
	/**
	 * Populate inventory.
	 */
	private static void populateInventory(){
		myInventory.add("engine.ExampleSprite");
		myInventory.add("engine.ExampleEnemy");
	}	
}