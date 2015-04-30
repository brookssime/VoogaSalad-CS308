package player;

import engine.Game;
import game_data.GamesLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameChoiceScreen {
	
	// Magic Values - Not sure what to do with these 
	// as they are necessary for placement of objects within the screen
	private double infoBoxWidthPct = .6;
	private double infoBoxHeightPct = .7;
	
	private double choiceBoxWidthPct = .2;
	private double choiceBoxHeightPct = .7;
	
	Group root;
	Scene scene;
	
	private double screenWidth;
	private double screenHeight;
	
	private double infoBoxWidth;
	private double infoBoxHeight;
	
	private GameInfoBox gameInfoBox;
	private GamesLoader gl;
	
	private Stage stage;
	List<Game> availGames;
	
	public GameChoiceScreen(Stage stage, double screenWidth, double screenHeight){
		
		this.root = new Group();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		this.infoBoxWidth = infoBoxWidthPct * screenWidth;
		this.infoBoxHeight = infoBoxHeightPct * screenHeight;
		this.stage = stage;
		//availGames = getAvailableGames();
		
		ExistingGameLoader gl = new ExistingGameLoader();
		availGames = gl.getGameList();
		Game selectedGame = availGames.get(0);
		
		
		//GameData gameData = new GameData("Inital Name", "Inital Description", "../resources/tower-defense-games.png");
		
		
		gameInfoBox = new GameInfoBox(stage, infoBoxWidth, infoBoxHeight, selectedGame);
		gameInfoBox.setLayoutX(.35 * screenWidth);
		gameInfoBox.setLayoutY(.15 * screenHeight);
		
		double choiceBoxWidth = choiceBoxWidthPct * screenWidth;
		double choiceBoxHeight = choiceBoxHeightPct * screenHeight; 
		
		//Map<GameData, GameInfoBox> gameInfoScreensMap = new HashMap<GameData, GameInfoBox>();
		
		generateGameInfoScreensMap(availGames);
		GameChoiceBox gameChoiceBox = new GameChoiceBox(choiceBoxWidth, choiceBoxHeight, gameInfoBox, availGames);
		root.getChildren().add(gameChoiceBox);
		root.getChildren().add(gameInfoBox);
		
		//gameChoiceBox.setLayoutX(.1 * screenWidth);
		gameChoiceBox.setLayoutY(.15 * screenHeight);
		
		
	}
	
	private List<Game> getAvailableGames() {
		// Method For testing purposes
		// Will eventually be populated with a list of available games. 
		
		List<Game> availGames = new ArrayList<Game>();		
		return availGames;
	}
	
	private void generateGameInfoScreensMap(List<Game> availGames) {
		
		Map<Game, GameInfoBox> gameInfoScreensMap = new HashMap<Game, GameInfoBox>();
		for(Game game: availGames){	
			GameInfoBox gameInfoBox = new GameInfoBox(stage, infoBoxWidth, infoBoxHeight, game);
			gameInfoScreensMap.put(game, gameInfoBox);	
		}
	}

	public Scene getScene(){
		scene = new Scene(root,screenWidth, screenHeight);
		return scene;
	}

	public Button getLoadButton() {
		Button loadButton = gameInfoBox.getLoadButton();
		return loadButton;
	}

	public Button getNewGameButton() {
		Button newGameButton = gameInfoBox.getNewGameButton();
		return newGameButton;
	}
}
