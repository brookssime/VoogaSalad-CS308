package util;

import java.io.File;

import javafx.scene.image.Image;

public class ImageUtil {
	public static Image getImage(String imagefile) {
		Image image = new Image(imagefile);
		//Image image = new Image(gameImagePath);
		return image;
	}
	public static String getStr(File f){
		return f.getAbsolutePath();
	}
}
