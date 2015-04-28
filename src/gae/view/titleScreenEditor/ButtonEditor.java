package gae.view.titleScreenEditor;

import java.awt.Point;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import engine.gameScreens.NodeButton;

public class ButtonEditor {

	private static final String BUTTON_CSS = "-fx-background-color: white;  "
			+ "-fx-padding: 30; -fx-border-color: black; -fx-font-size: 30px";
	private static final int HBOX_SPACING = 5;
	private static final int VBOX_SPACING = 20;
	private static final double TITLE_SIZE = 30;
	private static final double SCALE_SLIDER_MIN = 1;
	private static final double SCALE_SLIDER_MAX = 2;
	private static final double SCALE_SLIDER_MAJOR_TICK = 1;
	private static final int MINOR_TICK_COUNT = 4;
	private NodeButton myButton;
	private IButton myEditor;

	public ButtonEditor(IButton editor) {
		myButton = new NodeButton();
		myEditor = editor;
	}

	//if we are editing an existing button
	public ButtonEditor(IButton editor, NodeButton button){
		myEditor = editor;
		myButton = button;
		//GameButton has all the information, should also have have new information
	}

	public void setUpEditor() {
		button();
	}

	private void button() {
		Stage stage = new Stage();
		stage.setHeight(700);
		stage.setWidth(400);
		stage.setScene(new Scene(addButtonEditor(stage)));
		stage.show();
	}

	private Parent addButtonEditor(Stage stage) {
		VBox buttonEditor = new VBox(VBOX_SPACING);
		buttonEditor.setPadding(new Insets(VBOX_SPACING));

		// Text Label At top
		StackPane stackTitle = new StackPane();
		stackTitle.setAlignment(Pos.CENTER);
		Text title = new Text("Button Editor");
		title.setFont(new Font(TITLE_SIZE));
		stackTitle.getChildren().add(title);

		// Set up buttonSettings Pane
		StackPane buttonSettings = new StackPane();
		buttonSettings.setAlignment(Pos.CENTER);
		buttonSettings.setPrefSize(400, 300);
		VBox v = new VBox(VBOX_SPACING);
		buttonSettings.getChildren().add(v);

		// HBox with Text and Slider
		HBox sliderBox = new HBox(HBOX_SPACING);
		Slider scaleSlider = new Slider();
		scaleSlider.setMin(SCALE_SLIDER_MIN);
		scaleSlider.setMax(SCALE_SLIDER_MAX);
		scaleSlider.setMajorTickUnit(SCALE_SLIDER_MAJOR_TICK);
		scaleSlider.setMinorTickCount(MINOR_TICK_COUNT);
		scaleSlider.setShowTickLabels(true);
		scaleSlider.setShowTickMarks(true);
		scaleSlider.setPrefWidth(300);
		scaleSlider.setValue(myButton.getScale());
		sliderBox.getChildren().addAll(new Text("Scale: "), scaleSlider);

		// Textfield for Text on button
		TextField buttonText = new TextField();
		buttonText.setText(myButton.getInfo());

		// add Square as visual with text
		Label visual = new Label(buttonText.getText());
		visual.setScaleX(scaleSlider.getValue());
		visual.setScaleY(scaleSlider.getValue());
		visual.setStyle(BUTTON_CSS);

		scaleSlider.valueProperty().addListener(e -> {
			visual.setScaleX(scaleSlider.getValue());
			visual.setScaleY(scaleSlider.getValue());
		});

		buttonText.textProperty().addListener(e -> {
			visual.setText(buttonText.getText());
		});
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(sliderBox, buttonText, new Rectangle(),
				new Rectangle(), visual);

		// Location Specifier
		StackPane location = new StackPane();
		location.setPrefSize(400, 100);
		location.setAlignment(Pos.CENTER);
		VBox pos = new VBox(VBOX_SPACING);
		TextField xPos = new TextField();
		xPos.setPromptText("X Location");
		TextField yPos = new TextField();
		yPos.setPromptText("Y Location");
		pos.getChildren().addAll(xPos, yPos);
		location.getChildren().addAll(pos);

		// Return button
		HBox returnButtons = new HBox(HBOX_SPACING);
		Button accept = new Button("Accept");
		accept.setOnAction(e -> {
			//THIS ASSUMES STUFF WAS TYPED
			//TODO: FIX THE ABOVE
			Point p = new Point();
			p.setLocation(Double.parseDouble(xPos.getText()), 
					Double.parseDouble(yPos.getText()));
			myButton.setLocation(p);
			
			myButton.setScale(scaleSlider.getValue());
			myButton.setInfo(buttonText.getText());
			myEditor.addButton(myButton);
			stage.close();
		});

		// Cancel button
		Button quit = new Button("Quit");
		quit.setOnAction(e -> {
			stage.close();
			
		});

		returnButtons.getChildren().addAll(accept, quit);

		// Add overall features to ButtonEditor Scene
		buttonEditor.getChildren().addAll(stackTitle, new Separator(),
				buttonSettings, new Separator(), location, returnButtons);
		return buttonEditor;
	}

}

