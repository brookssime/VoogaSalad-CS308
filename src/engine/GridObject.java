package engine;

import java.util.List;

public class GridObject extends GameObject{
	
	protected String myImagePath;
	protected List<String> myAccessNames;
	
	public void setImagePath(String imagePath){
		myImagePath = imagePath;
	}
	
	public void setAccessNAmes(List<String> accessNames){
		myAccessNames = accessNames;
	}
	
	public String getImagePath(){
		return myImagePath;
	}
	
}
