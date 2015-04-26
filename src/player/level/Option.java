package player.level;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Option {
	Button roundButton;
	public Option(){
		roundButton = new Button();
		roundButton.setShape(new Circle(30));
		roundButton.setMaxSize(60, 60);
		roundButton.setPrefSize(40, 40);
       
	}
	
	public void setFunc(EventHandler<? super MouseEvent> value){
		roundButton.setOnMouseClicked(value);
	}
	public Button getButton(){
		return roundButton;
	}
	public void setText(String name){
		roundButton.setText(name);
	}
	public void setPos(double x, double y){
		
		roundButton.setLayoutX(roundButton.getParent().getLayoutX()+20);
		roundButton.setLayoutY(roundButton.getParent().getLayoutY()-50);
	}
}
