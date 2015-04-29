package gae.view.titleScreenEditor;

import engine.gameScreens.NodeButton;
import gae.model.Receiver;
import gae.view.editorpane.editorComponents.EditorComponent;
import interfaces.SpecialEditorAnnotation;

import java.awt.Point;
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
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * 
 * @author sunjeevdevulapalli
 * Allows the user to edit the title screen editor. 
 *
 */
public class TitleScreenEditor extends EditorComponent implements IButton{
	
	private static final int BUTTON_PADDING = 40;
	private static final int BUTTON_SPACING = 30;
	private static final int VBOX_PADDING = 25;
	private static final int VBOX_SPACING = 10;
	private static final double V_SCALE = 0.8;
	private VBox myButtons;
	private HBox myWholeEditor;
	private Visualizer v;
	private VBox myComponents;
	private ArrayList<NodeButton> myButtonList;
	private ArrayList<Method> mySpecialMethods;
	private TextField myTitle;
	private TextInputControl myXPos;
	private TextField myYPos;
	private TextField myCSS;
	

	public TitleScreenEditor(Receiver receiver, Method setMethod, String objectName) {
		super(receiver, setMethod, objectName);
	}

	//not implemented
	private Parent setVisualizerProperties() {
		v.setScale(V_SCALE);
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
			ButtonEditor buttonEditor = new ButtonEditor(this, v);
			buttonEditor.setUpEditor();
		});
		
		Button selectButton = new Button("Select Background Image");

		Point p = new Point();
		Button save = new Button("Save");
		save.setOnAction(e -> {
			p.setLocation(Double.parseDouble(myXPos.getText()), Double.parseDouble(myYPos.getText()));
			System.out.println(myButtonList);
			myReceiver.runOnObject(myObject, getMethod("Set Buttons"), myButtonList);
			myReceiver.runOnObject(myObject, getMethod("Set Title Text"), myTitle.getText());
			myReceiver.runOnObject(myObject, getMethod("Set Title Position"), p.x, p.y);
			myReceiver.runOnObject(myObject, getMethod("Set Title Style"), myCSS.getText());
		});
		
		myComponents.getChildren().addAll(titlePane, addButton, buttonPane, save);
		return myComponents;
	}

	private Node addTitle(){
		VBox temp = new VBox();
		
		myTitle = new TextField();
		myTitle.setPromptText("Name");
		
		HBox loc = new HBox();
		myXPos = new TextField();
		myXPos.setPromptText("X Location");
		myYPos = new TextField();
		myYPos.setPromptText("Y Location");
		loc.getChildren().addAll(myXPos, myYPos);
		
		myCSS = new TextField();
		myCSS.setPromptText("Add CSS Styling");
		
		v.setTextProperties(myXPos.textProperty(), 
				myYPos.textProperty(), myTitle.textProperty(), myCSS.textProperty());
		
		temp.getChildren().addAll(myTitle, loc, myCSS);
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
	
	private Method getMethod(String name){
		for(Method method : mySpecialMethods){
			SpecialEditorAnnotation specialAnnotation = method
					.getAnnotation(SpecialEditorAnnotation.class);
			if(specialAnnotation.name().equals(name)){
				return method;
			}
		}
		return null;
	}

	@Override
	public void setUpEditor() {
		myButtonList = new ArrayList<>();
		myWholeEditor = new HBox();
		v = new Visualizer();
		
		mySpecialMethods = new ArrayList<>(myReceiver.getSpecialEditorMethods(myObject));
		
		
		
		myWholeEditor.getChildren().addAll(setUpRootProperties(), setVisualizerProperties());
		this.getChildren().add(myWholeEditor);
	}
}
