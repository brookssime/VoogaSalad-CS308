package gae;

import gae.model.Model;
import gae.model.Receiver;
import javafx.stage.Stage;

/**
 * 
 * @author Peter
 * This class creates the scene, stage, and the Model for the view to display.
 *
 */
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