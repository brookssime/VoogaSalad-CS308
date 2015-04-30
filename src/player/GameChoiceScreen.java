package player;

import engine.Game;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameChoiceScreen {
	
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
	private ExistingGameLoader gl;
	
	List<Game> availGames;
	
	public GameChoiceScreen(Stage stage, double screenWidth, double screenHeight){
		
		this.root = new Group();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		this.infoBoxWidth = infoBoxWidthPct * screenWidth;
		this.infoBoxHeight = infoBoxHeightPct * screenHeight;
		
		double choiceBoxWidth = choiceBoxWidthPct * screenWidth;
		double choiceBoxHeight = choiceBoxHeightPct * screenHeight; 
		
		
		gl = new ExistingGameLoader();
		availGames = gl.getGameList();
		Game selectedGame = availGames.get(0);
		
		//GameData gameData = new GameData("Inital Name", "Inital Description", "../resources/tower-defense-games.png");
		
		gameInfoBox = new GameInfoBox(stage, infoBoxWidth, infoBoxHeight, selectedGame);
		gameInfoBox.setLayoutX(.35 * screenWidth);
		gameInfoBox.setLayoutY(.25 * screenHeight);
		
		GameChoiceBox gameChoiceBox = new GameChoiceBox(choiceBoxWidth, choiceBoxHeight, gameInfoBox, availGames);
		gameChoiceBox.setLayoutX(.1 * screenWidth);
		gameChoiceBox.setLayoutY(.25 * screenHeight);
		
		Text title = new Text("TuffWizard");
		title.setFont(new Font(40));
		title.setLayoutX(screenWidth * .45);
		title.setLayoutY(screenHeight * .2);
		title.setStyle("-fx-color:#00008b");
		
		root.getChildren().add(gameChoiceBox);
		root.getChildren().add(gameInfoBox);
		root.getChildren().add(title);
		
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
