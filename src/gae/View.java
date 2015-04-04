package gae;

import javafx.stage.Stage;

public class View {

	private Stage myStage;
	private Display myDisplay;

	public void init(Stage stage) {
		myStage = stage;
		myStage.setTitle("TuffWizard GAE");
		myDisplay = new Display();
		myStage.setScene(myDisplay.init());
		myStage.show();
	}

}
