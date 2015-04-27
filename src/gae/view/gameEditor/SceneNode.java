package gae.view.gameEditor;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SceneNode extends GameNode{
	
	private static final int NODE_BODY_LENGTH = 60;
	private static final int NODE_BODY_HEIGHT = 50;
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
		data.addAll("Level1", "Level2", "TitleScreen", "GameOver");
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			//bind text of selection to game node
			bindText(selection.getSelectionModel().getSelectedItem(), NODE_BODY_LENGTH, NODE_BODY_HEIGHT);
			sceneSelect.close();
		});
		
		VBox selectionBox = new VBox(10);
		selectionBox.setPadding(new Insets(10));
		selectionBox.getChildren().addAll(selection, accept);
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
}
