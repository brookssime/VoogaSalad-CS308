package gae.view.titleScreenEditor;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import engine.gameScreens.NodeButton;
import gae.model.Receiver;
import gae.view.editorpane.editorComponents.EditorComponent;


/**
 * 
 * @author sunjeevdevulapalli
 * Allows the user to edit the title screen editor. 
 *
 */
public class TitleScreenEditor extends EditorComponent implements IButton{
	
	private static final int BUTTON_PADDING = 40;
	private static final int BUTTON_SPACING = 30;
	private static final int SCROLLPANE_HEIGHT = 80;
	private static final int VBOX_PADDING = 25;
	private static final int VBOX_SPACING = 10;
	private VBox myButtons;
	private HBox myWholeEditor;
	private Visualizer v;
	private VBox myComponents;
	private ArrayList<NodeButton> myButtonList;
	

	public TitleScreenEditor(Receiver receiver, Method setMethod, String objectName) {
		super(receiver, setMethod, objectName);
//		myWholeEditor = new HBox();
//		myWholeEditor.getChildren().addAll(setVisualizerProperties(), setUpRootProperties());
	}

	//not implemented
	private Parent setVisualizerProperties() {
		v = new Visualizer();
		return v.getPane();
		
	}

	private Parent setUpRootProperties() {
		myComponents = new VBox(VBOX_SPACING);
		myComponents.setPadding(new Insets(VBOX_PADDING));
		//ADD TITLES
		Pane titlePane = new Pane();
		titlePane.getChildren().add(addTitle());
		
		//ADD BUTTONS
		ScrollPane buttonPane = new ScrollPane();
		buttonPane.setPrefHeight(200);
		myButtons = new VBox(BUTTON_SPACING);
		myButtons.setPadding(new Insets(BUTTON_PADDING));
		myButtons.setAlignment(Pos.CENTER);
		buttonPane.setContent(myButtons);
		Button addButton = new Button("Add Button");
		addButton.setOnAction(e -> {
			ButtonEditor buttonEditor = new ButtonEditor(this);
			buttonEditor.setUpEditor();
		});
		
		Button save = new Button("Save");
		save.setOnAction(e -> {
			//export fields via setters to title screen
		});
		
		myComponents.getChildren().addAll(titlePane, addButton, buttonPane, save);
		return myComponents;
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
		
		TextField css = new TextField();
		css.setPromptText("Add CSS Styling");
		
		
		temp.getChildren().addAll(title, loc, css);
		return temp;
		
	}
	
	public Parent getPane(){
		return myComponents;
	}

	@Override
	public void addButton(NodeButton button) {
		myButtons.getChildren().add(build(button));
		myButtons.getChildren().add(new Separator());
		myButtonList.add(button);
	}
	
	private Node build(NodeButton button) {
		Label l = new Label(button.getInfo());
		try{
			l.setStyle(button.getStyle());
		} catch(Exception e){
			l.setStyle(button.getDefaultStyle());
		}
		
		l.setScaleX(button.getScale());
		l.setScaleY(button.getScale());
		return l;
		
	}

	public ArrayList<NodeButton> getButtons(){
		return myButtonList;
	}

	@Override
	public void setUpEditor() {
		myButtonList = new ArrayList<>();
		setUpRootProperties();
	}
}
