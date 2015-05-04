// This entire file is part of my masterpiece.
// YOUR NAME
package gae.view.gameeditor;

import java.util.ArrayList;
import java.util.List;

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


/**
 * This class is used to create the UI and functionality of a scene node in the Game Editor. The scene node
 * pops open a list of all the scenes made and can then be bound to the node.
 * @author sunjeevdevulapalli
 *
 */
public class SceneNode extends GameNode{
	
	private static final int TEXT_BUFFER = 10;
	private static final int NODE_BODY_LENGTH = 60;
	private static final int NODE_BODY_HEIGHT = 60;
	private final Color myColor = Color.WHITE;
	private List<GameNode> myConditions;
	
	
	public SceneNode(){
		formatNode();
		myConditions = new ArrayList<>();
	}

	/**
	 * Formats the body of the node. This includes the shape, color, and its In and Out connectors
	 */
	@Override
	protected void formatNode() {
		myBody = new Rectangle(NODE_BODY_LENGTH, NODE_BODY_HEIGHT);
		myBody.setFill(myColor);
		myBody.setStroke(Color.BLACK);
		addOut(myBody.getTranslateX() + NODE_BODY_LENGTH, NODE_BODY_HEIGHT / 4);
		addIn(myBody.getTranslateX() + NODE_BODY_LENGTH, 
				NODE_BODY_HEIGHT * 3 / 4);
		commonNodeInteraction();
		
	}

	/**
	 * This method is what is called when a node is double clicked. For Scene node this will
	 * pop open a list of all the possible scenes in which the designer must choose from.
	 */
	@Override
	protected void openDialog() {
		Stage sceneSelect = new Stage();
		sceneSelect.show();
		ListView<String> selection = new ListView<>();
		ObservableList<String> data = FXCollections.observableArrayList();
		data.addAll(myReceiver.getList("TitleScene"));
		data.addAll(myReceiver.getList("DialogueNode"));
		data.addAll(myReceiver.getList("LevelNode"));
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			//bind text of selection to game node
			bindText(selection.getSelectionModel().getSelectedItem(), 
					NODE_BODY_LENGTH - TEXT_BUFFER, NODE_BODY_HEIGHT - TEXT_BUFFER);
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


	/**
	 * Adds a child to this node. A child is any condition node.
	 */
	public void addChild(GameNode node){
		if(!myConditions.contains(node)){
			myConditions.add(node);
		}
	}
	
	/**
	 * removes a condition node. This is called when the game designer chooses to remove a connection
	 * between nodes.
	 */
	public void removeChild(GameNode node){
		if(myConditions.contains(node)){
			myConditions.remove(node);
		}
	}

	/**
	 * Used by the game editor class to determine whether it can draw a line from this node. 
	 */
	@Override
	public boolean canDraw() {
		return true;
	}

	/**
	 * Return all of this node's children
	 */
	@Override
	public List<GameNode> getChildren() {
		return myConditions;
	}

	/**
	 * Used by game editor class to determine if this node is a button. This is always false for Scene
	 * Nodes.
	 */
	@Override
	public boolean isButton() {
		return false;
	}
}
