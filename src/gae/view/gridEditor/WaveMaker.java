package gae.view.gridEditor;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Helper to make the wave queue
 * @author ReyinaSenatus
 *
 */

public class WaveMaker {
	Stage waveStage;
	
	protected void setUp(){
		waveStage = new Stage();
		Group waveGroup = new Group();
		Scene waveScene = new Scene(waveGroup, 400, 400);
		
		waveStage.setScene(waveScene);
		waveStage.show();
	}
}
