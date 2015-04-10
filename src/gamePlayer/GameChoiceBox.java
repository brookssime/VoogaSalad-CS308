package GamePlayer;


public class GameChoiceBox extends AbstractOverlay {

	protected static int numButtons;

	public GameChoiceBox(double overlayWidth, double overlayHeight, GameInfoBox gameInfoBox) {
		super(overlayWidth, overlayHeight);
		
		this.setMaxWidth(overlayWidth); 
		this.setMaxHeight(overlayHeight);
		this.setPrefSize(overlayWidth, overlayHeight);
		
		

	}

//	void createGameButtons(ResourceBundle rb) {
//
//		configureNumButtonsUsingExistingResourceBundle();
//
//		// Managing where to place the button
//		double fractionWidth = overlayWidth / numButtons;
//		double middleFraction = fractionWidth / 2;
//		double nextButtonCenter = 1 * middleFraction;
//
//		double buttonWidth = fractionWidth * .8;
//
//		for (int i = 0; i < numButtons; i++) {
//
//			String nextButtonLabel = null;
//
//			try {
//				nextButtonLabel = resources.getString("Alg" + (i + 1));
//			}
//
//			catch (Exception e) {
//				System.out
//						.println("AlgorithmOverlay.numButtons is set to be too large. "
//								+ "You were just protected from a crash.");
//				break;
//			}
//
//			createButtonWithLabelWithCenterXWithWidth(nextButtonLabel,
//					nextButtonCenter, buttonWidth);
//			nextButtonCenter += fractionWidth;
//
//		}
//
//	}
//
//	public void configureNumButtonsUsingExistingResourceBundle() {
//
//		GameChoiceBox.numButtons = Integer.parseInt(resources
//				.getString("numberAlgorithms"));
//
//	}
//
//	private void createButtonWithLabelWithCenterXWithWidth(String label,
//			double centerX, double buttonWidth) {
//
//		VBox v = new VBox();
//		v.setTranslateX(centerX - buttonWidth / 2);
//		v.setTranslateY(overlayHeight / 3);
//
//		Button b = new Button(label);
//		b.setPrefWidth(buttonWidth);
//		b.setPrefHeight(overlayHeight / 4);
//		b.getStyleClass().add("button-settings");
//
//		setRespectiveButtonActionWithAlgorithmName(b, label);
//
//		v.getChildren().add(b);
//		this.getChildren().add(v);
//
//	}
//
//	private void setRespectiveButtonActionWithAlgorithmName(Button b,
//			String label) {
//
//		b.setOnAction(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent event) {
//
//				// Set the button actions for each game (Likely setting an
//				// active game for the gameInformation Box)
//				System.out.println("Set Respective Button Actions");
//			}
//		});
//	}

}
