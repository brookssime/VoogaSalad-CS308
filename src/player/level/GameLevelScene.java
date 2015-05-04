package player.level;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import engine.*;
import engine.gameLogic.Placement;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;
import engine.sprites.Sprite;
import engine.sprites.Tower;
import player.GraphicGameScene;
import player.manager.LevelManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class is to display the level
 */

public class GameLevelScene extends GraphicGameScene implements LevelInfo {

	private static final int MENU_SPACING = 50;
	private static final int SLIDER_SPACING = 10;
	private static final int NUM_FRAMES_PER_SECOND = 60;
	private LevelNode mylevelnode;
	private Slider animationSpeedSlider;
	private double adjustrate = 0;
	private int gamespeed = 6;
	private int currentTime = 0;
	private double screenWidth;
	private double screenHeight;
	private Button pausePlayButton;
	private static final String PAUSE_PLAY = "Pause";
	private Label levelLabel;
	private int levelNum;
	private Label moneyLabel;
	private double moneyNum;
	private Label scoreLabel;
	private double scoreNum;
	private Label healthLabel;
	private double healthNum;
	private VBox towerInfo;
	private GraphicGrid myGrid;
	private Stage primaryStage;
	private KeyFrame frame;
	private Timeline animation;
	private Button speedUpButton;
	private Button slowDownButton;
	private LevelManager myManager;
	BorderPane root;

	public GameLevelScene(Stage stage, double screenWidth, double screenHeight,
			LevelManager manager) {
		primaryStage = stage;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		levelNum = 0;
		moneyNum = 0;
		scoreNum = 0;
		adjustrate = screenWidth / 1436;
		root = makePane();
		scene = new Scene(root, screenWidth, screenHeight);
		buttons = new ArrayList<Button>();
		myNodeManager = manager;
	}

	private KeyFrame start(int framerate) {

		return new KeyFrame(Duration.millis(1000 / framerate), e -> {
			currentTime += 1;
			if (currentTime % gamespeed == 0) {
				updateLevel();
			}
		});
	}

	public void loadLevel(LevelNode level) {
		mylevelnode = level;
		scene = new Scene(makePane(), screenWidth, screenHeight);
	}

	private void updateStore(Store store) {
		towerInfo.getChildren().clear();
		Label myLabel = new Label("Towers: ");

		Set<Tower> myTowersOnSale = store.getTowersOnSale();
		for (Tower tower : myTowersOnSale) {
			TowerInfo t = new TowerInfo(tower, this);
			towerInfo.getChildren().addAll(myLabel, t.getDisplay());
		}

	}

	private void updateHUD(HeadsUpDisplay hud) {
		healthLabel.setText(Integer.toString(hud.displayHealth()));
		moneyLabel.setText(Integer.toString(hud.displayMoney()));

	}

	private void updateGrid(Grid grid) {
		Map<Sprite, Placement> myMap = grid.getSpriteMap();
		myGrid.updateGrid(grid);
		myGrid.updateSprite(myMap);
	}

	public void displayError(String errorMessage) {
		final Stage dialog = new Stage();
		dialog.initModality(Modality.NONE);
		dialog.initOwner(primaryStage);
		VBox dialogVbox = new VBox(20);
		dialogVbox.setPadding(new Insets(60, 10, 10, 10));
		dialogVbox.getChildren().add(new Text("Error: " + errorMessage));
		Scene dialogScene = new Scene(dialogVbox, 300, 200);
		dialog.setScene(dialogScene);
		dialog.show();
	}

	private BorderPane makePane() {
		BorderPane root = new BorderPane();
		root.setCenter(makeGridDisplay());
		root.setTop(makeControlPanel());
		root.setRight(makeTowerInfo());
		root.setBottom(makeInformationPanel());

		return root;
	}

	private Node makeTowerInfo() {
		towerInfo = new VBox();
		Label myLabel = new Label("Towers: ");
		towerInfo.getChildren().addAll(myLabel);
		return towerInfo;
	}

	private Node makeInformationPanel() {
		return null;
	}

	private Node makeGridDisplay() {
		myGrid = new GraphicGrid(screenWidth, screenHeight);
		return myGrid.getNode();
	}

	private Node makeControlPanel() {

		HBox result = new HBox();
		result.setSpacing(MENU_SPACING);

		pausePlayButton = makeButton(PAUSE_PLAY);
		pausePlayButton.setOnAction((e) -> pause());

		speedUpButton = makeButton("Speed Up");
		speedUpButton.setOnAction((e) -> speedUp());

		slowDownButton = makeButton("Slow Down");
		slowDownButton.setOnAction((e) -> slowDown());

		result.setSpacing(100);
		result.setPadding(new Insets(10, 30, 10, 30));

		levelLabel = new Label("Level: " + levelNum);
		moneyLabel = new Label("Money: " + moneyNum);
		scoreLabel = new Label("score: " + scoreNum);
		healthLabel = new Label("Health: " + healthNum);

		result.getChildren().addAll(levelLabel, moneyLabel, scoreLabel,
				healthLabel, pausePlayButton, speedUpButton, slowDownButton);

		return result;
	}

	/**
	 * Makes a new button with the given label.
	 * 
	 * @param property
	 *            is the desired label for the button.
	 * 
	 * @return the button so that it can be added to the control panel
	 */
	private Button makeButton(String property) {
		Button result = new Button();
		String label = property;
		result.setText(label);
		return result;
	}

	/**
	 * Load the level based on the level number
	 * 
	 * @param int level number
	 * 
	 */
	public void loadLevel(int levelnum) {

	}

	/**
	 * pause the game play
	 * 
	 */
	public void pause() {

	}

	/**
	 * resume the game play
	 * 
	 */
	public void resume() {

	}

	/**
	 * speed up the game play
	 * 
	 */
	public void speedUp() {

		myManager.increaseGameSpeed();
	}

	/**
	 * slowdown the game play
	 * 
	 */
	public void slowDown() {
		myManager.decreaseGameSpeed();
	}

	/**
	 * load the win scene
	 * 
	 */
	public void win() {
		System.out.println("win");
	}

	/**
	 * load the lose scene
	 * 
	 */
	public void lose() {
		System.out.println("lose");
	}

	/**
	 * update the whole game
	 * 
	 */
	public void updateLevel() {

	}

	/**
	 * start the next wave
	 * 
	 */
	public void startNextWave() {

	}

	public void updateLevel(Grid grid, Store store, HeadsUpDisplay hud) {
		updateGrid(grid);
		updateStore(store);
		updateHUD(hud);

	}

	@Override
	public double getMoney() {
		return moneyNum;
	}

	@Override
	public double getScore() {
		return scoreNum;
	}

	@Override
	public double getHealth() {
		return healthNum;
	}

	public void updateDroppable(String spriteID) {
		myGrid.updateDroppable(spriteID);
	}

}
