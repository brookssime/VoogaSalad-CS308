package player;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	private static final double SCREENWIDTH = 1000;
	private static final double SCREENHEIGHT = 800;
	/**
	 * Method start.
	 * @param stage Stage
	
	 * @throws Exception */
	@Override
	public void start(Stage stage) throws Exception {
		
		// For Testing Purposes
		
		List<GameData> availGames = getAvailableGames();
//		GameData game1 = new GameData("Game 1", "This is game 1", "../resources/tower-defense-games.png");
//		GameData game2 = new GameData("Game 2", "This is game 1", "../resources/tower-defense-games.png");
//		GameData game3 = new GameData("Game 3", "This is game 1", "../resources/tower-defense-games.png");
//		GameData game4 = new GameData("Game 4", "This is game 1", "../resources/tower-defense-games.png");
//		GameData game5 = new GameData("Game 5", "This is game 1", "../resources/tower-defense-games.png");
//		
//		List<GameData> availGames = new ArrayList<GameData>();
//		availGames.add(game1);
//		availGames.add(game2);
//		availGames.add(game3);
//		availGames.add(game4);
//		availGames.add(game5);
		
		
		GameChoiceScreen v = new GameChoiceScreen(stage, SCREENWIDTH, SCREENHEIGHT);
		
		stage.setTitle("Game Chooser");
		stage.setScene(v.getScene());
		stage.setResizable(false);
		stage.show();
	}
	
	private List<GameData> getAvailableGames() {
		// Method For testing purposes
		// Will eventually be populated with a list of available games. 
		
		GameData game1 = new GameData("Game 1", "This is game 1", "../resources/tower-defense-games.png");
		GameData game2 = new GameData("Game 2", "This is game 2", "../resources/tower-defense-games.png");
		GameData game3 = new GameData("Game 3", "This is game 3", "../resources/tower-defense-games.png");
		GameData game4 = new GameData("Game 4", "This is game 4", "../resources/tower-defense-games.png");
		GameData game5 = new GameData("Game 5", "This is game 5", "../resources/tower-defense-games.png");
		
		List<GameData> availGames = new ArrayList<GameData>();
		
		availGames.add(game1);
		availGames.add(game2);
		availGames.add(game3);
		availGames.add(game4);
		availGames.add(game5);
		
		return availGames;
	}

	/**
	 * Method main.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
