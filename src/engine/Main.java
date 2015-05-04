package engine;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import player.GameChoiceScreen;
import player.GamePlay;

public class Main extends Application {

	private GamePlay myPlayer;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Tuff Wizard");
		GameChoiceScreen gcs = new GameChoiceScreen(stage, 1400, 800);
		stage.setScene(gcs.getScene());
		stage.setResizable(false);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}