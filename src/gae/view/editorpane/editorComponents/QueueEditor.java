package gae.view.editorpane.editorComponents;

import gae.model.Receiver;
import interfaces.ParameterAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class QueueEditor extends EditorComponent{
	
	
	public QueueEditor(Receiver receiver, Method method, String objectName) {
		super(receiver, method, objectName);
	}

	@Override
	public void setUpEditor() {
		System.out.println("setting up queue editor");

		Class<?>[] parameterType = myMethod.getParameterTypes();
		Annotation[][] parameterAnnotations = myMethod
				.getParameterAnnotations();
		ArrayList<String> parameterNames = new ArrayList<>();

		for (Annotation[] annotation : parameterAnnotations) {
			if (annotation.length > 0) {
				ParameterAnnotation param = (ParameterAnnotation) annotation[0];
				parameterNames.add(param.name());
			}
		}
		
		System.out.println(parameterType.getClass().toGenericString());
		
		
	}
	
}
