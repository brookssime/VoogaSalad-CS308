package player;

import java.util.List;

import player.manager.LevelManager;
import player.manager.NodeManager;
import player.manager.PlayerManager;
import engine.gameScreens.NodeButton;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class GraphicGameScene {
	protected Pane root;
	protected Stage stage;
	protected double screenWidth;
	protected double screenHeight;
	protected Scene scene;
	protected NodeManager myNodeManager;
	protected List<Button> buttons;
	
	
//	public GraphicGameScene(Stage stage, double screenWidth, double screenHeight, PlayerManager manager){
//		
//	}
	
	/**
	 * Return the level game scene for prime stage to display
	 * @return scene for prime stage to display
	 */
	
	public Scene getScene(){
		return scene;
	}
	public void makeNodeButton(List<NodeButton> nodeButtons) {
		clearButtons();
		for(NodeButton nodebutton : nodeButtons){
			Button myButton = new Button(nodebutton.getInfo());
			myButton.setOnAction((e)->{
				myNodeManager.moveToNode(nodebutton.myTargetNodeID);
			});
			myButton.setLayoutX(nodebutton.getLocation().x);
			myButton.setLayoutY(nodebutton.getLocation().y);
			buttons.add(myButton);
			root.getChildren().add(myButton);
		}
		
	}

	private void clearButtons() {
		root.getChildren().removeAll(buttons);
		buttons.clear();
		
	}
}
