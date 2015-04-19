/*
 * 
 */
package engine;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.JFileChooser;

// TODO: Auto-generated Javadoc
/**
 * An example editable Sprite.
 * 
 * @author Negatu
 * 
 * 
 */
public class ExampleEnemy {
	
	/** The my image. */
	private ImageView myImage;
	
	/** The my health capacity. */
	private Double myHealthCapacity = 0.0;
	
	/**
	 * Instantiates a new example enemy.
	 */
	public ExampleEnemy(){
		myImage = new ImageView();
		
	}

	/**
	 * Sets the size.
	 *
	 * @param width the width
	 * @param height the height
	 */
	@MethodAnnoation(editor=true, name="Size", type="textfield", gsType = "setter")
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
	@MethodAnnoation(editor=true, name = "Position", type = "textfield", gsType = "setter")
	public void SetPosition(@ParameterAnnotation(name="X Location") Double x, @ParameterAnnotation(name="Y Location")Double y){
		myImage.setTranslateX(x);
		myImage.setTranslateY(y);
	}
	
	/**
	 * Sets the health capacity.
	 *
	 * @param health the health
	 */
	@MethodAnnoation(editor=true, name = "Health", type = "textfield", gsType = "setter")
	public void SetHealthCapacity(@ParameterAnnotation(name="Health Capacity") Double health){
		this.setMyHealthCapacity(health);
	}
	
	/**
	 * Change image.
	 */
	@MethodAnnoation(editor=true, name = "Image File", type = "fileselect", gsType = "setter")
	public void ChangeImage(@ParameterAnnotation(name="Select Image") File file) {
		this.changeImage(new Image(file.toURI().toString()));
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
	
	private void changeImage(File selectedFile) {
		// TODO Auto-generated method stub
		this.changeImage(new Image(selectedFile.toURI().toString()));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		System.out.println("Object created: ExampleSprite");
		System.out.println("Image File: "+myImage.getImage().toString());
		System.out.println("Size: "+myImage.getFitWidth()+" "+myImage.getFitHeight());
		System.out.println("Position: "+myImage.getTranslateX()+" "+myImage.getTranslateY());
		System.out.println("Health Capacity: "+ myHealthCapacity);
		return null;
	}

	/**
	 * Gets the my health capacity.
	 *
	 * @return the my health capacity
	 */
	public Double getMyHealthCapacity() {
		return myHealthCapacity;
	}

	/**
	 * Sets the my health capacity.
	 *
	 * @param myHealthCapacity the new my health capacity
	 */
	public void setMyHealthCapacity(Double myHealthCapacity) {
		this.myHealthCapacity = myHealthCapacity;
	}


}
