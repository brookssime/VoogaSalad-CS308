package gae.editorComponents;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

import engine.ParameterAnnotation;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class FileSelector extends EditorComponent{

	private Button selectButton;
	private File selectedFile;

	public FileSelector(Method method, Object object){
		super(method, object);
		
	}

	@Override
	public void setUpEditor() {
		// TODO Auto-generated method stub
		
	}
}
