package gae.view.editorpane;

import java.io.File;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;

/**
 * 
 * @author Sunjeev Devulapalli
 * This is the temporary editor for editing the base. It allows the user to set properties such as
 * the name, health, location, radius, and image. The Name is the name of the specific game object. The
 * Health is the health of a base. The location is wher eit is placed on the map. The radius is where 
 * enemies can attack it from. And the image is any image the player chooses.
 * 
 * To add new content, modify the setContent() method.
 */
public class BaseEditor extends GAEPane{

	public BaseEditor(MenuAdder adder) {
		super(BaseEditor.class.getSimpleName(), adder);
		myRoot.getChildren().add(setContent());
	}

	//need a name
	//a Health
	//a Image
	//Location
	//radius
	private VBox setContent() {
		VBox group = new VBox(5);
		group.setPadding(new Insets(25));
		group.getChildren().add(addTextField("Name: "));
		group.getChildren().add(addTextField("Health: "));
		group.getChildren().add(addTextField("Location (X Y)"));
		group.getChildren().add(addTextField("Radius: "));
		group.getChildren().add(addImageButton("Set Image"));
		
		Button update = new Button("Update");
		group.getChildren().add(update);
		update.setOnAction(e -> {
			System.out.println("backend");
		});
		return group;
	}
	
	private HBox addTextField(String name){
		HBox hBox = new HBox(5);
		Text text = new Text(name);
		TextField textField = new TextField();
		hBox.getChildren().add(text);
		hBox.getChildren().add(textField);
		return hBox;
	}

	private HBox addImageButton(String buttonText) {
		HBox fileButtonBox = new HBox(10);
		Button backgroundImageButton = new Button(buttonText);
		fileButtonBox.getChildren().add(backgroundImageButton);
		
		backgroundImageButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			File imageFile = fileChooser.showOpenDialog(new Stage());
			Text imagePath = new Text(imageFile.getAbsolutePath());
			fileButtonBox.getChildren().add(imagePath);
		});
		return fileButtonBox;
	}
	
	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
