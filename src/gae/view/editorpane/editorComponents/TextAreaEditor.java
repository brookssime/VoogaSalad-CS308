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
	TextArea areaField;
	String contents;
	private final static int DEFAULT_COL = 20;
	
	public TextAreaEditor(Receiver receiver, Method method, String objectName) {
		super(receiver, method, objectName);
	}

	@Override
	public void setUpEditor() {
		Button area = new Button("Done");
		
		if (myFetchedValue!= null){
            areaField = new TextArea(myFetchedValue.toString());
        }
		else{
			areaField = new TextArea();
		}
		areaField.setWrapText(true);
		areaField.setPrefColumnCount(DEFAULT_COL);
		
		area.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	contents = areaField.getParagraphs().toString();
                    }
                });
		myReceiver.runOnObject(myObject, myMethod, contents);	
	}

	
}
