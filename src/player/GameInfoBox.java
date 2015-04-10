package player;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameInfoBox extends AbstractOverlay{

	public GameInfoBox(double overlayWidth, double overlayHeight, GameData gameData) {
		super(overlayWidth, overlayHeight);
		
		//create a textArea for the description
		//GameData class, will be replaced by calls to an API from data class, exists now for testing/appearance
		//TextArea decriptionArea = new TextArea(gameData.gameDescription);
		
		//MAGIC VALUES
		Text description = new Text(10,50, gameData.gameDescription);
		description.setFont(new Font(20));
		description.setLayoutX(overlayWidth * .1);
		description.setLayoutY(overlayHeight * .3);
		
		
		
		// Set pref sizes
		
		//Create a title area for the game name
		//GameData class to be replaced by API calls
		//TextArea gameTitleArea = new TextArea(gameData.gameName);
		Text title = new Text(10,50, gameData.gameName);
		title.setFont(new Font(20));
		title.setLayoutX(overlayWidth * .1);
		title.setLayoutY(overlayHeight * .1);
		
		
		// Set pref sizes
		// imageView for the image
		ImageView gameImage = new ImageView();
		gameImage.setImage(gameData.getImage());
		gameImage.setFitWidth(overlayWidth * .15);
		gameImage.setPreserveRatio(true);
		
		//MAGIC VALUES: CHANGE THIS
		gameImage.setLayoutX(overlayWidth * .7);
		gameImage.setLayoutY(overlayHeight * .1);
		
		
		// Set locations 
		//this.getChildren().add(decriptionArea);
		//this.getChildren().add(gameTitleArea);
		this.getChildren().add(gameImage);
		this.getChildren().add(description);
		this.getChildren().add(title);
		
		
	}
	

	


	public void addPlayButton(){
		Button playButton = new Button("Play Game");
		//playButton.setLayoutX();
		this.getChildren().add(playButton);
	}

}
