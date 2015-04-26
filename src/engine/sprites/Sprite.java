package engine.sprites;

import java.util.List;
import java.util.Map;

import engine.gameLogic.GameObject;
import engine.gameLogic.Placement;

public abstract class Sprite extends GameObject{
	
	protected String myImagePath;
	protected List<String> myAccessNames;
	protected Map<String, String> mySpriteInfo;
	
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

	public abstract Placement move();
	public abstract boolean isDead();
	
	public abstract void fillSpriteInfo();
}