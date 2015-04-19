/*
 * 
 */
package gae.editorComponents;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

import engine.ParameterAnnotation;
import gae.model.Receiver;
import reflection.Reflection;
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
public class TextFieldEditor extends EditorComponent {

	private HBox myBox;
	private TextField[] textFields;
	private Button setButton;

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

	public TextFieldEditor(Receiver receiver, Method method, String objectName) {
		super(receiver, method, objectName);
	}

	@Override
	public void setUpEditor() {
		myBox = new HBox();
		fieldLabel = new Label();
		myBox.getChildren().add(fieldLabel);

		Class<?>[] parameterType = myMethod.getParameterTypes();
		Annotation[][] parameterAnnotations = myMethod
				.getParameterAnnotations();
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
			myReceiver.runOnObject(myObject, myMethod, paramObjects);
		});
		myBox.getChildren().add(setButton);

		this.getChildren().add(myBox);
	}

}
