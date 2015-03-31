package gamePlayer;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GameChoiceScreen {
	
	// Magic Values - Not sure what to do with these 
	// as they are necessary for placement of objects within the screen
	private double infoBoxWidthPct = .6;
	private double infoBoxHeightPct = .7;
	
	private double choiceBoxWidthPct = .2;
	private double choiceBoxHeightPct = 7;
	
	Group root;
	
	public GameChoiceScreen(Stage stage, GameData gameData, double screenWidth, double screenHeight){
		
		this.root = new Group();
		
		double infoBoxWidth = infoBoxWidthPct * screenWidth;
		double infoBoxHeight = infoBoxHeightPct * screenHeight;
		GameInfoBox gameInfoBox = new GameInfoBox(infoBoxWidth, infoBoxHeight, gameData);
		
		double choiceBoxWidth = choiceBoxWidthPct * screenWidth;
		double choiceBoxHeight = choiceBoxHeightPct * screenHeight; 
		
		GameChoiceBox gameChoiceBox = new GameChoiceBox(choiceBoxWidth, choiceBoxHeight, gameInfoBox);
		
		root.getChildren().add(gameChoiceBox);
		root.getChildren().add(gameInfoBox);
				
				
		
	}

}
