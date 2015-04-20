/*
 * 
 */
package engine.testing;

import java.io.File;

import javax.swing.JFileChooser;

import engine.MethodAnnotation;
import engine.ParameterAnnotation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// TODO: Auto-generated Javadoc
/**
 * An example editable Sprite.
 *
 *@author Brooks, Patrick, Robert, and Sid.
 *
 */
public class ExampleSprite {
	
	/** The my image. */
	private ImageView myImage;
	
	/**
	 * Instantiates a new example sprite.
	 */
	public ExampleSprite(){
		myImage = new ImageView();
	}

	/**
	 * Sets the size.
	 *
	 * @param width the width
	 * @param height the height
	 */
	@MethodAnnotation(editor=true)
	public void SetSize(@ParameterAnnotation(name="Width") Double width, @ParameterAnnotation(name="Height") Double height){
		myImage.setFitWidth(width);
		myImage.setFitHeight(height);
	}
	
	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	@MethodAnnotation(editor=true)
	public void SetPosition(@ParameterAnnotation(name="X Location") Double x, @ParameterAnnotation(name="Y Location")Double y){
		myImage.setTranslateX(x);
		myImage.setTranslateY(y);
	}
	
	/**
	 * Change image.
	 */
	@MethodAnnotation(editor=true)
	public void ChangeImage() {
		selectImage();
	}
	
	/**
	 * Change image.
	 *
	 * @param img the img
	 */
	public void changeImage(Image img) {
		myImage.setImage(img);
	}
	
	/**
	 * Change image.
	 *
	 * @param file the file
	 */
	public void changeImage(File file) {
		this.changeImage(new Image(file.toURI().toString()));
	}
	
	/**
	 * Select image.
	 */
	public void selectImage(){
		JFileChooser imageChooser = new JFileChooser(System.getProperties()
				.getProperty("user.dir") + "/src/images");
		imageChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int retval = imageChooser.showOpenDialog(null);
		if (retval != JFileChooser.APPROVE_OPTION) {
			return;
		}
		changeImage(imageChooser.getSelectedFile());
		return;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		System.out.println("Object created: ExampleSprite");
		System.out.println("Size: "+myImage.getFitWidth()+" "+myImage.getFitHeight());
		System.out.println("Image File: "+myImage.getImage().toString());
		System.out.println("Position: "+myImage.getTranslateX()+" "+myImage.getTranslateY());
		return null;
	}
}
