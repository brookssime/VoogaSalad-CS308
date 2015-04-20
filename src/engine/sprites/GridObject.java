package engine.sprites;

import java.util.List;

import engine.gameLogic.GameObject;

public abstract class GridObject extends GameObject{
	
	protected String myImagePath;
	protected List<String> myAccessNames;
	
	public void setImagePath(String imagePath){
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