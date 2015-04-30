/*
 * 
 */
package gae.view.gridEditor;

import interfaces.ParameterAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

import gae.model.Receiver;
import reflection.Reflection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

// TODO: Auto-generated Javadoc
/**
 * A text field type editor
 * 
 * @author Negatu
 *
 */
public class TestTextField {

	private HBox myBox;
	private TextField[] textFields;
	private Button setButton;
	private String myName;
	private int myVal;
	protected Button btn;
	protected TextField textVal;

	/** The parameters length. */
	private Integer parametersLength;

	/**
	 * Instantiates a new field editor.
	 *
	 * @param obj
	 *            the object being created/edited
	 * @param method
	 *            the method used to modify the object
	 */

	// <<<<<<< HEAD
	// public TextFieldEditor(Receiver receiver, Method setMethod,
	// Method getMethod, String objectName) {
	// super(receiver, setMethod, getMethod, objectName);
	// =======

	public void setUpEditor() {
		myBox = new HBox();
		myBox.setSpacing(10);
		Label fieldLabel = new Label();
		fieldLabel.setText(myName);
		myBox.getChildren().add(fieldLabel);
		
		textVal = new TextField();
		myBox.getChildren().add(textVal);
		
		btn = new Button("Done");
		myBox.getChildren().add(btn);
		
	}
	
	public void setName(String s){
		myName = s;
	}
	
	public Node box(){
		return myBox;
	}
	
	public int val(){
		return myVal;
	}
	
	public Button btn(){
		return btn;
	}

}
