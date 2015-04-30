package gae.view.gridEditor;

/**
 * Class to choose a single element in the gridEditor
 * Code from SingleSelection
 * 
 * @author ReyinaSenatus
 */

import java.util.HashSet;
import java.util.Set;

import gae.view.editorpane.ComponentsDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestSingleSelect {
	private Button openSelection;
	Button open;
	HBox root;
	
	public void setUpEditor(Set<String> objects){
		String buttonString = "X";
		openSelection = new Button(buttonString);
		openSelection.setOnAction(e -> {
			Stage stage = new Stage();
			stage.setScene(new Scene(createSelection(stage, objects)));
			stage.show();
		});
	}
	
	public Node root(){
		return openSelection;
	}
	
	private Parent createSelection(Stage stage, Set<String> objects) {
		VBox root2 = new VBox(5);
		ListView<String> selection = new ListView<String>();
		ObservableList<String> data = FXCollections.observableArrayList();	
		data.addAll(objects);
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			System.out.println("Accepted");
			openSelection.setText(selection.getSelectionModel().getSelectedItem());
			//TODO: Make is save the name
			stage.close();
		});
		root2.getChildren().addAll(selection, accept);
		return root2;
	}
	
}
