package engine.gameLogic;

import interfaces.MethodAnnotation;
import interfaces.ParameterAnnotation;

public abstract class GameObject {
	
	protected String myName;
	protected String myImagePath;
	
	@MethodAnnotation(editor=true, name = "Set Name", type = "textfield", fieldName = "myName")
	public void setName(String name){
		myName = name;
	}

	public String getName(){
		return myName;
	}
	
	public String toString(){
		return myName;
	}
	@MethodAnnotation(editor=true, name = "Select Image", type = "imageselect", fieldName = "myImagePath")
	public void setImagePath(@ParameterAnnotation(name="Image File")String imagePath){
		myImagePath = imagePath;
	}
	
	public String getImagePath(){
		return myImagePath;
	}
}
