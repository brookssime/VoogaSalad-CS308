package gae.view.editorpane.editorComponents;

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

	private static final double SPACING = 10;
	protected Label fieldLabel;
	protected Method myMethod;
	protected String myFieldName;
	protected Receiver myReceiver;
	protected Object myFetchedValue;
	protected String myObject;
	protected String myMethodName;

	public EditorComponent(Receiver receiver, Method method, String objectName) {
		myReceiver = receiver;
		myMethod = method;
		myObject = objectName;
		myFetchedValue = null;
		MethodAnnotation methodAnnotation = myMethod
				.getAnnotation(MethodAnnotation.class);
		myMethodName = methodAnnotation.name();
		myFieldName = methodAnnotation.fieldName();
		fieldLabel = new Label(myMethodName);
		this.setSpacing(SPACING);
		try {
			try {
				myFetchedValue = myReceiver.getFromObject(myObject, myFieldName);
			} catch (ClassNotFoundException e) {
			}
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			System.out.println("Failed to fetch field value");
		}
		
		this.getChildren().add(fieldLabel);
		setUpEditor();
	}

	public abstract void setUpEditor();

}
