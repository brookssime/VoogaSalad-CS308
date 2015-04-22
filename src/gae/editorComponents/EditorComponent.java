package gae.editorComponents;

import interfaces.MethodAnnotation;

import java.lang.reflect.Method;

import gae.model.Receiver;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Negatu An super class for all editor component types.
 */

public abstract class EditorComponent extends VBox {

	protected Label fieldLabel;
	protected Method mySetMethod;
	protected Method myGetMethod;
	protected Receiver myReceiver;

	protected String myObject;

	public EditorComponent(Receiver receiver, Method setMethod, Method getMethod, String objectName) {
		myReceiver = receiver;
		mySetMethod = setMethod;
		myGetMethod = getMethod;
		myObject = objectName;
		MethodAnnotation methodAnnotation = setMethod
				.getAnnotation(MethodAnnotation.class);
		String methodName = methodAnnotation.name();
		fieldLabel = new Label(methodName);
		this.getChildren().add(fieldLabel);
		setUpEditor();
	}

	public abstract void setUpEditor();

}
