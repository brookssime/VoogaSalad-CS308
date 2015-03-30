package GAE;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View {
	
	private Stage myStage;
	private Scene myScene;
	private Group myGroup;
	
	public View(Stage stage) {
		myGroup = new Group();
		myScene = new Scene(myGroup);

		myStage = stage;
		myStage.setTitle("Testing GAE elements");
		myStage.setScene(myScene);
		
		addTestElement();
	
	}

	public void showView() {
		myStage.show();
	}
	
	private void addTestElement(){
		ExampleEditor exampleEditor = new ExampleEditor("GameEngine.ExampleSprite");
		myGroup.getChildren().add(exampleEditor);
	}

}
