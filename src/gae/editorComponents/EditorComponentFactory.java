package gae.editorComponents;

import java.lang.reflect.Method;

public class EditorComponentFactory {
	
	
	public EditorComponent generateComponent(String type, Method method, Object object){
		if (type.equalsIgnoreCase("textfield")){
			return (new TextFieldEditor(method, object));
		}
		else if (type.equalsIgnoreCase("fileselect")){
			return (new TextFieldEditor(method, object));
		}
		
		//we should implement a better error handling here.
		throw new RuntimeException("Unable to generate the name editor component type: "+type);
	}

}
