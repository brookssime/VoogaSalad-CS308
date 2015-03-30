package GAE;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;



import reflection.Reflection;
import GameEngine.ParameterAnnotation;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FieldEditor extends Group {
	private HBox myBox;
	private Label fieldLabel;
	private TextField[] textFields;
	private Button setButton;
	private Integer parametersLength;
	
	public FieldEditor(Method method, Object obj){
		myBox = new HBox();
		fieldLabel = new Label();
		fieldLabel.setText(method.getName().replace("ed", "")+"    ");
		myBox.getChildren().add(fieldLabel);

		
		Class<?>[] parameterType = method.getParameterTypes();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		ArrayList<String> parameterNames = new ArrayList<>();
		parametersLength = new Integer(parameterType.length);
		
		for(Annotation[] annotation : parameterAnnotations){
			if (annotation.length>0){
				ParameterAnnotation param = (ParameterAnnotation) annotation[0];
				parameterNames.add(param.name());
			}
		}
		
		textFields = new TextField[parametersLength];
		
		for(int index=0; index<parametersLength; index++){
			Label label = new Label(parameterNames.get(index));
			TextField textField = new TextField();
			myBox.getChildren().addAll(label, textField);
			textFields[index] = textField;
		}
		
		setButton =  new Button("Set");
		setButton.setOnAction(e->{
			Object[] paramObjects = new Object[parametersLength];
			for(int index=0; index<parametersLength; index++){
				String argStr = textFields[index].getText();
				Object arg = Reflection.createInstance(parameterType[index].getName(), argStr);
				paramObjects[index] = arg;
			}
			Reflection.callMethod(obj, method.getName(), paramObjects);
		});
		myBox.getChildren().add(setButton);
		
		this.getChildren().add(myBox);
	}
	
	
}
