package gae.editorComponents;

import interfaces.ParameterAnnotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.swing.JFileChooser;

import gae.model.Receiver;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

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
	private File selectedFile;

	private final String defaultImagePath = "/images/addImage.png";
	private final static Double displayWidth = 100.0;
	private final static Double displayHeight = 100.0;

	public FileSelector(Receiver receiver, Method setMethod, Method getMethod, String objectName) {
		super(receiver, setMethod, getMethod, objectName);

	}

	@Override
	public void setUpEditor() {
		// TODO type of file (with error correction and filetering needs to be
		// added
		// TODO ?multiple select button in case multiple select files

		Annotation[][] Annotations = mySetMethod.getParameterAnnotations();
		Annotation[] annotationList = Annotations[0];
		ParameterAnnotation parameterAnnotation = (ParameterAnnotation) annotationList[0];
		String parameterName = parameterAnnotation.name();

		myBox = new HBox();
		myDisplay = new ImageView();
		setupImageView();

		this.getChildren().add(myBox);
		selectButton = new Button(parameterName);
		myBox.getChildren().addAll(selectButton, myDisplay);

		selectButton.setOnAction(e -> {
			JFileChooser fileChooser = new JFileChooser(System.getProperties()
					.getProperty("user.dir") + "/src/images");
			fileChooser
					.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int retval = fileChooser.showOpenDialog(null);
			if (retval != JFileChooser.APPROVE_OPTION) {
				return;
			}
			selectedFile = fileChooser.getSelectedFile();
			myDisplay.setImage(new Image(selectedFile.toURI().toString()));
			myReceiver.runOnObject(myObject, mySetMethod, selectedFile);
		});

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
