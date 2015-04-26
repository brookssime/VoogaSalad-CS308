package engine.gameLogic;

import interfaces.MethodAnnotation;
import interfaces.ParameterAnnotation;

public abstract class GameObject {
	
	protected String myName;
	
	@MethodAnnotation(editor=true, name = "Set Name", type = "textfield", fieldName = "myName")
	public void setName(@ParameterAnnotation(name=" Name ") String name){
		myName = name;
	}

	public String getName(){
		return myName;
	}
}
