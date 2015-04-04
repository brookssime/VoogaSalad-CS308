package engine;

import java.util.ArrayList;
import java.util.List;

/**
 * List of names of all instantiable classes. 
 * @author Negatu
 *
 */
public class GameEngineInventory {
	private static List<String> myInventory = new ArrayList<String>();
	
	public static List<String> getInventory(){
		populateInventory();
		return myInventory;
	}
	
	private static void populateInventory(){
		myInventory.add("GameEngine.ExampleSprite");
		myInventory.add("GameEngine.ExampleEnemy");
	}
	
}
