package game_data;

import java.io.IOException;







import engine.Game;
import engine.NodeState;
import engine.gameLogic.GameObject;
import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;
//import player.GameData;
import engine.sprites.Projectile;
import engine.sprites.Tower;

/**
 * an example use of the GameData class takes in two towers with names and saves
 * tower 1 and overwrites tower 2 with loaded version of tower 1.
 * 
 * @author Negatu
 *
 */

public class ExampleUsage {

	public static void main(String[] args) {

		Tower t1 = new Tower();
		Tower t2 = new Tower();
		
		GameNode gn1 = new LevelNode();
		gn1.setName("GAMENODE");
		Game g1 = new Game(gn1);
		g1.setName("Game 2");
		Game g2  = new Game(null);

		t1.setName("tower 1");
		t2.setName("tower 2");
		
		Projectile p1 = new Projectile();
		Projectile p2 = new Projectile();
		p1.setName("Projectile 1");
		p2.setName("Projectile 2");
		

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
		//System.out.println(g2.getHead().getName());

	}

}
