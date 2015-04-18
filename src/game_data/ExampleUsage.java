package game_data;

import java.io.IOException;

import engine.Tower;



public class ExampleUsage {

	public static void main(String[] args) {
		
		Tower t1 = new Tower();
		Tower t2 = new Tower();
		
		t1.setName("tower 1");
		t2.setName("tower 2");
		
		//saving t1 to a file named by the user's choice.
		try {
			GameData.SaveGameData(t1);
		} catch (IOException e) {
			System.out.println("Failed to save file: "+e);
		}
		
		//loading the file into t2
		try {
			t2 = (Tower) GameData.LoadGameData();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: "+e);
		} catch (IOException e) {
			System.out.println("IOException: "+e);
		}
		
		
		//test if t2 is now t1
		System.out.println(t2.getName());
		
		
		
		
	}

}
