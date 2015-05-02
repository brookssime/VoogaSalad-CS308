package image_drawer;

import java.awt.image.RenderedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

//This entire file is part of my masterpiece.
//Negatu Asmamaw.

public class SaveDialog {

	
	public SaveDialog(DrawingCanvas myCanvas){
		JFrame parentFrame = new JFrame();
		File myFile = new File("newImage.png");
		JFileChooser fileChooser = new JFileChooser(System.getProperties()
				.getProperty("user.dir") + "/src/");
		fileChooser.setDialogTitle("Rename and save your Image");
		fileChooser.setSelectedFile(myFile);
		int userSelection = fileChooser.showSaveDialog(parentFrame);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			if (fileToSave != null) {
				myFile = fileToSave;
				
				try {
					WritableImage writableImage = new WritableImage(
							((int) myCanvas.getWidth()),
							((int) myCanvas.getHeight()));
					myCanvas.snapshot(null, writableImage);
					RenderedImage renderedImage = SwingFXUtils.fromFXImage(
							writableImage, null);
					ImageIO.write(renderedImage, "png", fileToSave);
				} catch (Exception e) {
					System.out.println("Failed to save your image: "
							+ e.toString());
				}
				
			}

		}
	}
	public void start(){
		
	}

}
