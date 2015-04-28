package engine.sprites;

import interfaces.MethodAnnotation;
import interfaces.ParameterAnnotation;
import interfaces.TypeAnnotation;

import java.util.List;
import java.util.Map;

import engine.gameLogic.GameObject;
import engine.gameLogic.Placement;

public abstract class Sprite extends GameObject{
	
	protected String myImagePath;
	private Integer mySpriteHeight;
	private Integer mySpriteWidth;
	protected List<String> myAccessNames;
	protected Map<String, String> mySpriteInfo;
	
	@MethodAnnotation(editor=true, name = "Select Image", type = "imageselect", fieldName = "myImagePath")
	public void setImagePath(@ParameterAnnotation(name="Image File")String imagePath){
		myImagePath = imagePath;
	}
	
	@MethodAnnotation(editor=true, name = "Set Access Names", type = "multiselect", fieldName = "myAccessNames")
	@TypeAnnotation(type="Tile")
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
	
	public abstract void fillSpriteInfo();
	
	public Map<String, String> getSpriteInfo(){
		return mySpriteInfo;
	}

	public void setSpriteHeight(int spriteHeight){
		mySpriteHeight = spriteHeight;
	}
	
	public void setSpriteWidth(int spriteWidth){
		mySpriteWidth = spriteWidth;
	}
}