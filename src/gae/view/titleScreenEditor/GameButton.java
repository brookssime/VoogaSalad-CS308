package gae.view.titleScreenEditor;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameButton extends Rectangle{
	
	private double myXLoc;
	private double myYLoc;
	private double myScale;
	private String myText;
	private Label myBody;
	
	
	public GameButton(){
		myBody = new Label("Default");
		myBody.setStyle("-fx-background-color: white;  -fx-padding: 30; -fx-border-color: black");
	}
	
	public GameButton(double x, double y, double scale, String text){
		myXLoc = x;
		myYLoc = y;
		myScale = scale;
		myText = text;
		myBody = new Label(text);
		myBody.setStyle("-fx-background-color: white;  -fx-padding: 30; -fx-border-color: black");
		myBody.setScaleX(myScale);
		myBody.setScaleY(myScale);
		
	}
	
	public double getMyXLoc() {
		return myXLoc;
	}


	public void setMyXLoc(double myXLoc) {
		this.myXLoc = myXLoc;
	}


	public double getMyYLoc() {
		return myYLoc;
	}


	public void setMyYLoc(double myYLoc) {
		this.myYLoc = myYLoc;
	}


	public double getMyScale() {
		return myScale;
	}


	public void setMyScale(double myScale) {
		this.myScale = myScale;
	}


	public String getMyText() {
		return myText;
	}


	public void setMyText(String myText) {
		this.myText = myText;
	}

	public Label getBody(){
		return myBody;
	}
}
