package gae;

import reflection.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnemyEditor extends Group{
	private HBox myLayout;
	private Group myView;
	private VBox myForm;
	private Object myObject;
	private Button exportObject;

	//TODO: Figure how exactly this code works
	//TODO: Make sure every button goes to the right class
	
	public EnemyEditor(String className) {

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
