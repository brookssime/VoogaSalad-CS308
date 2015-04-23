package gae.view.gameEditor;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public abstract class GameNode {
	
	

	private Group myGroup;
	protected Rectangle myBody;

	public GameNode() {
		myGroup = new Group();
	}
	
	protected void commonNodeInteraction() {
		//better way to center node?
		myBody.setTranslateX(260);
		myBody.setTranslateY(270);
		
		myBody.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				myBody.setTranslateX(event.getSceneX() - myBody.getWidth() / 2);
				myBody.setTranslateY(event.getSceneY() - myBody.getHeight() / 2);
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

	public Group getGroup(){
		return myGroup;
	}
	
	/**
	 * format the position, color, and size of node
	 */
	protected abstract void formatNode();
	
	/**
	 * open a dialog that adds respective information to a node on double click of node
	 */
	protected abstract void openDialog();

}
