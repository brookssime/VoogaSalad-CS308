package gae.editorpane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class DelayFieldEditor extends HBox{
	
	private Button add;
	private TextField delay;
	
	public DelayFieldEditor(){
		add = new Button("Add delay");
		add.setOnAction(e->{
			addDelay();
		});
		delay = new TextField();
		getChildren().addAll(add, delay);
	}

	private void addDelay(){
		Label l = new Label(delay.getText());
		getChildren().add(l);
	}
}
