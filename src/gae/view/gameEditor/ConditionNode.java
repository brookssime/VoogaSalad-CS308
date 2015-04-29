package gae.view.gameEditor;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import engine.NodeState;
import engine.gameScreens.NodeButton;

public class ConditionNode extends GameNode{
	
	private static final int DIALOG_STAGE_SIZE = 700;
	private static final int NODE_BODY_LENGTH = 60;
	private static final int NODE_BODY_HEIGHT = 60;
	private Color myColor = Color.YELLOW;
	private GameNode myNext;
	private boolean isButton;
	NodeState nodeState;
	
	public ConditionNode() {
		isButton = false;
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
		sceneSelect.setWidth(DIALOG_STAGE_SIZE);
		sceneSelect.setHeight(DIALOG_STAGE_SIZE);
		sceneSelect.show();
		
		//titled panes have List View and Accept Button for each selectoin
		TitledPane defaultItems = new TitledPane();
		defaultItems.setText("Default Conditions");
		defaultItems.setExpanded(true);
		
		
		ListView<String> selection = new ListView<>();
		ObservableList<String> data = FXCollections.observableArrayList();
		data.addAll(NodeState.names());
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			isButton = false;
			//bind text of selection to game node
			bindText(selection.getSelectionModel().getSelectedItem(), 
					NODE_BODY_LENGTH - 10, NODE_BODY_HEIGHT - 10);
			sceneSelect.close();
		});
		
		VBox selectionBox = new VBox(10);
		selectionBox.setPadding(new Insets(10));
		selectionBox.getChildren().addAll(selection, accept);
		
		defaultItems.setContent(selectionBox);
		
		Accordion accordion = new Accordion();
		accordion.getPanes().add(defaultItems);
		
		List<String> titleScreens = new ArrayList<>();
		titleScreens.addAll(myReceiver.getList("TitleScene"));
		
		buttonTitledPane(sceneSelect, accept, selectionBox, accordion,
				titleScreens);
		
		sceneSelect.setScene(new Scene(accordion));
		
	}

	/**
	 * Handles adding titled panes for the butttons, including fetching list of buttons from model.
	 * @param sceneSelect
	 * @param accept
	 * @param selectionBox
	 * @param accordion
	 * @param titleScreens
	 */
	private void buttonTitledPane(Stage sceneSelect, Button accept,
			VBox selectionBox, Accordion accordion, List<String> titleScreens) {
		
		for(String titleScreen: titleScreens){
			TitledPane titleScreenPane = new TitledPane();
			titleScreenPane.setText(titleScreen);
			
			ListView<String> buttonSelection = new ListView<>(); 
			ObservableList<String> data2 = FXCollections.observableArrayList();
			ArrayList<NodeButton> buttons = (ArrayList<NodeButton>) myReceiver.getButtonList(titleScreen);
			for(NodeButton b: buttons){
				data2.add(b.myInfo);
			}
			accordion.getPanes().add(titleScreenPane);
			
			Button buttonAccept = new Button("Accept");
			accept.setOnAction(e -> {
				isButton = true;
				//bind text of selection to game node
				bindText(buttonSelection.getSelectionModel().getSelectedItem(), 
						NODE_BODY_LENGTH - 10, NODE_BODY_HEIGHT - 10);
				sceneSelect.close();
			});
			
			VBox buttonSelectionBox = new VBox(10);
			buttonSelectionBox.setPadding(new Insets(10));
			buttonSelectionBox.getChildren().addAll(buttonSelection, buttonAccept);
			titleScreenPane.setContent(buttonSelectionBox);
		}
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
	
	public boolean isButton(){
		return isButton;
	}

}
