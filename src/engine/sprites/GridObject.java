package engine.sprites;

import interfaces.MethodAnnotation;
import interfaces.ParameterAnnotation;

import java.util.List;

import engine.gameLogic.GameObject;

public abstract class GridObject extends GameObject{
	
	protected String myImagePath;
	protected List<String> myAccessNames;
	
	@MethodAnnotation(editor=true, name = "Select Image", type = "imageselect", fieldName = "myImagePath")
	public void setImagePath(@ParameterAnnotation(name="Image File")String imagePath){
		myImagePath = imagePath;
	}
	
	public void setAccessNames(List<String> accessNames){
		myAccessNames = accessNames;
	}
	
	public String getImagePath(){
		return myImagePath;
	}

	public List<String> getAccessNames(){
		return myAccessNames;
	}
}