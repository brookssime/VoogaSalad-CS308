package gae.view.editorpane.editorComponents;

import gae.model.Receiver;
import interfaces.TypeAnnotation;

import java.lang.reflect.Method;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SingleSelectionEditor extends EditorComponent{

	private Button openSelection;


	public SingleSelectionEditor(Receiver receiver, Method method,
			String objectName) {
		super(receiver, method, objectName);
	}

	
	@Override
	public void setUpEditor() {
		
		TypeAnnotation typeAnnotation = myMethod
				.getAnnotation(TypeAnnotation.class);
		
		String type = typeAnnotation.type();
		
		String buttonString = myFetchedValue == null ? "Select Object" : myFetchedValue.toString();
		openSelection = new Button(buttonString);
		openSelection.setOnAction(e -> {
			Stage stage = new Stage();
			stage.setScene(new Scene(createSelection(stage, type)));
			stage.show();
		});
		
		this.getChildren().add(openSelection);
	}


	private Parent createSelection(Stage stage, String type) {
		VBox root = new VBox(5);
		ListView<String> selection = new ListView<String>();
		ObservableList<String> data = FXCollections.observableArrayList();
		Set<String> objects = myReceiver.getList(type);
		data.addAll(objects);
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			myReceiver.runOnObjectSwap(myObject, myMethod, selection.getSelectionModel().getSelectedItem());
			openSelection.setText(selection.getSelectionModel().getSelectedItem());
			stage.close();
		});
		root.getChildren().addAll(selection, accept);
		return root;
	}

}
