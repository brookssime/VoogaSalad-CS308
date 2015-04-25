package gae.view.titleScreenEditor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * 
 * @author sunjeevdevulapalli
 * Allows the user to edit the title screen editor. 
 *
 */
public class TitleScreenEditor implements IButton{
	
	private static final int SCROLLPANE_HEIGHT = 80;
	private static final int VBOX_PADDING = 25;
	private static final int VBOX_SPACING = 10;
	private VBox myComponents;
	private VBox myTitles;
	private VBox myButtons;

	public TitleScreenEditor() {
		myComponents = new VBox(VBOX_SPACING);
		myComponents.setPadding(new Insets(VBOX_PADDING));
		setUpRootProperties();
	}

	private void setUpRootProperties() {
		//ADD TITLES
		ScrollPane titlePane = new ScrollPane();
		titlePane.setPrefHeight(SCROLLPANE_HEIGHT);
		myTitles = new VBox(VBOX_SPACING);
		titlePane.setContent(myTitles);
		Button addTitle = new Button("Add Title");
		addTitle.setOnAction(e -> {
			myTitles.getChildren().add(addTitle());
		});
		
		//ADD BUTTONS
		ScrollPane buttonPane = new ScrollPane();
		buttonPane.setPrefHeight(200);
		myButtons = new VBox(50);
		myButtons.setPadding(new Insets(70));
		myButtons.setAlignment(Pos.CENTER);
		buttonPane.setContent(myButtons);
		Button addButton = new Button("Add Button");
		addButton.setOnAction(e -> {
			ButtonEditor buttonEditor = new ButtonEditor(this);
			buttonEditor.setUpEditor();
		});
		
		
		myComponents.getChildren().addAll(addTitle, titlePane, addButton, buttonPane);
	}

	private Node addTitle(){
		VBox temp = new VBox();
		TextField title = new TextField();
		title.setPromptText("Name");
		
		HBox loc = new HBox();
		TextField xPos = new TextField();
		xPos.setPromptText("X Location");
		TextField yPos = new TextField();
		yPos.setPromptText("Y Location");
		loc.getChildren().addAll(xPos, yPos);
		
		temp.getChildren().addAll(title, loc);
		return temp;
		
	}
	
	public Parent getPane(){
		return myComponents;
	}

	@Override
	public void addButton(GameButton button) {
		myButtons.getChildren().add(button.getBody());
		myButtons.getChildren().add(new Separator());
	}
}
