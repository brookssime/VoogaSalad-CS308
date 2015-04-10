package gae.editorpane;

import java.io.File;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import gae.GAEPane;
import gae.menupane.MenuAdder;

public class DialogueSceneEditor extends GAEPane{
	
	ScrollPane myScrollPane;
	
	public DialogueSceneEditor(MenuAdder adder) {
		super(DialogueSceneEditor.class.getSimpleName(), adder);
		myScrollPane = new ScrollPane();
		myRoot.getChildren().add(myScrollPane);
		myScrollPane.setContent(addContent());
	}

	//need to make a list of dialogue
	//need to be able to set a background image
	//need to be able to set a list of images for the talking heads
	private VBox addContent() {
		VBox group = new VBox(5);
		group.setPadding(new Insets(25));
		
		//Name setup
		addName(group);
		
		//Background Image select
		group.getChildren().add(addImageButton("Set Background Image: "));
		
		Button newDialogue = new Button("Add Frame");
		group.getChildren().add(newDialogue);
		newDialogue.setOnAction(e -> {
			group.getChildren().add(addDialogueScene());
		});
		
		group.getChildren().add(addDialogueScene());
		
		
		return group;
		
	}

	private VBox addDialogueScene() {
		VBox group = new VBox(5);
		//add separator
		group.getChildren().add(new Separator());
		TextArea dialogue = new TextArea();
		dialogue.setPromptText(("Enter Dialogue Scene"));
		group.getChildren().add(dialogue);
		
		group.getChildren().add(addImageButton("Add Head 1"));
		group.getChildren().add(addImageButton("Add Head 2"));
		
		return group;
	}

	private HBox addImageButton(String buttonText) {
		HBox fileButtonBox = new HBox(10);
		Button backgroundImageButton = new Button(buttonText);
		fileButtonBox.getChildren().add(backgroundImageButton);
		
		backgroundImageButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			File imageFile = fileChooser.showOpenDialog(new Stage());
			Text imagePath = new Text(imageFile.getAbsolutePath());
			fileButtonBox.getChildren().add(imagePath);
		});
		return fileButtonBox;
	}

	private void addName(VBox group) {
		HBox nameBox = new HBox(5);
		Text nameText = new Text("Name: ");
		TextField nameTextField = new TextField();
		nameBox.getChildren().addAll(nameText, nameTextField);
		group.getChildren().add(nameBox);
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
