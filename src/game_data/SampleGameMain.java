package game_data;

import java.io.IOException;

import engine.Game;
import engine.Grid;
import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;

public class SampleGameMain {

	public static void main(String[] args) {
		
		GameNode gn1 = new LevelNode();
		gn1.setName("GAMENODE");
		Game g1 = new Game(gn1);
		Game g2  = new Game(null);
		
		/*LEVELNODE
	private Store myStore;
	private Grid myGrid;
	private HeadsUpDisplay myHUD;
	private ArrayList<Condition> myConditions;
	private LevelStats myGameStats;
	private long myStartTime;
	private long myTotalTime;
		 */
		
		Grid grid = new Grid(5, 5);

		
		
		// saving t1 to a file named by the user's choice.
		try {
			XMLWriter.SaveGameData(g1);
		} catch (IOException e) {
			System.out.println("Failed to save file: " + e);
		}

		// loading the file into t2
		try {
			g2 = (Game) XMLWriter.LoadGameData();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}

		// test if t2 is now t1
		System.out.println(g2.getHead().getName());
	}
	
}
