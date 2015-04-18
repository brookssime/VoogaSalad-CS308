package gae.editorComponents;

import java.lang.reflect.Method;

import engine.MethodAnnoation;
import gae.model.Receiver;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Negatu
 * An super class for all editor component types. 
 */

public abstract class EditorComponent extends VBox{
	
	protected Label fieldLabel;
	protected Method myMethod;
	protected Receiver myReceiver;
	
	protected String myType;
	protected String myObj;
	
	public EditorComponent(Receiver receiver, Method method, String classname, String objectName){
		myReceiver = receiver;
		myMethod = method;
		myType = classname;
		objectName = myObj;
		MethodAnnoation methodAnnotation = method.getAnnotation(engine.MethodAnnoation.class);
		String methodName = methodAnnotation.name();
		fieldLabel = new Label(methodName);
		this.getChildren().add(fieldLabel);
		setUpEditor();
	}
	
	public abstract void setUpEditor();
	
	

}
