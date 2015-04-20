/*
 * 
 */
package gae;

import reflection.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// TODO: Auto-generated Javadoc
/**
 * An example editor window that takes a class name, and creates an editor
 * window to outsource a custom instantiation.
 * 
 * @author Negatu
 *
 */

public class ExampleEditor extends Group {
	
	/** The my layout. */
	private HBox myLayout;
	
	/** The my view. */
	private Group myView;
	
	/** The my form. */
	private VBox myForm;
	
	/** The my object. */
	private Object myObject;
	
	/** The export object. */
	private Button exportObject;

	/**
	 * Instantiates a new example editor.
	 *
	 * @param className the class name
	 */
	public ExampleEditor(String className) {

		myObject = Reflection.createInstance(className);
		ArrayList<Method> objMethods = new ArrayList<Method>(
				Reflection.getEditorMethods(myObject));

		myLayout = new HBox();
		myView = new Group();
		myForm = new VBox();
		myLayout.getChildren().addAll(myView, myForm);
		this.getChildren().add(myLayout);

		exportObject = new Button("Export Object");
		exportObject.setOnAction(e -> {
			printInfo();
		});
		myView.getChildren().add(exportObject);

		for (Method method : objMethods) {
			FieldEditor aFieldEditor = new FieldEditor(method, myObject);
			myForm.getChildren().add(aFieldEditor);
		}

	}

	/**
	 * This method should be able to return/export the object made/edited for
	 * now it prints its info for testing purposes.
	 */
	public void printInfo() {
		myObject.toString();
	}

}
