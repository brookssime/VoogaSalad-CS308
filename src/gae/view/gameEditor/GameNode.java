package gae.view.gameEditor;

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
	private In myIn;
	private Out myOut;

	public GameNode() {
		myGroup = new Group();
		myText = new Label("");
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
	
	//TODO: refactor these two methods and these two classes (In and Out)
	protected void addIn(double x, int y) {
		myIn = new In();
		myIn.getInBody().translateXProperty().bind(Bindings.add(x, 
				myBody.translateXProperty()));
		myIn.getInBody().translateYProperty().bind(Bindings.add(y, myBody.translateYProperty()));
		myGroup.getChildren().add(myIn.getInBody());
		
	}

	protected void addOut(double x, double y) {
		myOut = new Out();
		myOut.getOutBody().translateXProperty().bind(Bindings.add(x, 
				myBody.translateXProperty()));
		myOut.getOutBody().translateYProperty().bind(Bindings.add(y, myBody.translateYProperty()));
		myGroup.getChildren().add(myOut.getOutBody());
	}

	public In getMyIn() {
		return myIn;
	}

	public Out getMyOut() {
		return myOut;
	}
 
	/**
	 * format the position, color, and size of node
	 */
	protected abstract void formatNode();
	
	/**
	 * open a dialog that adds respective information to a node on double click of node
	 */
	protected abstract void openDialog();
	
	/**
	 * When an item is selected in openDialog(), the item needs to be displayed in the node. This method 
	 * does this. 
	 */
	protected abstract void bindText(String s);

}
