package player;

import java.util.ArrayList;
import java.util.List;

import engine.Game;
import game_data.GamesLoader;
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
		
		List<Game> availGames = getAvailableGames();
		
		
		GameChoiceScreen v = new GameChoiceScreen(stage, SCREENWIDTH, SCREENHEIGHT);
		
		stage.setTitle("Game Chooser");
		stage.setScene(v.getScene());
		stage.setResizable(false);
		stage.show();
	}
	
	private List<Game> getAvailableGames() {
		// Method For testing purposes
		// Will eventually be populated with a list of available games. 
		
		ExistingGameLoader gl = new ExistingGameLoader();
		
		List<Game> availGames = new ArrayList<Game>();
		availGames = gl.getGameList();
		
		
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
