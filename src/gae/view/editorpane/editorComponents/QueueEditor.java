package gae.view.editorpane.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import reflection.Reflection;

public class QueueEditor extends EditorComponent{
	
	private HBox lowerBox;
	private HBox elementsDisplay;
	private Button addButton;
	private Button loadQueue;
	private Label loopLabel;
	private TextField loopInput;
	private ArrayList<String> elementList;
	private String elementType;
	private boolean engineElement;
	private String paramType;
	private Integer loop;
	
	private final String labelStyle = " -fx-font: 16px \"Serif\"; fx-padding: 10; -fx-background-color: silver; ";
	
	
	public QueueEditor(Receiver receiver, Method method, String objectName) {
		super(receiver, method, objectName);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void setUpEditor() {
		Class<?>[] parameterType = myMethod.getParameterTypes();
		paramType = parameterType[0].getName();
		elementType = paramType.split("\\.")[paramType.split("\\.").length-1];
		engineElement = myReceiver.isInvObject(elementType);
		
		lowerBox = new HBox();
		elementsDisplay = new HBox();
		loopLabel = new Label("Times to repeat pattern: ");
		loopInput = new TextField("1");
		elementList = new ArrayList<String>();
		addButton = new Button("ADD: ");
		loadQueue = new Button(" :FINISH");
		
		elementsDisplay.getChildren().add(addButton);
		lowerBox.getChildren().addAll(loopLabel, loopInput, loadQueue);
		getChildren().addAll(elementsDisplay, lowerBox);
		
		if (myFetchedValue!=null){
			for (Object element : (ArrayList<Object>) myFetchedValue){
				addToList(element.toString());
			}
		}
		
		addButton.setOnAction(e->{
			getElement();
		});

		loadQueue.setOnAction(e->{
			loop = Integer.parseInt(loopInput.getText());
			exportElements();
		});
		
	}
	
	private void addToList(String element){
		if (element!=null && !element.equalsIgnoreCase("")){
			elementList.add(element);
			Label newElement = new Label(" ["+element+"] ");
			newElement.setStyle(labelStyle);
			elementsDisplay.getChildren().add(newElement);
		}
	}
	
	private String getElement(){
		if (engineElement){
			Stage stage = new Stage();
			createSelection(stage, elementType);
//			ComponentsDialog dialog = new ComponentsDialog(elementType, myReceiver);
		}
		StringInputDialog dialog = new StringInputDialog();
		return dialog.getElement();
	}
	
	
	private void createSelection(Stage stage, String type) {
		VBox root = new VBox(5);
		ListView<String> selection = new ListView<String>();
		ObservableList<String> data = FXCollections.observableArrayList();
		Set<String> objects = (Set<String>) myReceiver.getList(type);
		data.addAll(objects);
		selection.setItems(data);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			addToList(selection.getSelectionModel().getSelectedItem());
			stage.close();
		});
		root.getChildren().addAll(selection, accept);
	}
	
	private void exportElements(){
		if (engineElement){
			for (int i=0; i<loop; i++){
				for (String e : elementList){
					myReceiver.runOnObjectSwap(myObject, myMethod, e);
				}
			}
			return;
		}
		for (int i=0; i<loop; i++){
			for (String e : elementList){
				Object arg = Reflection.createInstance(paramType, e);
				myReceiver.runOnObject(myObject, myMethod, arg);
			}
		}
	}
	
}
