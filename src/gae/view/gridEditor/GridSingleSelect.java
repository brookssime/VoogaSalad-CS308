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
import gae.model.Receiver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Group;

public class GridSingleSelect {
	private Button openSelection;
	private Button open;
	private Group g;
	private Scene sc;
	private Stage stage;
	private Accordion acc;
	
	public void setUpEditor(Set<String> objects, String type, boolean b, Receiver r){
		String buttonString = "X";
		stage = new Stage();
		g = new Group();
		sc = new Scene(g);
		acc = new Accordion();
		openSelection = new Button(buttonString);
		openSelection.setOnAction(e -> {
			TitledPane n1 = createAccordion(stage, objects, type);
			acc.getPanes().add(n1);
			acc.setExpandedPane(n1);
			
			if(b){
				Set<String> temp1 = r.getList("Port");
				TitledPane n2 = createAccordion(stage, temp1, "Port");
				acc.getPanes().add(n2);
				
				Set<String> temp2 = r.getList("Tower");
				TitledPane n3 = createAccordion(stage, temp2, "Tower");
				acc.getPanes().add(n3);
			}
			
			g.getChildren().add(acc);
			stage.setScene(sc);
			stage.show();
		});
	}
	
	public Node root(){
		return openSelection;
	}
	
	public void done(){
		stage.setScene(sc);
		stage.show();
	}
	
	public void more(Set<String> obj1, String type){
		System.out.println("g "+g);
		g.getChildren().add(createAccordion(stage, obj1, type));
	}
	
	private TitledPane createAccordion(Stage stage, Set<String> objects, String type){
		TitledPane p1 = new TitledPane();
		//createSelection(stage, objects);
		p1.setContent(createSelection(stage, objects));
		//Button text = new Button("Test");
		//p1.setContent(text);
		p1.setText(type);
		return p1;
	}
	
	private Node createSelection(Stage stage, Set<String> objects) {
		VBox root2 = new VBox(5);
		ListView<String> selection = new ListView<String>();
		ObservableList<String> data = FXCollections.observableArrayList();	
		data.addAll(objects);
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			System.out.println("Accepted");
			openSelection.setText(selection.getSelectionModel().getSelectedItem());
			stage.close();
		});
		root2.getChildren().addAll(selection, accept);
		return root2;
	}
	
}
