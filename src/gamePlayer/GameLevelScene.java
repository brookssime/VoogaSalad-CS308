package GamePlayer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
	public GameLevelScene(Stage stage, double screenWidth, double screenHeight){
		//this.root = new Group();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		//double infoBoxWidth = infoBoxWidthPct * screenWidth;
		//double infoBoxHeight = infoBoxHeightPct * screenHeight;
		
		BorderPane root = new BorderPane();
        // must be first since other panels may refer to page
        root.setCenter(makeGridDisplay());
        root.setTop(makeControlPanel());
        root.setLeft(makeTowerOption());
        root.setBottom(makeInformationPanel());
        // control the navigation
       // enableButtons();
        // create scene to hold UI
        myScene = new Scene(root, screenWidth, screenHeight);
		//root.getChildren().add(gameChoiceBox);
		//root.getChildren().add(gameInfoBox);
		
	}
	
	private Node makeTowerOption() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node makeInformationPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node makeGridDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node makeControlPanel()
	{
		HBox result = new HBox();
		result.setSpacing(MENU_SPACING);
		pausePlayButton = makeButton(PAUSE_PLAY);
		pausePlayButton.setOnAction((e)->pause());
		//resetButton = makeButton(RESET);
		//stepButton = makeButton(STEP);
		result.getChildren().addAll(pausePlayButton, initiateSpeedSlider());
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
		animationSpeedSlider = new Slider(0, 15, 1);
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
