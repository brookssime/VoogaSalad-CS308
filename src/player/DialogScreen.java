package player;

import javafx.scene.Group;
import javafx.scene.Scene;


/*
 * display the dialogs which are designed by GAE
 */
public class DialogScreen implements GraphicGameScene{
	private Scene scene;
	private Group root;
	private double Width;
	private double Height;
	public DialogScreen(){
		
	}
	public Scene getScene(){
		scene = new Scene(root,Width, Height);
		return scene;
	}
	
}
