package gae.view.editorpane;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelperEditor {
	private String myImagePath;
	
	
	protected void paneSetUp(GridPane myPane){
		myPane.setAlignment(Pos.CENTER);
		myPane.setHgap(15);
		myPane.setVgap(25);
		myPane.setPadding(new Insets(25, 25, 25, 25));
	}
	
	protected Text setText(String myTitle, double size){
		Text title = new Text(myTitle);
		title.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 25));
		return title;
	}
	
	//Method from the Dialogue Scene Editor
	protected HBox addImageButton(String buttonText) {
		HBox fileButtonBox = new HBox(10);
		Button backgroundImageButton = new Button(buttonText);
		fileButtonBox.getChildren().add(backgroundImageButton);
		
		backgroundImageButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			File imageFile = fileChooser.showOpenDialog(new Stage());
			Text imagePath = new Text(imageFile.getAbsolutePath());
			imagePath(imagePath.toString());
			fileButtonBox.getChildren().add(imagePath);
		});
		return fileButtonBox;
	}
	
	protected void imagePath(String myPath){
		myImagePath = myPath;
	}
	
	protected String getPath(){
		return myImagePath;
	}
	
	protected Button saveButton(){	
	    //Code for the save button
        Button saveBtn = new Button("Save");
        HBox saveHB = new HBox(10);
        saveHB.setAlignment(Pos.BOTTOM_CENTER);
        saveHB.getChildren().add(saveBtn);
        
      //TODO:Event Handling of save button
        return saveBtn;
	}
}
