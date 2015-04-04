package GAE;

import java.util.ArrayList;

import GameEngine.GameEngineInventory;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditSelector extends Group{
	private HBox myLayout;
	private VBox myEditablesWindow;
	private Group myEditorWindow;
	private ExampleEditor myEditor;
	private Label myLabel;
	
	public EditSelector(){
		myLayout = new HBox();
		myEditablesWindow = new VBox();
		myEditorWindow = new Group();
		myLayout.getChildren().addAll(myEditablesWindow, myEditorWindow);
		this.getChildren().add(myLayout);
		
		myLabel = new Label("Select Editable");
		myEditablesWindow.getChildren().add(myLabel);
		
		ArrayList<String> editableInventory = (ArrayList<String>) GameEngineInventory.getInventory();
		for (String editable : editableInventory){
			Button selectEditable = new Button(editable);
			selectEditable.setOnAction(e->{
				myEditor = new ExampleEditor(editable);
				myEditorWindow.getChildren().add(myEditor);
			});
			myEditablesWindow.getChildren().add(selectEditable);
		}
	}
	

}
