package gae.view.editorpane.editorComponents;

import image_drawer.Drawer;
import interfaces.ParameterAnnotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import gae.model.Receiver;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * A file selector editor type.
 * 
 * @author Negatu
 *
 */

public class FileSelector extends EditorComponent {

	private HBox myBox;
	private ImageView myDisplay;
	private Button selectButton;
	private Button drawButton;
	private File selectedFile;

	private final String defaultImagePath = "/images/addImage.png";
	private final static Double displayWidth = 100.0;
	private final static Double displayHeight = 100.0;

	public FileSelector(Receiver receiver, Method setMethod, String objectName) {
		super(receiver, setMethod, objectName);

	}

	@Override
	public void setUpEditor() {
		
		Annotation[][] Annotations = myMethod.getParameterAnnotations();
		Annotation[] annotationList = Annotations[0];
		ParameterAnnotation parameterAnnotation = (ParameterAnnotation) annotationList[0];
		String parameterName = parameterAnnotation.name();

		myBox = new HBox();
		myDisplay = new ImageView();
		setupImageView();

		this.getChildren().add(myBox);
		selectButton = new Button(parameterName);
		drawButton = new Button("Draw Image");
		myBox.getChildren().addAll(selectButton, drawButton, myDisplay);

		selectButton.setOnAction(e -> {
			File selectedFile = getSaveFile();
//			FileChooser fileChooser = new FileChooser();
//			fileChooser.setInitialDirectory(new File(System.getProperties()
//					.getProperty("user.dir") + "/src/images"));
//			ExtensionFilter filter = new ExtensionFilter(
//			        "PNG, JPG & GIF Images", "jpg", "gif", "png");
//			fileChooser.getExtensionFilters().add(filter);
//			File selectedFile = fileChooser.showOpenDialog(null);
//			
//			//fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//			//int retval = fileChooser.showOpenDialog(null);
			if (selectedFile == null) {
				System.out.println("No file chosen");
			}
			else{
				myDisplay.setImage(new Image(selectedFile.toURI().toString()));
				myReceiver.runOnObject(myObject, myMethod, selectedFile.getAbsolutePath());
			}
		});
		
		drawButton.setOnAction(e->{
			Drawer d = new Drawer();
			//TODO - add an image fetch to drawer.
		});

	}

	public  File getSaveFile(){
		FileChooser fileChooser = getNewChooser();

        fileChooser.setTitle("Save as");
        File file = fileChooser.showSaveDialog(new Stage());
        return file;
	}
	
	private  FileChooser getNewChooser(){
		FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters()
//                .add(
//                     new FileChooser.ExtensionFilter("PNG, JPG & GIF Images", "jpg", "gif", "png"));
        return fileChooser;
	}
	
	private void setupImageView() {
		Image myImage = new Image(getClass().getResourceAsStream(
				defaultImagePath));
		myDisplay.setImage(myImage);
		System.out.println(displayWidth);
		myDisplay.setFitWidth(displayWidth);
		myDisplay.setFitHeight(displayHeight);
	}
}
