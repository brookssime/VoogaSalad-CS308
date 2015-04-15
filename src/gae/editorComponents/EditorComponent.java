package gae.editorComponents;

import java.lang.reflect.Method;

import engine.MethodAnnoation;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public abstract class EditorComponent extends VBox{
	
	protected Label fieldLabel;
	protected Method myMethod;
	protected Object myObject;
	
	public EditorComponent(Method method, Object object){
		myMethod = method;
		myObject = object;
		MethodAnnoation methodAnnotation = method.getAnnotation(engine.MethodAnnoation.class);
		String methodName = methodAnnotation.name();
		fieldLabel = new Label(methodName);
		this.getChildren().add(fieldLabel);
		setUpEditor();
	}
	
	public abstract void setUpEditor();
	
	

}
