package player;

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
	
	public GameChoiceScreen(Stage stage, double screenWidth, double screenHeight){
		
		this.root = new Group();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		double infoBoxWidth = infoBoxWidthPct * screenWidth;
		double infoBoxHeight = infoBoxHeightPct * screenHeight;
		
		GameData gameData = new GameData("Name", "Description", "../resources/tower-defense-games.png");
		
		GameInfoBox gameInfoBox = new GameInfoBox(stage, infoBoxWidth, infoBoxHeight, gameData);
		gameInfoBox.setLayoutX(.35 * screenWidth);
		gameInfoBox.setLayoutY(.15 * screenHeight);
		
		double choiceBoxWidth = choiceBoxWidthPct * screenWidth;
		double choiceBoxHeight = choiceBoxHeightPct * screenHeight; 
		
		GameChoiceBox gameChoiceBox = new GameChoiceBox(choiceBoxWidth, choiceBoxHeight, gameInfoBox);
		
		
		root.getChildren().add(gameChoiceBox);
		root.getChildren().add(gameInfoBox);
		
		//gameChoiceBox.setLayoutX(10);
		gameChoiceBox.setLayoutY(.15 * screenHeight);
		
				
		
	}
	
	public Scene getScene(){
		scene = new Scene(root,screenWidth, screenHeight);
		return scene;
	}

}
