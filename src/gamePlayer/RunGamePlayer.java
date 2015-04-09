package gamePlayer;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class RunGamePlayer extends Application{
	
	private static double screenWidth;
	private static double screenHeight;
	
	private Screen screen;
	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		primaryStage.setTitle("VoogaSalad Tuff Wizard Game Player");
		
		setStageToFillWindow();
		
		// Just for now, fake scene. Will change soon
		// primaryStage.setScene(menuScreen.getScene());
		MainMenu mainMenu = new MainMenu(stage,screenWidth,screenHeight);
		createMainMenuButtons(mainMenu);
		Scene initScene = mainMenu.getScene();
		
		primaryStage.setScene(initScene);
		primaryStage.show();
		
	}
	
	private void createMainMenuButtons(MainMenu mainMenu) {
		Button playGame = mainMenu.getPlayButton();
		playGame.setOnAction((event) -> {
			GameChoiceScreen gameChoiceScreen = new GameChoiceScreen(stage, screenWidth, screenHeight);
			Scene gameChoiceScene = gameChoiceScreen.getScene();
			stage.setScene(gameChoiceScene);
			stage.show();
			

		});
		
		
	}

	public void runGameChooser(){
		
	}

	
	private void setStageToFillWindow() {
			
			screen = Screen.getPrimary();
		    Rectangle2D bounds = screen.getVisualBounds();
		    stage.setX(0);
		    stage.setY(0);
		    
		    screenHeight = bounds.getHeight();
		    screenWidth = bounds.getWidth();
		    
		    stage.setWidth(screenWidth);
		    stage.setHeight(screenHeight);
	
		}
	
	public static void main(String[] args){
		launch(args);
	}
}
