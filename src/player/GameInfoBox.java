package player;

import player.level.GameLevelScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameInfoBox extends AbstractOverlay{
	
	protected GameData gameData;
	protected Text description;
	protected Text title;
	protected ImageView gameImage;
	protected Stage stage;

	public GameInfoBox(Stage stage, double overlayWidth, double overlayHeight, GameData gameData) {
		super(overlayWidth, overlayHeight);
		
		this.gameData = gameData;
		this.stage = stage;
				
		//MAGIC VALUES
		this.description = new Text(10,50, gameData.gameDescription);
		description.setFont(new Font(20));
		description.setLayoutX(overlayWidth * .1);
		description.setLayoutY(overlayHeight * .3);

		this.title = new Text(10,50, gameData.gameName);
		title.setFont(new Font(20));
		title.setLayoutX(overlayWidth * .1);
		title.setLayoutY(overlayHeight * .1);
		
		this.gameImage = new ImageView();
		gameImage.setImage(gameData.getImage());
		gameImage.setFitWidth(overlayWidth * .15);
		gameImage.setPreserveRatio(true);
		
		//MAGIC VALUES: CHANGE THIS
		gameImage.setLayoutX(overlayWidth * .7);
		gameImage.setLayoutY(overlayHeight * .1);
		
		this.getChildren().add(gameImage);
		this.getChildren().add(description);
		this.getChildren().add(title);
		this.getStylesheets().add("playerStyle.css");
		addPlayButton();
		addLoadButton();
		
	}
	
	public GameData getGameData(){
		return this.gameData;
	}
	
	public void setGameData(GameData gameData){
		this.gameData = gameData;
		updateGameInformation();
		
	}
	

	private void updateGameInformation() {
		updateImage();
		updateTitle();
		updateDescription();
	}

	private void updateDescription() {
		this.description.setText(this.gameData.gameDescription);
		
	}

	private void updateTitle() {
		this.title.setText(this.gameData.gameName);
		
	}

	private void updateImage() {
		this.gameImage.setImage(this.gameData.getImage());
		
	}

	public void addPlayButton(){
		Button newGame = new Button("New Game");
		newGame.setLayoutX(overlayWidth * .6);
		newGame.setLayoutY(overlayHeight * .8);
		newGame.getStylesheets().add("playerStyle.css");
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				//Open the level screen of Game Player and start a new game
				System.out.println("Open The Level and Load The Game");
				double screenHeight = stage.getHeight();
				double screenWidth = stage.getWidth();
				
				GameLevelScene gameLevelScene = new GameLevelScene(stage, screenWidth, screenHeight);
				stage.setScene(gameLevelScene.getScene());
				
				
			}
		});
		
		this.getChildren().add(newGame);
	}
	
	public void addLoadButton(){
		Button loadButton = new Button("Load Games");
		loadButton.setLayoutX(overlayWidth * .2);
		loadButton.setLayoutY(overlayHeight * .8);
		loadButton.getStylesheets().add("playerStyle.css");
		
		loadButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				System.out.println("Do Something to Load available Games");
				
			}
		});
		
		this.getChildren().add(loadButton);
	
	}

}
