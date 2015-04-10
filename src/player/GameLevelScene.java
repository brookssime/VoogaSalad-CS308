package player;

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
import javafx.stage.Stage;

public class GameLevelScene implements GraphicGameScene{

	// spaces out the bottom menu
	private static final int MENU_SPACING = 50;
	private static final int SLIDER_SPACING = 10;
	private double infoBoxWidthPct = .6;
	private double infoBoxHeightPct = .7;
	private Slider animationSpeedSlider;
	private double choiceBoxWidthPct = .2;
	private double choiceBoxHeightPct = 7;
	
	
	//Group root;
	private Scene myScene;
	private double speed;
	private double screenWidth;
	private double screenHeight;
	private Button pausePlayButton;
	private static final String PAUSE_PLAY = "Pause";
	private Label levelLabel;
	private double levelNum;
	private Label moneyLabel;
	private double moneyNum;
	private Label scoreLabel;
	private double scoreNum;
	private Label healthLabel;
	private double healthNum;
	private VBox towerInfo;
	private GridPane myGrid;
	public GameLevelScene(Stage stage, double screenWidth, double screenHeight){
		//this.root = new Group();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		levelNum = 0;
		moneyNum = 0;
		scoreNum = 0;
		//double infoBoxWidth = infoBoxWidthPct * screenWidth;
		//double infoBoxHeight = infoBoxHeightPct * screenHeight;
		
		BorderPane root = new BorderPane();
        // must be first since other panels may refer to page
        root.setCenter(makeGridDisplay());
        root.setTop(makeControlPanel());
        root.setRight(makeTowerInfo());
        root.setBottom(makeInformationPanel());
        // control the navigation
       // enableButtons();
        // create scene to hold UI
        myScene = new Scene(root, screenWidth, screenHeight);
		//root.getChildren().add(gameChoiceBox);
		//root.getChildren().add(gameInfoBox);
		
	}
	
	private Node makeTowerInfo() {
		// TODO Auto-generated method stub
		towerInfo = new VBox();
		Label myLabel = new Label("Towers: ");
		TowerInfo t = new TowerInfo("../images/tower.jpg", "bacis", 100, 300, 10);
		towerInfo.getChildren().addAll(myLabel,t.getDisplay());
		return towerInfo;
	}

	private Node makeInformationPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node makeGridDisplay() {
		myGrid = new GridPane();
		for (int row = 0; row < 10; row++)
		{
			for (int column = 0; column < 15; column++)
			{
				ImageView myImage = new ImageView();
				myImage.setFitHeight(80);
				myImage.setFitWidth(80);
				myImage.setImage(new Image(getClass().getResourceAsStream("../images/wall.png")));
				myGrid.add(myImage, column, row);
			}
		}
		return myGrid;
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
	public Scene getScene() {
		
		return myScene;
	}
	public void loadLevel(){
		
	}
	public void pause(){
		
	}
	public void resume(){
		
	}
	public void speedUp(){
		
	}
	public void slowDown(){
		
	}
	public void win(){
		
	}
	public void lose(){
		
	}
	public void updateLevel(){
		
	}
	public void startNextWave(){
		
	}

	
}
