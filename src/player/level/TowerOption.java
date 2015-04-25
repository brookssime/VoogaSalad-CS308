package player.level;

import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;

public class TowerOption {
	private Pane myPane;
	private Option sell;
	Circle circle;
	boolean isShown;
	public TowerOption(){
		myPane = new Pane();
		sell = new Option();
		 circle= new Circle(100,Color.web("green", 0.2));
		 sell.setText("$");
		myPane.getChildren().add(circle);
		myPane.getChildren().add(sell.getButton());
		myPane.setVisible(false);
		isShown = false;
		myPane.setOnMouseClicked((MouseEvent e) ->{
			if(myPane.visibleProperty().equals(true)){
				myPane.setVisible(false);
			} else{
				myPane.setVisible(true);
			}
		});
		//circle.centerXProperty().bind(myPane.layoutXProperty());
		//circle.centerYProperty().bind(myPane.layoutYProperty());
		//circle.setCenterX();
		
		
	}
	public void setPos(double x, double y){
		//myPane.setLayoutX(x);
		//myPane.setLayoutY(y);
		sell.setPos(x, y);
		System.out.println(x);
		System.out.println(y);
	}
	public void show() {
		myPane.setVisible(true);
		isShown = true;
	}
	public void hide() {
		myPane.setVisible(false);
		isShown = false;
	}
	
	public boolean getShown(){
		return isShown;
	}
	public Circle getCircle(){
		return circle;
	}
	public Pane getPane(){
		return myPane;
	}
	public void sell() {
	}
	public void upGrade(int value) {
	}
	public void addOption() {
	}
	
}
