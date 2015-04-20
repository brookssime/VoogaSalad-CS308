package game_data;

import java.io.IOException;

import engine.Projectile;
import engine.Tower;

/**
 * an example use of the GameData class takes in two towers with names and saves
 * tower 1 and overwrites tower 2 with loaded version of tower 1.
 * 
 * @author Negatu
 *
 */

public class ExampleUsage {

	public static void main(String[] args) {

		Projectile p1 = new Projectile();
		Projectile p2 = new Projectile();

		p1.setName("projectile 1");
		p2.setName("projectile 2");

		// saving t1 to a file named by the user's choice.
		try {
			XMLWriter.SaveGameData(p1);
		} catch (IOException e) {
			System.out.println("Failed to save file: " + e);
		}

		// loading the file into t2
		try {
			p2 = (Projectile) XMLWriter.LoadGameData() ;
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}

		// test if t2 is now t1
		System.out.println(p2.getName());

	}

}
