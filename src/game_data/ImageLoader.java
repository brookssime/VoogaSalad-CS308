package game_data;

import javafx.scene.image.Image;

public class ImageLoader {
	public Image loadImageFile(String myImagePath){
		return new Image(getClass().getResourceAsStream(myImagePath));
		
	}
	
	public Image loadImageFile(String myImagePath, double imagesize){
		return new Image(getClass().getResourceAsStream(myImagePath),imagesize,imagesize,false,false);
	}
}
