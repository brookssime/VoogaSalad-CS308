package gae.view.gameEditor;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ConditionNode extends GameNode{
	
	private static final int NODE_BODY_LENGTH = 30;
	private static final int NODE_BODY_HEIGHT = 40;
	private Color myColor = Color.YELLOW;
	
	public ConditionNode() {
		formatNode();
	}

	@Override
	protected void formatNode() {
		myBody = new Rectangle(NODE_BODY_LENGTH, NODE_BODY_HEIGHT);
		myBody.setFill(myColor);
		myBody.setStroke(Color.BLACK);
		commonNodeInteraction();
	}

	@Override
	protected void openDialog() {
//		System.out.println("open dialog");
		
	}

}
