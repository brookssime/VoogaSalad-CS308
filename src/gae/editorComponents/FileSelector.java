package gae.editorComponents;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.swing.JFileChooser;



import engine.ParameterAnnotation;
import gae.model.Receiver;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * A file selector editor type. 
 * 
 * @author Negatu
 *
 */

public class FileSelector extends EditorComponent{

	private HBox myBox;
	private Button selectButton;
	private File selectedFile;

	public FileSelector(Receiver receiver, Method method, String classname, String objectName){
		super(receiver, method, classname, objectName);
		
	}

	@Override
	public void setUpEditor() {
		//TODO type of file (with error correction and filetering needs to be added
		//TODO ?multiple select button in case multiple select files
		
		Annotation[][] Annotations = myMethod.getParameterAnnotations();
		Annotation[] annotationList = Annotations[0];
		ParameterAnnotation parameterAnnotation = (ParameterAnnotation) annotationList[0];
		String parameterName = parameterAnnotation.name();

		
		myBox = new HBox();
		this.getChildren().add(myBox);
		selectButton = new Button(parameterName);
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
			myReceiver.runOnObject(myObj, myMethod, selectedFile);
		});

		
	}
}
