package player;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenu {
	
	protected Scene scene;
	protected Button playGame;
	
	public MainMenu(Stage stage, double screenWidth, double screenHeight){
		
		Group root = new Group();
		Button playGame = new Button("Load Game");
		this.playGame = playGame;
		
		playGame.setLayoutX(.5 * screenWidth);
		playGame.setLayoutY(.5 * screenHeight);
		root.getChildren().add(playGame);
		this.scene = new Scene(root, screenWidth, screenHeight);
		
		
	}
	public MainMenu(double screenWidth, double screenHeight){
		Group root = new Group();
		Button playGame = new Button("Load Game");
		this.playGame = playGame;
		
		playGame.setLayoutX(.5 * screenWidth);
		playGame.setLayoutY(.5 * screenHeight);
		root.getChildren().add(playGame);
		this.scene = new Scene(root, screenWidth, screenHeight);
	}
	
	public Scene getScene(){
		return this.scene;
	}
	
	public Button getPlayButton(){
		return this.playGame;
	}


}
