package player;

import java.util.List;

import engine.gameScreens.NodeButton;
import javafx.scene.Scene;

public interface GraphicGameScene {
	public Scene getScene();
	public void makeNodeButton(List<NodeButton> nodeButton);
}
