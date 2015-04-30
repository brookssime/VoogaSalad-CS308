package gae.view.gameEditor;

import java.util.ArrayList;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SceneNode extends GameNode{
	
	private static final int NODE_BODY_LENGTH = 60;
	private static final int NODE_BODY_HEIGHT = 60;
	private Color myColor = Color.WHITE;
	private ArrayList<GameNode> myConditions;
	
	
	public SceneNode(){
		formatNode();
		myConditions = new ArrayList<>();
	}

	@Override
	protected void formatNode() {
		myBody = new Rectangle(NODE_BODY_LENGTH, NODE_BODY_HEIGHT);
		myBody.setFill(myColor);
		myBody.setStroke(Color.BLACK);
		addOut(myBody.getTranslateX() + NODE_BODY_LENGTH, NODE_BODY_HEIGHT / 4);
		addIn(myBody.getTranslateX() + NODE_BODY_LENGTH, NODE_BODY_HEIGHT * 3 / 4);
		commonNodeInteraction();
		
	}

	
	@Override
	protected void openDialog() {
		Stage sceneSelect = new Stage();
		sceneSelect.show();
		ListView<String> selection = new ListView<>();
		ObservableList<String> data = FXCollections.observableArrayList();
		Set<String> titleScreens = myReceiver.getList("TitleScene");
		Set<String> levels = myReceiver.getList("LevelNode");
		Set<String> dialogueScreens = myReceiver.getList("DialogueNode");
		data.addAll(titleScreens);
		data.addAll(dialogueScreens);
		data.addAll(levels);
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			//bind text of selection to game node
			bindText(selection.getSelectionModel().getSelectedItem(), 
					NODE_BODY_LENGTH - 10, NODE_BODY_HEIGHT - 10);
			sceneSelect.close();
		});
		
		CheckBox isHeadBox = new CheckBox("Is Head?");
		isHeadBox.setSelected(false);
		isHeadBox.selectedProperty().addListener(e -> {
			isHead = true;
		});
		
		VBox selectionBox = new VBox(10);
		selectionBox.setPadding(new Insets(10));
		selectionBox.getChildren().addAll(selection, isHeadBox, accept);
		sceneSelect.setScene(new Scene(selectionBox));
		
	}


	public void addChild(GameNode node){
		if(!myConditions.contains(node)){
			myConditions.add(node);
		}
	}
	
	public void removeChild(GameNode node){
		if(myConditions.contains(node)){
			myConditions.remove(node);
		}
	}

	@Override
	public boolean draw() {
		return true;
	}

	@Override
	public ArrayList<GameNode> getChildren() {
		return myConditions;
	}

	@Override
	public boolean isButton() {
		return false;
	}
}
