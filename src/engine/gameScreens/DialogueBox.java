package engine.gameScreens;

public class DialogueBox {
	
	private String myImagePath;
	private String myText;
	
	public DialogueBox(){
		
	}
	
	public void setImageFilePath(String imagePath){
		myImagePath = imagePath;
	}
	
	public void setText(String text){
		myText = text;
	}
	
	public String getImagePath(){
		return myImagePath;
	}
	
	public String getText(){
		return myText;
	}
}