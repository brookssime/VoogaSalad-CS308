package gae.view.gameEditor;

import reflection.Reflection;
import gae.model.Model;
import gae.model.Receiver;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * 
 * @author sunjeevdevulapalli
 * These classes are experiments to see if visual scripting would be possible to show
 * Presumably this would extend GAEPane but as of right now it is free standing as its own application.
 *
 */
public class GameEditor {
	
	private static final int CHOICE_SPACING = 10;
	private Receiver myReceiver;
	private Pane myRoot;
	
	public GameEditor(Receiver receiver){
		myReceiver = receiver;
	}

	/**
	 * The init of this class. It will draw all the components within the scene
	 * @return the Pane in the scene
	 */
	public Parent drawGameEditor(){
		myRoot = new Pane();
		
		Button addGameNode = addNodeButton();
		
		myRoot.getChildren().addAll(addGameNode);
		return myRoot;
	}

	private Button addNodeButton() {
		//+ Button
		Button addGameNode = new Button("+");
		addGameNode.setTextAlignment(TextAlignment.CENTER);
		addGameNode.setPrefSize(30, 30);
		addGameNode.setOnAction(e -> {
			nodeChooseDialog();
		});
		return addGameNode;
	}


	private void nodeChooseDialog(){
		
		Stage nodeDialog = new Stage();
		final ToggleGroup group = new ToggleGroup();
		
		RadioButton rb1 = new RadioButton("Scene Node");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("Condition Node");
		rb2.setToggleGroup(group);
		
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			RadioButton r = (RadioButton) group.getSelectedToggle();
			
			GameNode gameNode = (GameNode) Reflection.createInstance("gae.view.gameEditor." + r.getText().replaceAll("\\s",""));
			myRoot.getChildren().add(gameNode.getGroup());
			nodeDialog.close();
		});
		
		
		VBox choice = new VBox(CHOICE_SPACING);
		choice.setPadding(new Insets(CHOICE_SPACING));
		choice.getChildren().addAll(rb1, rb2, accept);
		
		
		nodeDialog.setScene(new Scene(choice));
		nodeDialog.show();
		 
	}
}
