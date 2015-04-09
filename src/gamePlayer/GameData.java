package gamePlayer;

import javafx.scene.image.Image;

public class GameData {
	
	protected String gameName;
	protected String gameDescription;
	protected String gameImagePath;
	
	//possibly add other things if this is a suitable class 
	
	public GameData(String gameName, String gameDescription, String gameImagePath){
		
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.gameImagePath = gameImagePath;
		
	}

	public Image getImage() {
		Image image = new Image((getClass().getResourceAsStream("../resources/sea_turtle.png")));
		//Image image = new Image(gameImagePath);
		return image;
	}

}
