package gae.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;

public class EditorComponentFactory {
	
	
	public EditorComponent generateComponent(String editorType, Receiver receiver, Method method, String classname, String objName){
		if (editorType.equalsIgnoreCase("textfield")){
			return (new TextFieldEditor(receiver, method, classname, objName));
		}
		else if (editorType.equalsIgnoreCase("fileselect")){
			return (new FileSelector(receiver, method, classname, objName ));
		}
		
		//we should implement a better error handling here.
		throw new RuntimeException("Unable to generate the name editor component type: "+ editorType);
	}

}
