package player.level;

import java.util.Map;

import engine.*;
import engine.controller.LevelController;
import engine.gameLogic.Placement;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;
import engine.sprites.Sprite;
import engine.sprites.Tile;
import player.GraphicGameScene;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * This class is to display the level
 */



public class GameLevelScene implements GraphicGameScene{

	// spaces out the bottom menu
	private static final int MENU_SPACING = 50;
	private static final int SLIDER_SPACING = 10;
	private static final int NUM_FRAMES_PER_SECOND = 60;
	private LevelController myController;
	private LevelNode mylevelnode;
	//private double infoBoxWidthPct = .6;
	//private double infoBoxHeightPct = .7;
	private Slider animationSpeedSlider;
	//private double choiceBoxWidthPct = .2;
	//private double choiceBoxHeightPct = 7;
	private double adjustrate = 0;
	private int gamespeed = 6;
	private int currentTime = 0;
	
	//Group root;
	private Scene myScene;
	private double speed;
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
	//private GridPane myGrid;
	private GraphicGrid myGrid;
	private Stage primaryStage;
	private KeyFrame frame;
	private Timeline animation;
	//private int currentTime
	public GameLevelScene(Stage stage, double screenWidth, double screenHeight){
		//this.root = new Group();
		primaryStage = stage;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		levelNum = 0;
		moneyNum = 0;
		scoreNum = 0;
		adjustrate = screenWidth/1436;
		//double infoBoxWidth = infoBoxWidthPct * screenWidth;
		//double infoBoxHeight = infoBoxHeightPct * screenHeight;
		
		BorderPane root = makePane();
		
        // control the navigation
       // enableButtons();
        // create scene to hold UI
        myScene = new Scene(root, screenWidth, screenHeight);
		//root.getChildren().add(gameChoiceBox);
		//root.getChildren().add(gameInfoBox);
        displayError("here is the error");
        initTimeLine();
	}
	
	private void initTimeLine() {
		animation = new Timeline();
		frame = start(NUM_FRAMES_PER_SECOND);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	

	private KeyFrame start(int framerate) {
		// TODO Auto-generated method stub
		
		return new KeyFrame(Duration.millis(1000/framerate), e -> {
			currentTime +=1;
			if(currentTime % gamespeed == 0){
				updateLevel();
			}
		});
	}

	public void loadLevel(LevelNode level){
		mylevelnode = level;
		 myScene = new Scene(makePane(), screenWidth, screenHeight);
	}
/*	public void updateEnvironment(Environment environment){
		updateGrid(environment.getGrid());
		updateHUD(environment.getHUD());
		updateStore(environment.getStore());
	}*/
	
	public void updateStore(Store store) {
		// TODO Auto-generated method stub
		
	}

	public void updateHUD(HeadsUpDisplay hud) {
		// TODO Auto-generated method stub
		
	}

	public void updateGrid(Grid grid) {
		// TODO Auto-generated method stub
		Map<Sprite, Placement> myMap =grid.getSpriteMap();
		myGrid.updateSprite(myMap);
		
		
	}

	public void displayError(String errorMessage){
		final Stage dialog = new Stage();
		dialog.initModality(Modality.NONE);
		dialog.initOwner(primaryStage);
		VBox dialogVbox = new VBox(20);
		dialogVbox.setPadding(new Insets(60,10,10,10));
		dialogVbox.getChildren().add(new Text("Error: "+errorMessage));
		Scene dialogScene = new Scene(dialogVbox, 300, 200);
		dialog.setScene(dialogScene);
		dialog.show();
	}


	private BorderPane makePane(){
		BorderPane root = new BorderPane();
        // must be first since other panels may refer to page
        root.setCenter(makeGridDisplay());
        root.setTop(makeControlPanel());
        root.setRight(makeTowerInfo());
        root.setBottom(makeInformationPanel());
        
        return root;
	}
	
	private Node makeTowerInfo() {
		// TODO Auto-generated method stub
		towerInfo = new VBox();
		Label myLabel = new Label("Towers: ");
		//sample TowerInfo
		TowerInfo t = new TowerInfo("../../images/tower.jpg", "basic", (int)(adjustrate* 100), (int)(adjustrate*300), (int)(adjustrate* 10));
		towerInfo.getChildren().addAll(myLabel,t.getDisplay());
		return towerInfo;
	}

	private Node makeInformationPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node makeGridDisplay() {
		myGrid = new GraphicGrid(screenWidth, screenHeight);
		return myGrid.getNode();
	}

	private Node makeControlPanel()
	{
		HBox result = new HBox();
		result.setSpacing(MENU_SPACING);
		pausePlayButton = makeButton(PAUSE_PLAY);
		pausePlayButton.setOnAction((e)->pause());
		result.setSpacing(100);
		result.setPadding(new Insets(10,30,10,30));
		levelLabel = new Label("Level: " + levelNum);
		moneyLabel = new Label("Money: " + moneyNum);
		scoreLabel = new Label("score: " + scoreNum);
		healthLabel = new Label("Health: " + healthNum);
		//resetButton = makeButton(RESET);
		//stepButton = makeButton(STEP);
		result.getChildren().addAll(levelLabel, moneyLabel, scoreLabel, healthLabel, pausePlayButton, initiateSpeedSlider());
		return result;
	}
	
	/**
	 * Sets up the animation speed slider with its labels and listeners.
	 * 
	 * @return the slider in the form of a Node to be added to the scene
	 */
	private Node initiateSpeedSlider()
	{
		HBox result = new HBox();
		result.setSpacing(SLIDER_SPACING);
		animationSpeedSlider = new Slider(1, 4, 1);
		Label sliderLabel = new Label("Speed:");
		result.getChildren().addAll(sliderLabel, animationSpeedSlider);
		animationSpeedSlider.valueProperty().addListener(new ChangeListener<Number>()
				{
					public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue)
					{
						speed = newValue.doubleValue();
					}
				});
		return result;
	}
	/**
	 * Makes a new button with the given label.
	 * 
	 * @param property is the desired label for the button.
	 * 
	 * @return the button so that it can be added to the control panel
	 */
	private Button makeButton(String property)
	{
		Button result = new Button();
		String label = property;
		result.setText(label);
		return result;
	}
	
	
	@Override
	/**
	 * Return the level game scene for prime stage to display
	 * @return scene for prime stage to display
	 */
	public Scene getScene() {
		
		return myScene;
	}
	
	
	/**
	 * Load the level based on the level number
	 * 
	 * @param int level number
	 * 
	 */
	public void loadLevel(int levelnum){
		
	}
	
	/**
	 * pause the game play
	 * 
	 */
	public void pause(){
		
	}
	
	/**
	 * resume the game play
	 * 
	 */
	public void resume(){
		
	}
	
	/**
	 *speed up the game play
	 * 
	 */
	public void speedUp(){
		gamespeed = gamespeed/2;
	}
	
	/**
	 *slowdown the game play
	 * 
	 */
	public void slowDown(){
		gamespeed = gamespeed*2;
	}
	
	/**
	 *load the win scene
	 * 
	 */
	public void win(){
		
	}
	
	/**
	 * load the lose scene
	 * 
	 */
	public void lose(){
		
	}
	
	/**
	 *update the whole game
	 * 
	 */
	public void updateLevel(){
		//myController.update();
	}
	
	/**
	 *start the next wave
	 * 
	 */
	public void startNextWave(){
		
	}

	
}
