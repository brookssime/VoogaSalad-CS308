package gae.view.editorpane.editorComponents;

import gae.model.Receiver;
import interfaces.ParameterAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

/**
 * This class is to set up a toggle button for the editors This class can be
 * extended to add multiple buttons and group them together Possibly add a
 * persistent toggle group (where one button is always selected) in the future
 * 
 * @author ReyinaSenatus
 *
 */

public class ToggleEditor extends EditorComponent{
	private String text;
	private ToggleButton tgb;
	
	public ToggleEditor(Receiver receiver, Method setMethod, Method getMethod,String objectName) {
		super(receiver, setMethod, objectName);
	}

	//@Override
	public void setUpEditor() {
		Annotation[][] Annotations = myMethod.getParameterAnnotations();
		Annotation[] annotationList = Annotations[0];
		ParameterAnnotation parameterAnnotation = (ParameterAnnotation) annotationList[0];
		String parameterName = parameterAnnotation.name();
		text = parameterName;
		HBox h = new HBox();
	 	h.getChildren().add(toggleButton());
	 	tgb.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                	 	myReceiver.runOnObject(myObject, myMethod, toggleStatus());
                    }
                });
	 	this.getChildren().add(h);
	}
		
	private Node toggleButton() {
		tgb = new ToggleButton(text);
		if (myFetchedValue!= null){
			tgb.setSelected(Boolean.parseBoolean(myFetchedValue.toString()));
		}
		return tgb;
	}

	private boolean toggleStatus(){
		return tgb.isSelected();
	}
}
