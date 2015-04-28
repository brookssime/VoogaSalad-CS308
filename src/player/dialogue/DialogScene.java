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
import javafx.stage.Stage;


/*
 * display the dialogs which are designed by GAE
 */
public class DialogScene extends GraphicGameScene{
	private Scene scene;

	private BorderPane root;
	private double width = 1400;
	private double height=800;
	private DialogueManager myManager;
	private List<Button> buttons;
	//private Controller myController;
	private Dialog curr;
	private Stage stage;
	public DialogScene(Stage stage, double screenWidth, double screenHeight,
			DialogueManager manager) {
		myNodeManager = manager;
		this.stage = stage;
		width = screenWidth;
		height = screenHeight;
		myManager = manager;
		root = new BorderPane();
		//myController = controller;
		curr = new Dialog();
		root.getChildren().add(curr.getDialog());
		scene = new Scene(root,width, height);
		buttons = new ArrayList<Button>();
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        System.out.println("mouse click detected! " + mouseEvent.getSource());
		        myManager.showNextDialogue();
		    }
		});
	}

//	public void nextDialog(){
//		curr.updateDialog(myController.updateDialogueImage(), myController.updateDialogueText());
//	}
	public void displayDialog(DialogueBox dialog) {

		curr.updateDialog(dialog.getImagePath(), dialog.getText());
		
	}
	
	
}
