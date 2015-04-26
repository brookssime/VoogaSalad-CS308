package player;

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

	public GameInfoBox(Stage stage, double overlayWidth, double overlayHeight, GameData gameData) {
		super(overlayWidth, overlayHeight);
		
		this.gameData = gameData;
		
		//create a textArea for the description
		//GameData class, will be replaced by calls to an API from data class, exists now for testing/appearance
		//TextArea decriptionArea = new TextArea(gameData.gameDescription);
		
		//MAGIC VALUES
		this.description = new Text(10,50, gameData.gameDescription);
		description.setFont(new Font(20));
		description.setLayoutX(overlayWidth * .1);
		description.setLayoutY(overlayHeight * .3);
		
		
		// Set pref sizes
		
		//Create a title area for the game name
		//GameData class to be replaced by API calls
		//TextArea gameTitleArea = new TextArea(gameData.gameName);
		this.title = new Text(10,50, gameData.gameName);
		title.setFont(new Font(20));
		title.setLayoutX(overlayWidth * .1);
		title.setLayoutY(overlayHeight * .1);
		
		
		// Set pref sizes
		// imageView for the image
		this.gameImage = new ImageView();
		gameImage.setImage(gameData.getImage());
		gameImage.setFitWidth(overlayWidth * .15);
		gameImage.setPreserveRatio(true);
		
		//MAGIC VALUES: CHANGE THIS
		gameImage.setLayoutX(overlayWidth * .7);
		gameImage.setLayoutY(overlayHeight * .1);
		
		
		// Set locations 
		//this.getChildren().add(decriptionArea);
		//this.getChildren().add(gameTitleArea);
		
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

				//Set the selected game at the active game within the information box
				System.out.println("Do Something to Load available Games");
				
			}
		});
		
		this.getChildren().add(loadButton);
	
	}

}
