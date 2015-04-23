package gae.view.gameEditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SceneNode extends GameNode{
	
	private static final int NODE_BODY_LENGTH = 40;
	private static final int NODE_BODY_HEIGHT = 30;
	private Color myColor = Color.WHITE;
	
	public SceneNode(){
		formatNode();
	}

	@Override
	protected void formatNode() {
		myBody = new Rectangle(NODE_BODY_LENGTH, NODE_BODY_HEIGHT);
		myBody.setFill(myColor);
		myBody.setStroke(Color.BLACK);
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
			sceneSelect.close();
		});
		
		VBox selectionBox = new VBox(10);
		selectionBox.setPadding(new Insets(10));
		selectionBox.getChildren().addAll(selection, accept);
		
	}

}
