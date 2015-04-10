package GamePlayer;

import javafx.scene.Group;
import javafx.scene.Scene;

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
