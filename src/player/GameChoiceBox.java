package player;

import java.util.ArrayList;
import java.util.List;

import engine.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/*
 * display the available games and let player to choose
 */
public class GameChoiceBox extends AbstractOverlay {

	//protected static int numButtons;
	protected GameInfoBox gameInfoBox;
	protected List<Game> availGames;

	public GameChoiceBox(double overlayWidth, double overlayHeight,
			GameInfoBox gameInfoBox, List<Game> availGames) {
		super(overlayWidth, overlayHeight);

		this.setMaxWidth(overlayWidth);
		this.setMaxHeight(overlayHeight);
		this.setPrefSize(overlayWidth, overlayHeight);
		this.gameInfoBox = gameInfoBox;
		this.availGames = availGames;
		
		this.setStyle("-fx-background-color: #98fb98;");
		
		// Entirely for testing, this will be populated by some game data
		List<String> games = new ArrayList<String>();
		createGameButtons(availGames);
	}

	void createGameButtons(List<Game> availGames) {

		// Managing where to place the button
		int numButtons = availGames.size();
		System.out.println(numButtons);
		double fractionHeight = overlayHeight / numButtons;
		double middleFraction = fractionHeight / 2;
		double nextButtonCenter = 1 * middleFraction;
		double buttonHeight = fractionHeight * .8;

		for (int i = 0; i < numButtons; i++) {

			String nextButtonLabel = null;

			try {
				nextButtonLabel = availGames.get(i).getName(); //in reality will be games.get(i).getName();
			} catch (Exception e) {
				System.out
						.println("AlgorithmOverlay.numButtons is set to be too large. "
								+ "You were just protected from a crash.");
				break;
			}
			createButtonWithLabelWithCenterXWithWidth(nextButtonLabel,
					nextButtonCenter, buttonHeight, i);
			nextButtonCenter += fractionHeight;
		}
	}


	private void createButtonWithLabelWithCenterXWithWidth(String label,
			double centerX, double buttonHeight, int i) {

		VBox v = new VBox();
		v.setTranslateY(centerX - buttonHeight / 2);
		v.setTranslateX(overlayWidth * .1);

		Button b = new Button(label);
		b.getStylesheets().add("playerStyle.css");
		b.setPrefWidth(overlayWidth * .8);
		b.setPrefHeight(buttonHeight);
		b.getStyleClass().add("button-settings");

		setRespectiveButtonActionWithAlgorithmName(b, label, i);
		v.getChildren().add(b);
		this.getChildren().add(v);

	}

	private void setRespectiveButtonActionWithAlgorithmName(Button b,
			String label, int i) {

		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				//Set the selected game at the active game within the information box
				System.out.println("Set Respective Button Actions");
				
				gameInfoBox.setActiveGame(availGames.get(i));
				
			}
		});
	}

}
