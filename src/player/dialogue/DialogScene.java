package player.dialogue;

import java.util.ArrayList;
import java.util.List;

import engine.gameScreens.DialogueBox;
import engine.gameScreens.NodeButton;
import player.GraphicGameScene;
import player.manager.DialogueManager;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


/*
 * display the dialogs which are designed by GAE
 */
public class DialogScene implements GraphicGameScene{
	private Scene scene;
	private BorderPane root;
	private double Width = 1400;
	private double Height=800;
	private DialogueManager myManager;
	private List<Button> buttons;
	//private Controller myController;
	private Dialog curr;
	public DialogScene(DialogueManager manager){
		myManager = manager;
		root = new BorderPane();
		//myController = controller;
		curr = new Dialog();
		root.getChildren().add(curr.getDialog());
		scene = new Scene(root,Width, Height);
		buttons = new ArrayList<Button>();
	
	}
	public Scene getScene(){
		
		return scene;
	}
//	public void nextDialog(){
//		curr.updateDialog(myController.updateDialogueImage(), myController.updateDialogueText());
//	}
	public void displayDialog(DialogueBox dialog) {

		curr.updateDialog(dialog.getImagePath(), dialog.getText());
		
	}
	@Override
	public void makeNodeButton(List<NodeButton> nodeButtons) {
		// TODO Auto-generated method stub
		clearButtons();
		for(NodeButton nodebutton : nodeButtons){
			Button myButton = new Button(nodebutton.getInfo());
			myButton.setOnAction((e)->{
				myManager.moveToNode(nodebutton.myTargetNodeID);
			});
			myButton.setLayoutX(nodebutton.getLocation().x);
			myButton.setLayoutY(nodebutton.getLocation().y);
			buttons.add(myButton);
			root.getChildren().add(myButton);
		}
		
	}
	private void clearButtons() {
		root.getChildren().removeAll(buttons);
		buttons.clear();
		
	}
	
}
