package gae.view.editorpane.editorComponents;

import gae.model.Receiver;
import gae.view.editorpane.ComponentsDialog;
import interfaces.TypeAnnotation;

import java.lang.reflect.Method;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SingleSelectionEditor extends EditorComponent{

	public SingleSelectionEditor(Receiver receiver, Method method,
			String objectName) {
		super(receiver, method, objectName);
	}

	
	@Override
	public void setUpEditor() {
		
		HBox root = new HBox(5);
		Label selectText = new Label("Select Object");
		
		TypeAnnotation typeAnnotation = myMethod
				.getAnnotation(TypeAnnotation.class);
		
		String type = typeAnnotation.annotationType().getName();
		
		
		Button openComponentsDialog = new Button(myFetchedValue.toString());
		openComponentsDialog.setOnAction(e -> {
			ComponentsDialog dialog = new ComponentsDialog(type, myReceiver);
			String ret = dialog.getElement();
			openComponentsDialog.setText(ret);
			myReceiver.runOnObjectSwap(myObject, myMethod, ret);
		});
		
		root.getChildren().addAll(selectText, openComponentsDialog);
		this.getChildren().add(root);
	}

}
