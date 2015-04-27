package player;

import player.level.GameLevelScene;
import player.manager.PlayerManager;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GamePlay {
	/*
	public int getMoney();
	public int getScore();
	public void updateMoney();
	public void updateScore();
	public Level loadLevel(int level);
	*/
	protected Scene scene;
	protected Button playGame;
	private Stage stage;
	private double screenWidth;
	private double screenHeight;
	private PlayerManager myManager;
	public GamePlay(Stage stage, double screenWidth, double screenHeight){
		Group root = new Group();
		Button playGame = new Button("Play Game");
		this.playGame = playGame;
		this.stage = stage;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		
		playGame.setLayoutX(.5 * screenWidth);
		playGame.setLayoutY(.5 * screenHeight);
		root.getChildren().add(playGame);
		this.scene = new Scene(root, screenWidth, screenHeight);
		myManager = new PlayerManager();
		
	}
	public Scene getScene() {

		GameLevelScene g = new GameLevelScene(stage, screenWidth, screenHeight, myManager);
		return g.getScene();
	}
	public void manageTimeline(Timeline animationTimeline, int frameRate) {
		// TODO Auto-generated method stub
		
	}
}
