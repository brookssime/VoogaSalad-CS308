package gae.editorComponents;

import gae.view.View;

import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonEditor extends Application{

	private static final int HBOX_SPACING = 5;
	private static final int VBOX_SPACING = 20;
	private static final double TITLE_SIZE = 30;
	private static final double SCALE_SLIDER_MIN = 1;
	private static final double SCALE_SLIDER_MAX = 2;
	private static final double SCALE_SLIDER_MAJOR_TICK = 1;
	private static final int MINOR_TICK_COUNT = 4;

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
		stackTitle.setAlignment(Pos.CENTER);
		Text title = new Text("Button Editor");
		title.setFont(new Font(TITLE_SIZE));
		stackTitle.getChildren().add(title);
		
		//Set up buttonSettings Pane
		StackPane buttonSettings = new StackPane();
		buttonSettings.setAlignment(Pos.CENTER);
		buttonSettings.setPrefSize(400, 300);
		VBox v = new VBox(VBOX_SPACING);
		buttonSettings.getChildren().add(v);
		
		//HBox with Text and Slider
		HBox sliderBox = new HBox(HBOX_SPACING);
		Slider scaleSlider = new Slider();
		scaleSlider.setMin(SCALE_SLIDER_MIN);
		scaleSlider.setMax(SCALE_SLIDER_MAX);
		scaleSlider.setMajorTickUnit(SCALE_SLIDER_MAJOR_TICK);
		scaleSlider.setMinorTickCount(MINOR_TICK_COUNT);
		scaleSlider.setShowTickLabels(true);
		scaleSlider.setShowTickMarks(true);
		scaleSlider.setPrefWidth(300);
		scaleSlider.setValue(SCALE_SLIDER_MAX);
		sliderBox.getChildren().addAll(new Text("Scale: "), scaleSlider);
		
		
		//Textfield for Text on button
		TextField buttonText = new TextField();
		buttonText.setText("Default");
		
		//add Square as visual
		Rectangle visual = new Rectangle(100, 100);
		visual.setScaleX(scaleSlider.getValue());
		visual.setScaleY(scaleSlider.getValue());
		visual.setTranslateX(130);
		visual.setFill(Color.WHITE);
		visual.setStroke(Color.BLACK);
		scaleSlider.valueProperty().addListener(e -> {
			visual.setScaleX(scaleSlider.getValue());
			visual.setScaleY(scaleSlider.getValue());
		});
		
		v.getChildren().addAll(sliderBox, buttonText, new Rectangle(), new Rectangle(), visual);
		
		//Add overall features to ButtonEditor Scene
		buttonEditor.getChildren().addAll(stackTitle, new Separator(), buttonSettings, new Separator());
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
