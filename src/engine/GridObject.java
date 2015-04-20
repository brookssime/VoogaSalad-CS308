package engine;

import java.util.List;

public abstract class GridObject{
	
	protected String myName;
	protected String myImagePath;
	protected List<String> myAccessNames;
	
	public void setName(String name){
		myName = name;
	}
	
	public void setImagePath(String imagePath){
		myImagePath = imagePath;
	}
	
	public void setAccessNames(List<String> accessNames){
		myAccessNames = accessNames;
	}
	
	public String getName(){
		return myName;
	}
	
	public String getImagePath(){
		return myImagePath;
	}
}