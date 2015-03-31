package gamePlayer;

import java.util.ResourceBundle;

import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public abstract class GameInfoBox extends AbstractOverlay{

	public GameInfoBox(double overlayWidth, double overlayHeight,
			ResourceBundle rb, GameData gameData) {
		super(overlayWidth, overlayHeight, rb);
		// TODO Auto-generated constructor stub
		
		//create a textArea for the description
		//GameData class, will be replaced by calls to an API from data class, exists now for testing/appearance
		TextArea decriptionArea = new TextArea(gameData.gameDescription);
		// Set pref sizees
		
		//Create a title area for the game name
		//GameData class to be replaced by API calls
		TextArea gameTitleArea = new TextArea(gameData.gameName);
		
		// imageView for the image
		ImageView gameImage = new ImageView();
		gameImage.getImage(gameData.getImage());
	}

	@Override
	void createGameButtons(ResourceBundle rb) {
		// TODO Auto-generated method stub
	}

}
