// This entire file is part of my masterpiece.
// YOUR NAME

package gae.view.gameeditor;

import gae.model.Receiver;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

/**
 * The superclass for nodes in the Game Editor. This class defines the general properties of all the nodes
 * and also defines some abstract mehtods that each node must implement.
 * @author sunjeevdevulapalli
 *
 */
public abstract class GameNode {
	
	private static final int TEXT_BUFFER = 5;
	private static final int DIVIDE_TWO = 2;
	private static final int CENTER_SCREEN_Y = 270;
	private static final int CENTER_SCREEN_X = 260;
	
	protected Label myText;
	protected Group myGroup;
	protected Rectangle myBody;
	private Connector myIn;
	private Connector myOut;
	protected boolean isHead;
	protected Receiver myReceiver;
	protected boolean isButton;

	protected GameNode() {
		myGroup = new Group();
		myText = new Label("");
		isHead = false;
	}
	
	public void setReceiver(Receiver receiver){
		myReceiver = receiver;
	}
	
	/**
	 * sets up the common node interactions such as if it's dragged or clicked.
	 */
	protected void commonNodeInteraction() {
		myBody.setTranslateX(CENTER_SCREEN_X);
		myBody.setTranslateY(CENTER_SCREEN_Y);
		
		myBody.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				moveNode(event);
			}
			
		});
		
		myText.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				moveNode(event);
			}
			
		});
		
		myBody.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(2 == event.getClickCount()) {
					openDialog();
				}
			}
			
		});
		
		myGroup.getChildren().add(myBody);
		
	}

	private void moveNode(MouseEvent event) {
		myBody.setTranslateX(event.getSceneX() - myBody.getWidth() / DIVIDE_TWO);
		myBody.setTranslateY(event.getSceneY() - myBody.getHeight() / DIVIDE_TWO);
	}
	
	/**
	 * Represents the visual of this node. Used by the game editor to place it in the screen.
	 * @return
	 */
	public Group getGroup(){
		return myGroup;
	}
	
	/**
	 * Called by subclass in formatNode.
	 * @param x
	 * @param y
	 */
	protected void addIn(double x, double y) {
		myIn = new In();
		formatConnector(x, y, myIn);
		
	}

	private void formatConnector(double x, double y, Connector c) {
		c.getBody().translateXProperty().bind(Bindings.add(x, 
				myBody.translateXProperty()));
		c.getBody().translateYProperty().bind(Bindings.add(y, myBody.translateYProperty()));
		myGroup.getChildren().add(c.getBody());
	}

	/**
	 * Called by subclass in formatNode
	 * @param x
	 * @param y
	 */
	protected void addOut(double x, double y) {
		myOut = new Out();
		formatConnector(x, y, myOut);
	}

	/**
	 * Used by game editor to determine if this was selected.
	 * @return
	 */
	public Connector getMyIn() {
		return myIn;
	}

	/**
	 * Used by game editor to determine if this was selected.
	 * @return
	 */
	public Connector getMyOut() {
		return myOut;
	}
	
	public String getText(){
		return myText.toString();
	}
	
	protected void bindText(String s, int length, int height){
		myText.setText(s);
		myText.setWrapText(true);
		myText.setPickOnBounds(false);
		//buffer with binding
		myText.setPrefSize(length, height);
		myText.translateXProperty().bind(Bindings.add(TEXT_BUFFER, myBody.translateXProperty()));
		myText.translateYProperty().bind(myBody.translateYProperty());
		
		myGroup.getChildren().add(myText);
	}
	
	public void setHead(boolean bool){
		isHead = bool;
	}
	
	public boolean isHead(){
		return isHead;
	}
	
	@Override
	public String toString(){
		return myText.getText();
	}
 
	/**
	 * Formats the body of the node. This includes the shape, color, and its In and Out connectors
	 */
	protected abstract void formatNode();
	
	/**
	 * This method is what is called when a node is double clicked. For Scene node this will
	 * pop open a list of all the possible scenes in which the designer must choose from.
	 */
	protected abstract void openDialog();

	/**
	 * Adds a child to this node. A child is any condition node.
	 */
	protected abstract void addChild(GameNode node);
	
	/**
	 * removes a condition node. This is called when the game designer chooses to remove a connection
	 * between nodes.
	 */
	protected abstract void removeChild(GameNode node);
	
	/**
	 * Return all of this node's children
	 */
	public abstract List<GameNode> getChildren();
	
	/**
	 * Used by the game editor class to determine whether it can draw a line from this node. 
	 */
	public abstract boolean canDraw();
	
	/**
	 * Used by game editor class to determine if this node is a button. This is always false for Scene
	 * Nodes.
	 */
	public abstract boolean isButton();
}
