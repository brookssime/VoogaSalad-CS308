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

public class ConditionNode extends GameNode{
	
	private static final int NODE_BODY_LENGTH = 60;
	private static final int NODE_BODY_HEIGHT = 60;
	private Color myColor = Color.YELLOW;
	private GameNode myNext;
	
	public ConditionNode() {
		formatNode();
	}

	@Override
	protected void formatNode() {
		myBody = new Rectangle(NODE_BODY_LENGTH, NODE_BODY_HEIGHT);
		myBody.setFill(myColor);
		myBody.setStroke(Color.BLACK);
		addOut(myBody.getTranslateX() - 7, NODE_BODY_HEIGHT * 3 / 4);
		addIn(myBody.getTranslateX() - 7, NODE_BODY_HEIGHT / 4);
		commonNodeInteraction();
	}

	//TODO: refactor
	@Override
	protected void openDialog() {
		Stage sceneSelect = new Stage();
		sceneSelect.show();
		ListView<String> selection = new ListView<>();
		ObservableList<String> data = FXCollections.observableArrayList();
		data.addAll("ENEMIES_DEAD", "RUNNING", "BASE_DEAD", "COMPLETE");
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			//bind text of selection to game node
			bindText(selection.getSelectionModel().getSelectedItem(), 
					NODE_BODY_LENGTH - 10, NODE_BODY_HEIGHT - 10);
			sceneSelect.close();
		});
		
		VBox selectionBox = new VBox(10);
		selectionBox.setPadding(new Insets(10));
		selectionBox.getChildren().addAll(selection, accept);
		sceneSelect.setScene(new Scene(selectionBox));
		
	}

	@Override
	protected void addChild(GameNode node) {
		myNext = node;
		
	}

	@Override
	protected void removeChild(GameNode node) {
		myNext = null;
	}

	@Override
	public boolean draw() {
		return myNext == null;
	}

	@Override
	public ArrayList<GameNode> getChildren() {
		ArrayList<GameNode> temp = new ArrayList<GameNode>();
		temp.add(myNext);
		return temp;
	}

}
