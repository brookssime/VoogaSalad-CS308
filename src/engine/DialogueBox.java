package engine;

/**
 * TODO: What does this class do? Do we need it?
 * @author Sid
 *
 */
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