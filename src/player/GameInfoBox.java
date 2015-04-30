package player;

import java.io.IOException;

import engine.Game;
import game_data.GamesLoader;
import game_data.XMLWriter;
import player.level.GameLevelScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameInfoBox extends AbstractOverlay{
	
	protected Game activeGame;
	protected Text description;
	protected Text title;
	protected ImageView gameImageView; 
	protected Image gameImage;
	protected String gameImagePath;
	protected Stage stage;
	protected Button loadButton;
	protected Button newGameButton;

	public GameInfoBox(Stage stage, double overlayWidth, double overlayHeight, Game game) {
		super(overlayWidth, overlayHeight);
		
		this.activeGame = game;
		this.stage = stage;
				
		//MAGIC VALUES
//		this.description = new Text(10,50, gameData.gameDescription);
//		description.setFont(new Font(20));
//		description.setLayoutX(overlayWidth * .1);
//		description.setLayoutY(overlayHeight * .3);

		this.title = new Text(10,50, game.getName());
		title.setFont(new Font(20));
		title.setLayoutX(overlayWidth * .1);
		title.setLayoutY(overlayHeight * .1);
		
		this.gameImageView = new ImageView();
		//gameImage.setImage(gameData.getImage());
		gameImagePath = game.getImagePath();
		gameImage = new Image((getClass().getResourceAsStream(gameImagePath)));
		gameImageView.setFitWidth(overlayWidth * .15);
		gameImageView.setPreserveRatio(true);
		
		//MAGIC VALUES: CHANGE THIS
		gameImageView.setLayoutX(overlayWidth * .7);
		gameImageView.setLayoutY(overlayHeight * .1);
		
		this.getChildren().add(gameImageView);
		this.getChildren().add(description);
		this.getChildren().add(title);
		this.getStylesheets().add("playerStyle.css");
		addPlayButton();
		addLoadButton();
		
	}
	
	public Game getActiveGame(){
		return activeGame;
	}
	
	public void setActiveGame(Game activeGame){
		this.activeGame = activeGame;
		updateGameInformation();
		
	}
	

	private void updateGameInformation() {
		updateImage();
		updateTitle();
		updateDescription();
	}

	private void updateDescription() {
		//this.description.setText(this.gameData.gameDescription);
		
	}

	private void updateTitle() {
		this.title.setText(activeGame.getName());
		
	}

	private void updateImage() {
		gameImage = new Image((getClass().getResourceAsStream(activeGame.getImagePath())));
		this.gameImageView.setImage(gameImage);
		
	}

	public void addPlayButton(){
		newGameButton = new Button("New Game"); 
		newGameButton.setLayoutX(overlayWidth * .6);
		newGameButton.setLayoutY(overlayHeight * .8);
		newGameButton.getStylesheets().add("playerStyle.css");
		newGameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				//Open the level screen of Game Player and start a new game
				System.out.println("Open The Level and Load The Game");
				double screenHeight = stage.getHeight();
				double screenWidth = stage.getWidth();
				
				//GameLevelScene gameLevelScene = new GameLevelScene(stage, screenWidth, screenHeight);
				//stage.setScene(gameLevelScene.getScene());
				
				
			}
		});
		
		this.getChildren().add(newGameButton);
	}
	
	public void addLoadButton(){
		loadButton = new Button("Load Games");
		loadButton.setLayoutX(overlayWidth * .2);
		loadButton.setLayoutY(overlayHeight * .8);
		loadButton.getStylesheets().add("playerStyle.css");
		
//		loadButton.setOnAction(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent event) {
//				
//				System.out.println("Do Something to Load available Games");
//				
//				GamesLoader gl = new GamesLoader();
//				
//				Game selectedGame = gl.getSelectedGame();
//				
//				if (selectedGame!=null){
//					System.out.println(selectedGame.getName());
//				}
//				
//				Game g2 = new Game(null);
//				try {
//					g2 = (Game) XMLWriter.LoadGameData();
//				} catch (ClassNotFoundException e) {
//					System.out.println("Class not found: " + e);
//				} catch (IOException e) {
//					System.out.println("IOException: " + e);
//				}
//			}
//		});
		
		this.getChildren().add(loadButton);
	
	}

	public Button getLoadButton() {
		
		return loadButton;
		
	}
	
	public Button getNewGameButton(){
		return newGameButton;
	}

}
