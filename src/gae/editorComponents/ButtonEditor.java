package gae.editorComponents;

import gae.view.View;

import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonEditor extends Application{

	private static final int VBOX_SPACING = 20;
	private static final double TITLE_SIZE = 30;

	public ButtonEditor(/*Method method, Object object*/) {
		//super(method, object);
	}

	//@Override
	public Parent setUpEditor() {
		VBox v = new VBox();
		v.getChildren().add(button());
		return v;
	}

	private Parent button() {
		Button buttonEditor = new Button("Button Editor");
		buttonEditor.setOnAction(e -> {
			Stage stage = new Stage();
			stage.setHeight(700);
			stage.setWidth(400);
			stage.setScene(new Scene(addButtonEditor()));
			stage.show();
		});
		return buttonEditor;
	}

	private Parent addButtonEditor() {
		VBox buttonEditor = new VBox(VBOX_SPACING);
		buttonEditor.setPadding(new Insets(VBOX_SPACING));
		
		//Text Label At top
		StackPane stackTitle = new StackPane();
		Text title = new Text("Button Editor");
		title.setFont(new Font(TITLE_SIZE));
		stackTitle.getChildren().add(title);
		stackTitle.setAlignment(Pos.CENTER);
		
		buttonEditor.getChildren().addAll(stackTitle);
		return buttonEditor;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		ButtonEditor b = new ButtonEditor();
		stage = new Stage();
		stage.setScene(new Scene(b.setUpEditor()));
		stage.show();
		
	}

}
