package gae;

import gae.model.Model;
import gae.model.Receiver;
import javafx.stage.Stage;

public class View {

	private Model myModel;
	private Stage myStage;
	private Display myDisplay;

	public void init(Stage stage) {
		myModel = new Model();
		myStage = stage;
		myStage.setTitle("TuffWizard GAE");
		myDisplay = new Display((Receiver) myModel);
		myStage.setScene(myDisplay.init());
		myStage.show();
	}
}