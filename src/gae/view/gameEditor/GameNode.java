package gae.view.gameEditor;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public abstract class GameNode {
	
	protected Label myText;
	protected Group myGroup;
	protected Rectangle myBody;
	private Connector myIn;
	private Connector myOut;
	private boolean isHead;

	public GameNode() {
		myGroup = new Group();
		myText = new Label("");
		isHead = false;
	}
	
	protected void commonNodeInteraction() {
		//better way to center node?
		myBody.setTranslateX(260);
		myBody.setTranslateY(270);
		
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
				if(event.getClickCount() == 2) {
					openDialog();
				};
				
			}
			
		});
		
		myGroup.getChildren().add(myBody);
		
	}

	private void moveNode(MouseEvent event) {
		myBody.setTranslateX(event.getSceneX() - myBody.getWidth() / 2);
		myBody.setTranslateY(event.getSceneY() - myBody.getHeight() / 2);
	}
	
	public Group getGroup(){
		return myGroup;
	}
	
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

	protected void addOut(double x, double y) {
		myOut = new Out();
		formatConnector(x, y, myOut);
	}

	public Connector getMyIn() {
		return myIn;
	}

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
		myText.translateXProperty().bind(Bindings.add(5, myBody.translateXProperty()));
		myText.translateYProperty().bind(myBody.translateYProperty());
		
		//TODO: FIX THIS
		try{
			myGroup.getChildren().add(myText);
		} catch(IllegalArgumentException e){
			System.out.println("fix this later");
		}
	}
	
	private void setHead(boolean bool){
		isHead = bool;
	}
	
	@Override
	public String toString(){
		return myText.getText();
	}
 
	/**
	 * format the position, color, and size of node
	 */
	protected abstract void formatNode();
	
	/**
	 * open a dialog that adds respective information to a node on double click of node
	 */
	protected abstract void openDialog();

	protected abstract void addChild(GameNode node);
	
	protected abstract void removeChild(GameNode node);
	
	public abstract ArrayList<GameNode> getChildren();
	
	public abstract boolean draw();
}
