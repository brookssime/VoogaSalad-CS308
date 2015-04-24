package gae.view.gameEditor;

import gae.model.Receiver;

import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import reflection.Reflection;

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
	private ArrayList<GameNode> myNodes;
	
	
	public GameEditor(Receiver receiver){
		myReceiver = receiver;
		myNodes = new ArrayList<>();
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
			myNodes.add(gameNode);
			addSelectListener(gameNode);
			myRoot.getChildren().add(gameNode.getGroup());
			nodeDialog.close();
		});
		
		VBox choice = new VBox(CHOICE_SPACING);
		choice.setPadding(new Insets(CHOICE_SPACING));
		choice.getChildren().addAll(rb1, rb2, accept);
		
		
		nodeDialog.setScene(new Scene(choice));
		nodeDialog.show();
		 
	}
	
	/**
	 * adds a listener to the node to see if it was selcted. This listener then looks for other selected of
	 * the opposite type 
	 */
	private void addSelectListener(GameNode node){
		node.getMyIn().isSelected().addListener(e -> {
			if(node.getMyIn().isSelected().getValue()){
				checkOutSelected(node);
			}
		});
		
		node.getMyOut().isSelected().addListener(e -> {
			if(node.getMyIn().isSelected().getValue()){
				checkInSelected(node);
			}
		});
			
	}

	//TODO: these two methods can be combined?
	
	/**
	 * goes through all of my nodes and checks for other selected outs. Ignores same node.
	 * @param node
	 */
	private void checkOutSelected(GameNode inNode) {
		for(GameNode n : myNodes){
			if(n.getMyOut().isSelected().getValue() && !n.equals(inNode)){
				//draw line
				Rectangle nBody = n.getMyOut().getOutBody();
				Rectangle inNodeBody = inNode.getMyIn().getInBody();
				DoubleProperty startX = new SimpleDoubleProperty();
			    DoubleProperty startY = new SimpleDoubleProperty();
			    DoubleProperty endX   = new SimpleDoubleProperty();
			    DoubleProperty endY   = new SimpleDoubleProperty();
			    startX.bind(nBody.translateXProperty());
			    startY.bind(nBody.translateYProperty());
			    endX.bind(inNodeBody.translateXProperty());
			    endY.bind(inNodeBody.translateYProperty());
				Line line = new BoundLine(startX, startY, 
						endX, endY);
				
				myRoot.getChildren().add(line);
				n.getMyOut().setSelected();
				inNode.getMyIn().setSelected();
			}
		}
		
	}

	/**
	 * goes through all of my nodes and checks for other selected ins. Ignores same node.
	 * @param node
	 */
	private void checkInSelected(GameNode outNode) {
		for(GameNode n : myNodes){
			if(n.getMyIn().isSelected().getValue() && !n.equals(outNode)){
				//draw line
				Rectangle nBody = n.getMyIn().getInBody();
				Rectangle outNodeBody = outNode.getMyOut().getOutBody();
				Line line = new Line(nBody.getTranslateX(), nBody.getTranslateY(), 
						outNodeBody.getTranslateX(), outNodeBody.getTranslateY());
				n.getMyOut().setSelected();
				myRoot.getChildren().add(line);
				n.getMyIn().setSelected();
				outNode.getMyOut().setSelected();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
