/*
 * 
 */
package gae;

import gae.model.Model;
import gae.model.Receiver;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View {

	/** The my model. */
	private Model myModel;
	
	/** The my stage. */
	private Stage myStage;
	
	/** The my display. */
	private Display myDisplay;

	/**
	 * Inits the.
	 *
	 * @param stage the stage
	 */
	public void init(Stage stage) {
		myModel = new Model();
		myStage = stage;
		myStage.setTitle("TuffWizard GAE");
		myDisplay = new Display((Receiver) myModel);
		myStage.setScene(myDisplay.init());
		myStage.show();
	}
}