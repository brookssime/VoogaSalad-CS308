package engine;

import javafx.application.Application;
import javafx.stage.Stage;
import player.GameChoiceScreen;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		GameChoiceScreen gcs = new GameChoiceScreen(stage,1400,800);
		stage.setScene(gcs.getScene());
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}