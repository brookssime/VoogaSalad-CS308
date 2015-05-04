// This entire file is part of my masterpiece.
// REYINA SENATUS

package gae.view.editorpane.editorComponents;

import java.lang.reflect.Method;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import gae.model.Receiver;

/**
 * Editor component for text area
 * @author ReyinaSenatus
 *
 */

public class TextAreaEditor extends EditorComponent{
	private TextArea areaField;
	private String contents;
	private final static int DEFAULT_COL = 20;
	
	public TextAreaEditor(Receiver receiver, Method method, String objectName) {
		super(receiver, method, objectName);
	}

	@Override
	public void setUpEditor() {
		Button area = new Button("Done");
		areaField = (myFetchedValue != null) ? new TextArea(myFetchedValue.toString()) : new TextArea();
		areaField.setWrapText(true);
		areaField.setPrefColumnCount(DEFAULT_COL);
		
		area.setOnAction(e -> {
                    contents = areaField.getParagraphs().toString();
                });
		myReceiver.runOnObject(myObject, myMethod, contents);	
		this.getChildren().add(areaField);
	}	
}
