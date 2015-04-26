package player.dialogue;

import engine.controller.Controller;
import player.GraphicGameScene;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/*
 * display the dialogs which are designed by GAE
 */
public class DialogScene implements GraphicGameScene{
	private Scene scene;
	private BorderPane root;
	private double Width = 1400;
	private double Height=800;
	private Controller myController;
	private Dialog curr;
	public DialogScene(Controller controller){
		root = new BorderPane();
		myController = controller;
		curr = new Dialog();
		root.getChildren().add(curr.getDialog());
		scene = new Scene(root,Width, Height);
	
	}
	public Scene getScene(){
		
		return scene;
	}
	public void nextDialog(){
		curr.updateDialog(myController.updateDialogueImage(), myController.updateDialogueText());
	}
	
}
