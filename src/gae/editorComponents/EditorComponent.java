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
	protected Method myMethod;
	protected String myFieldName;
	protected Receiver myReceiver;
	protected Object myFetchedValue;

	protected String myObject;

	public EditorComponent(Receiver receiver, Method method, String objectName) {
		myReceiver = receiver;
		myMethod = method;
		myObject = objectName;
		myFetchedValue = null;
		MethodAnnotation methodAnnotation = myMethod
				.getAnnotation(MethodAnnotation.class);
		String methodName = methodAnnotation.name();
		myFieldName = methodAnnotation.fieldName();
		fieldLabel = new Label(methodName);

		try {
			try {
				myFetchedValue = myReceiver.getFromObject(myObject, myFieldName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			System.out.println("Failed to fetch field value");
			e1.printStackTrace();
		}
		
		this.getChildren().add(fieldLabel);
		setUpEditor();
	}

	public abstract void setUpEditor();

}
