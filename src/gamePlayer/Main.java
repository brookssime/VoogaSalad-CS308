package GamePlayer;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	private static final double SCREENWIDTH = 1000;
	private static final double SCREENHEIGHT = 800;
	/**
	 * Method start.
	 * @param stage Stage
	
	 * @throws Exception */
	@Override
	public void start(Stage stage) throws Exception {
		GameChoiceScreen v = new GameChoiceScreen(stage, SCREENWIDTH, SCREENHEIGHT );
		
		stage.setTitle("Game Chooser");
		stage.setScene(v.getScene());
		stage.setResizable(false);
		stage.show();
	}
	
	/**
	 * Method main.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
