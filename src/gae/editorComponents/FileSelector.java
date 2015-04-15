package gae.editorComponents;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import reflection.Reflection;
import engine.ParameterAnnotation;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class FileSelector extends EditorComponent{

	private HBox myBox;
	private Button selectButton;
	private File selectedFile;

	public FileSelector(Method method, Object object){
		super(method, object);
		
	}

	@Override
	public void setUpEditor() {
		Class<?>[] parameterType = myMethod.getParameterTypes();
		Annotation[][] parameterAnnotations = myMethod.getParameterAnnotations();
		ArrayList<String> parameterNames = new ArrayList<>();
		Integer parametersLength = new Integer(parameterType.length);
		for (Annotation[] annotation : parameterAnnotations) {
			if (annotation.length > 0) {
				ParameterAnnotation param = (ParameterAnnotation) annotation[0];
				parameterNames.add(param.name());
			}
		}
		
		myBox = new HBox();
		this.getChildren().add(myBox);
		selectButton = new Button(parameterNames.get(0));
		myBox.getChildren().add(selectButton);
		selectButton.setOnAction(e->{
			JFileChooser fileChooser = new JFileChooser(System.getProperties()
					.getProperty("user.dir") + "/src/images");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int retval = fileChooser.showOpenDialog(null);
			if (retval != JFileChooser.APPROVE_OPTION) {
				return;
			}
			selectedFile = fileChooser.getSelectedFile();
			//invoking method on object here but will need to go through receiver later on. 
			Reflection.callMethod(myObject, myMethod.getName(), selectedFile);
		});

		
	}
}
