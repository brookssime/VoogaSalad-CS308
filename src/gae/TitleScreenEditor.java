package gae;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
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

public class TitleScreenEditor{

	private TabPane myTabPane;
	
	public TitleScreenEditor() {
		createTabPane();
	}

	private void createTabPane() {
		myTabPane = new TabPane();
		myTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		addSettingsTab();
		addAdvancedSettingsTab();
	}
	
	private void addSettingsTab(){
		Tab titleScreen = addNewTab("Settings");
		titleScreen.setContent(addSettingsContent());
		myTabPane.getTabs().add(titleScreen);
	}

	private VBox addSettingsContent(){
		VBox group = new VBox();
		
		//For setting title name
		HBox titleSet = new HBox(5);
		titleSet.setPadding(new Insets(25));
		
		group.getChildren().add(addField("Set Title of Game: ", "Set X Position: ", "Set Y Position: "));
		group.getChildren().add(addField("Set Play Button Name: ", "Set X Position: ", "Set Y Positoin: "));
		
		HBox fileButtonBox = new HBox();
		group.getChildren().add(fileButtonBox);
		Button openFileButton = new Button("Open File");
		fileButtonBox.getChildren().add(openFileButton);
		group.getChildren().add(openFileButton);
		
		openFileButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			File imageFile = fileChooser.showOpenDialog(new Stage());
			Text imagePath = new Text(imageFile.getAbsolutePath());
			fileButtonBox.getChildren().add(imagePath);
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
	
	private void addAdvancedSettingsTab() {
		Tab titleScreen = addNewTab("Advanced Settings");
		titleScreen.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
		myTabPane.getTabs().add(titleScreen);
	}
	
	private Tab addNewTab(String name){
		Tab tab = new Tab();
		tab.setText(name);
		return tab;
	}
	
	public TabPane getPane(){
		return myTabPane;
	}

}
