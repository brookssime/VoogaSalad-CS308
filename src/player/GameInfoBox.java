package player;

import java.io.IOException;

import engine.Game;
import game_data.GamesLoader;
import game_data.SampleGameMain;
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

public class GameInfoBox extends AbstractOverlay {

	protected Game activeGame;
	protected Text description;
	protected Text title;
	protected ImageView gameImageView;
	protected Image gameImage;
	protected String gameImagePath;
	protected Stage stage;
	protected Button loadButton;
	protected Button newGameButton;
	private GamePlay myPlayer;

	public GameInfoBox(Stage stage, double overlayWidth, double overlayHeight,
			Game game) {
		super(overlayWidth, overlayHeight);

		this.activeGame = game;
		this.stage = stage;
		this.title = new Text(10, 50, game.getName());
		title.setFont(new Font(20));
		title.setStyle("-fx-fill: #bdb76b;\n" + "-fx-font-size: 32px;");
		title.setLayoutX(overlayWidth * .4);
		title.setLayoutY(overlayHeight * .035);

		this.setStyle("-fx-border-color: black;\n"
				+ "-fx-background-color: #4682b4;");

		this.gameImageView = new ImageView();
		gameImagePath = game.getImagePath();
		gameImage = new Image((getClass().getResourceAsStream(gameImagePath)));
		gameImageView.setFitWidth(overlayWidth * .4);
		gameImageView.setPreserveRatio(true);
		gameImageView.setLayoutX(overlayWidth * .3);
		gameImageView.setLayoutY(overlayHeight * .15);

		this.getChildren().add(gameImageView);
		this.getChildren().add(title);
		this.getStylesheets().add("playerStyle.css");
		addPlayButton();
		addLoadButton();

	}

	public Game getActiveGame() {
		return activeGame;
	}

	public void setActiveGame(Game activeGame) {
		this.activeGame = activeGame;
		updateGameInformation();

	}

	private void updateGameInformation() {
		updateImage();
		updateTitle();
		updateDescription();
	}

	private void updateDescription() {

	}

	private void updateTitle() {
		this.title.setText(activeGame.getName());

	}

	private void updateImage() {
		gameImage = new Image((getClass().getResourceAsStream(activeGame
				.getImagePath())));
		this.gameImageView.setImage(gameImage);

	}

	public void addPlayButton() {

		newGameButton = new Button("New Game");
		newGameButton.setLayoutX(overlayWidth * .65);
		newGameButton.setLayoutY(overlayHeight * .85);
		newGameButton.getStylesheets().add("playerStyle.css");
		newGameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				System.out.println("Open The Level and Load The Game");
				myPlayer = new GamePlay(stage, 1400, 800);
				myPlayer.getMyManager().setCurrGame(activeGame);
				myPlayer.play();
				stage.setScene(myPlayer.getScene());

			}
		});

		this.getChildren().add(newGameButton);
	}

	public void addLoadButton() {

		loadButton = new Button("Load Games");
		loadButton.setLayoutX(overlayWidth * .25);
		loadButton.setLayoutY(overlayHeight * .85);
		loadButton.getStylesheets().add("playerStyle.css");

		this.getChildren().add(loadButton);

	}

	public Button getLoadButton() {

		return loadButton;

	}

	public Button getNewGameButton() {
		return newGameButton;
	}

}
