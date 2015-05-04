// This entire file is part of my masterpiece.
// Sajal Kantha

package player;

import player.level.GameLevelScene;
import player.manager.PlayerManager;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GamePlay {

	protected Scene scene;
	protected Button playGame;
	private Stage stage;
	private double screenWidth;
	private double screenHeight;
	private PlayerManager myManager;

	public GamePlay(Stage stage, double screenWidth, double screenHeight) {

		Group root = new Group();
		playGame = createPlayGameButton();

		this.stage = stage;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.scene = new Scene(root, screenWidth, screenHeight);

		root.getChildren().add(playGame);
		myManager = new PlayerManager(stage, screenWidth, screenHeight);
	}

	public Scene getScene() {

		GameLevelScene g = new GameLevelScene(stage, screenWidth, screenHeight,
				myManager);
		return g.getScene();
	}

	public void play() {
		myManager.play();
	}

	public PlayerManager getMyManager() {
		return myManager;
	}

	public void manageTimeline(Timeline animationTimeline, int frameRate) {

	}

	private Button createPlayGameButton() {

		Button playGameButton = new Button("Play Game");
		// Values are used for placement, button goes in middle of screen so
		// magic value OK.
		playGameButton.setLayoutX(screenWidth / 2);
		playGameButton.setLayoutY(screenHeight / 2);

		return playGameButton;
	}
}
