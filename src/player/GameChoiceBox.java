package player;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/*
 * display the available games and let player to choose
 */
public class GameChoiceBox extends AbstractOverlay {

	protected static int numButtons;

	public GameChoiceBox(double overlayWidth, double overlayHeight,
			GameInfoBox gameInfoBox) {
		super(overlayWidth, overlayHeight);

		this.setMaxWidth(overlayWidth);
		this.setMaxHeight(overlayHeight);
		this.setPrefSize(overlayWidth, overlayHeight);

		// Entirely for testing, this will be populated by some game data
		List<String> games = new ArrayList<String>();
		games.add("Game 1");
		games.add("Game 2");
		games.add("Game 3");
		games.add("Game 4");
		games.add("Game 5");
		games.add("Game 6");
		games.add("Game 7");
		games.add("Game 8");
		games.add("Game 9");
		games.add("Game 10");
		games.add("Game 11");
		games.add("Game 12");
		games.add("Game 13");

		createGameButtons(games);

	}

	void createGameButtons(List<String> games) {

		// Managing where to place the button
		numButtons = games.size();
		double fractionHeight = overlayHeight / numButtons;
		double middleFraction = fractionHeight / 2;
		double nextButtonCenter = 1 * middleFraction;
		double buttonHeight = fractionHeight * .8;

		for (int i = 0; i < numButtons; i++) {

			String nextButtonLabel = null;

			try {
				nextButtonLabel = games.get(i);
			} catch (Exception e) {
				System.out
						.println("AlgorithmOverlay.numButtons is set to be too large. "
								+ "You were just protected from a crash.");
				break;
			}

			createButtonWithLabelWithCenterXWithWidth(nextButtonLabel,
					nextButtonCenter, buttonHeight);
			nextButtonCenter += fractionHeight;
		}
		

	}


	private void createButtonWithLabelWithCenterXWithWidth(String label,
			double centerX, double buttonHeight) {

		VBox v = new VBox();
		v.setTranslateY(centerX - buttonHeight / 2);
		v.setTranslateX(overlayHeight / 3);

		Button b = new Button(label);
		b.setPrefWidth(overlayWidth * .8);
		b.setPrefHeight(buttonHeight);
		b.getStyleClass().add("button-settings");

		setRespectiveButtonActionWithAlgorithmName(b, label);

		v.getChildren().add(b);
		this.getChildren().add(v);

	}

	private void setRespectiveButtonActionWithAlgorithmName(Button b,
			String label) {

		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				//Set the selected game at the active game within the information box
				System.out.println("Set Respective Button Actions");
			}
		});
	}

}
