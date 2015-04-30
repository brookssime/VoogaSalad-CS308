package game_data;

import javafx.scene.image.Image;

public class ImageLoader {
	private static double imagesize = 80;
	public Image loadImageFile(String myImagePath){
		
		
		return new Image(getClass().getResourceAsStream(myImagePath), imagesize, imagesize, false,false);
		
	}
	
	public Image loadImageFile(String myImagePath, double imagesize){
		return new Image(getClass().getResourceAsStream(myImagePath),imagesize,imagesize,false,false);
	}
}
