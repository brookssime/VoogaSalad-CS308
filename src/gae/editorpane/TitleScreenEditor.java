package gae.editorpane;

import gae.BundleGrabber;
import gae.GAEPane;
import gae.menupane.MenuAdder;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TitleScreenEditor extends GAEPane{
	
	private final ResourceBundle myConfigs;

	public TitleScreenEditor(MenuAdder adder) {
		super(TitleScreenEditor.class.getSimpleName(), adder);
		myConfigs = BundleGrabber.grabBundle("configs", TitleScreenEditor.class.getSimpleName());
		myRoot.getChildren().add(setRootProperties());
		
	}
	

	private VBox setRootProperties(){
		VBox group = new VBox(10);
		
		//For setting title name
		HBox titleSet = new HBox(5);
		titleSet.setPadding(new Insets(25));
		
		group.getChildren().add(addField(myConfigs.getString("set_title"), 
				myConfigs.getString("set_x"), myConfigs.getString("set_y")));
		group.getChildren().add(addField(myConfigs.getString("set_play"), 
				myConfigs.getString("set_x"), myConfigs.getString("set_y")));
		
		HBox fileButtonBox = new HBox(10);
		group.getChildren().add(fileButtonBox);
		Button openFileButton = new Button(myConfigs.getString("open_file"));
		fileButtonBox.getChildren().add(openFileButton);
		group.getChildren().add(openFileButton);
		
		openFileButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle(myConfigs.getString("open_resource"));
			File imageFile = fileChooser.showOpenDialog(new Stage());
			Text imagePath = new Text(imageFile.getAbsolutePath());
			fileButtonBox.getChildren().add(imagePath);
		});
		
		Button applyButton = new Button(myConfigs.getString("update"));
		group.getChildren().add(applyButton);
		applyButton.setOnAction(e -> {
			//TODO: backend call
		});
		return group;
	}
	
	private HBox addField(String item1, String item2, String item3){
		HBox hBox = new HBox(5);
		hBox.setPadding(new Insets(25));
		hBox.getChildren().add(addTextField(item1));
		hBox.getChildren().add(addTextField(item2));
		hBox.getChildren().add(addTextField(item3));
		return hBox;
	}
	
	private HBox addTextField(String name){
		HBox hBox = new HBox(5);
		Text text = new Text(name);
		TextField textField = new TextField();
		hBox.getChildren().add(text);
		hBox.getChildren().add(textField);
		return hBox;
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
