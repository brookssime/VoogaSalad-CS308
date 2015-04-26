package gae.view.gameEditor;

import javafx.beans.binding.Bindings;
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
	
	private static final int NODE_BODY_LENGTH = 50;
	private static final int NODE_BODY_HEIGHT = 60;
	private Color myColor = Color.YELLOW;
	
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
		data.addAll("Game Over", "Game Won", "Button1");
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			//bind text of selection to game node
			bindText(selection.getSelectionModel().getSelectedItem());
			sceneSelect.close();
		});
		
		VBox selectionBox = new VBox(10);
		selectionBox.setPadding(new Insets(10));
		selectionBox.getChildren().addAll(selection, accept);
		sceneSelect.setScene(new Scene(selectionBox));
		
	}

	//TODO: refactor
	@Override
	protected void bindText(String s) {
		myText.setText(s);
		myText.setPickOnBounds(false);
		myText.setPrefSize(NODE_BODY_LENGTH, NODE_BODY_HEIGHT);
		//buffer with binding
		myText.translateXProperty().bind(Bindings.add(5, myBody.translateXProperty()));
		myText.translateYProperty().bind(myBody.translateYProperty());
		
		
		try{
			myGroup.getChildren().add(myText);
		} catch(IllegalArgumentException e){
			System.out.println("fix this later");
		}
		
	}

}
