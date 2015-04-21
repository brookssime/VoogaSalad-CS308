/*
 * 
 */
package gae;

import interfaces.ParameterAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

import reflection.Reflection;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

// TODO: Auto-generated Javadoc
/**
 * An editor that can set values of a field for an object.
 * 
 * @author Negatu
 *
 */
public class FieldEditor extends Group {
	
	/** The my box. */
	private HBox myBox;
	
	/** The field label. */
	private Label fieldLabel;
	
	/** The text fields. */
	private TextField[] textFields;
	
	/** The set button. */
	private Button setButton;
	
	/** The parameters length. */
	private Integer parametersLength;

	/**
	 * Instantiates a new field editor.
	 *
	 * @param method the method
	 * @param obj the obj
	 */
	public FieldEditor(Method method, Object obj) {
		myBox = new HBox();
		fieldLabel = new Label();
		myBox.getChildren().add(fieldLabel);

		Class<?>[] parameterType = method.getParameterTypes();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		ArrayList<String> parameterNames = new ArrayList<>();
		parametersLength = new Integer(parameterType.length);

		for (Annotation[] annotation : parameterAnnotations) {
			if (annotation.length > 0) {
				ParameterAnnotation param = (ParameterAnnotation) annotation[0];
				parameterNames.add(param.name());
			}
		}

		textFields = new TextField[parametersLength];

		for (int index = 0; index < parametersLength; index++) {
			Label label = new Label(parameterNames.get(index));
			TextField textField = new TextField();
			myBox.getChildren().addAll(label, textField);
			textFields[index] = textField;
		}

		setButton = new Button("Set");
		setButton.setOnAction(e -> {
			Object[] paramObjects = new Object[parametersLength];
			for (int index = 0; index < parametersLength; index++) {
				String argStr = textFields[index].getText();
				Object arg = Reflection.createInstance(
						parameterType[index].getName(), argStr);
				paramObjects[index] = arg;
			}
			Reflection.callMethod(obj, method.getName(), paramObjects);
		});
		myBox.getChildren().add(setButton);

		this.getChildren().add(myBox);
	}

}
