package player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Scene;
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
	
	private Stage stage;
	
	public GameChoiceScreen(Stage stage, double screenWidth, double screenHeight, List<GameData> availGames){
		
		this.root = new Group();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		this.infoBoxWidth = infoBoxWidthPct * screenWidth;
		this.infoBoxHeight = infoBoxHeightPct * screenHeight;
		this.stage = stage;
		
		GameData gameData = new GameData("Name", "Description", "../resources/tower-defense-games.png");
		
		GameInfoBox gameInfoBox = new GameInfoBox(stage, infoBoxWidth, infoBoxHeight, gameData);
		gameInfoBox.setLayoutX(.35 * screenWidth);
		gameInfoBox.setLayoutY(.15 * screenHeight);
		
		double choiceBoxWidth = choiceBoxWidthPct * screenWidth;
		double choiceBoxHeight = choiceBoxHeightPct * screenHeight; 
		
		Map<GameData, GameInfoBox> gameInfoScreensMap = new HashMap<GameData, GameInfoBox>();
		
		generateGameInfoScreensMap(availGames);
		
		GameChoiceBox gameChoiceBox = new GameChoiceBox(choiceBoxWidth, choiceBoxHeight, gameInfoBox, availGames);
		
		
		root.getChildren().add(gameChoiceBox);
		root.getChildren().add(gameInfoBox);
		
		//gameChoiceBox.setLayoutX(.1 * screenWidth);
		gameChoiceBox.setLayoutY(.15 * screenHeight);
		
		
	}
	
	private void generateGameInfoScreensMap(List<GameData> availGames) {
		
		Map<GameData, GameInfoBox> gameInfoScreensMap = new HashMap<GameData, GameInfoBox>();
		
		for(GameData gameData: availGames){
			
			GameInfoBox gameInfoBox = new GameInfoBox(stage, infoBoxWidth, infoBoxHeight, gameData);
			gameInfoScreensMap.put(gameData, gameInfoBox);
			
		}
		
	}

	public Scene getScene(){
		scene = new Scene(root,screenWidth, screenHeight);
		return scene;
	}

}
