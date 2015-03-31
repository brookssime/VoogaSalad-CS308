package gamePlayer;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class GameInfoBox extends AbstractOverlay{

	public GameInfoBox(double overlayWidth, double overlayHeight, GameData gameData) {
		super(overlayWidth, overlayHeight);
		
		//create a textArea for the description
		//GameData class, will be replaced by calls to an API from data class, exists now for testing/appearance
		TextArea decriptionArea = new TextArea(gameData.gameDescription);
		// Set pref sizees
		
		//Create a title area for the game name
		//GameData class to be replaced by API calls
		TextArea gameTitleArea = new TextArea(gameData.gameName);
		
		// imageView for the image
		ImageView gameImage = new ImageView();
		gameImage.setImage(gameData.getImage());
		
	}
	

	


	public void addPlayButton(){
		Button playButton = new Button("Play Game");
		this.getChildren().add(playButton);
	}

}
