package player;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class GameChoiceBox extends AbstractOverlay {

	protected static int numButtons;

	public GameChoiceBox(double overlayWidth, double overlayHeight, GameInfoBox gameInfoBox) {
		super(overlayWidth, overlayHeight);
		
		this.setMaxWidth(overlayWidth); 
		this.setMaxHeight(overlayHeight);
		this.setPrefSize(overlayWidth, overlayHeight);
		
		// Entirely for testing, this will be populated by some game data
		List<String> games = new ArrayList<String>(); 
		games.add("Game 1");
		games.add("Game 2");
		games.add("Game 3");
		
		createGameButtons(games);
		
		

	}

	void createGameButtons(List<String> games ) {

		//configureNumButtonsUsingExistingResourceBundle();

		// Managing where to place the button
		numButtons = games.size();
		double fractionHeight = overlayHeight / numButtons;
		double middleFraction = fractionHeight / 2;
		double nextButtonCenter = 1 * middleFraction;
 
		double buttonWidth = overlayWidth * .75;

		for (int i = 0; i < numButtons; i++) {

			String nextButtonLabel = null;

			try {
				nextButtonLabel = "game" + games.get(i);
			}

			catch (Exception e) {
				System.out
						.println("AlgorithmOverlay.numButtons is set to be too large. "
								+ "You were just protected from a crash.");
				break;
			}

			createButtonWithLabelWithCenterXWithWidth(nextButtonLabel,
					nextButtonCenter, buttonWidth);
			nextButtonCenter += fractionHeight;

		}

	}

//	public void configureNumButtonsUsingExistingResourceBundle() {
//
//		GameChoiceBox.numButtons = Integer.parseInt(resources
//				.getString("numberAlgorithms"));
//
//	}

	private void createButtonWithLabelWithCenterXWithWidth(String label,
			double centerX, double buttonHeight) {

		VBox v = new VBox();
		v.setLayoutX(overlayWidth / 3);
		v.setLayoutY(centerX - buttonHeight / 2);

		Button b = new Button(label);
		b.setPrefWidth(overlayWidth * .75);
		b.setPrefHeight(buttonHeight);
		b.getStyleClass().add("button-settings");

		setRespectiveButtonActionWithAlgorithmName(b, label);

		v.getChildren().add(b);
		//v.setLayoutX(100);
		//v.setLayoutY(100);
		this.getChildren().add(v);

	}

	private void setRespectiveButtonActionWithAlgorithmName(Button b,
			String label) {

		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				// Set the button actions for each game (Likely setting an
				// active game for the gameInformation Box)
				System.out.println("Set Respective Button Actions");
			}
		});
	}

}
