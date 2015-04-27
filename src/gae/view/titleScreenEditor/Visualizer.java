package gae.view.titleScreenEditor;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


/**
 * This class will take in information about nodes (location, text etc...) and display them in a pane that
 * can be scaled
 * @author sunjeevdevulapalli
 *
 */
public class Visualizer {
	
	private static final double SCREENWIDTH = 1000;
	private static final double SCREENHEIGHT = 800;
	private Group myGroup;
	private Pane myRoot;
	
	public Visualizer(){
		myGroup = new Group();
		myRoot = new Pane();
		myRoot.getChildren().add(myGroup);
		initScreen();
	}
	
	private void initScreen() {
		myRoot.setPrefSize(SCREENWIDTH, SCREENHEIGHT);
	}

	public void setButton(double xPos, double yPos, String text, double scale, String css){
		Label button = new Label(text);
		button.setTranslateX(xPos);
		button.setTranslateY(yPos);
		button.setScaleX(scale);
		button.setScaleY(scale);
		button.setStyle(css);
		myGroup.getChildren().add(button);
	}
	
	public void setScale(double scale){
		myGroup.setScaleX(myGroup.getScaleX() * scale);
		myGroup.setScaleY(myGroup.getScaleY() * scale);
	}
	
	public void setImage(String filepath){
		
	}
	
	public Pane getPane(){
		return myRoot;
	}
	
	public void setTextProperties(DoubleProperty xPos, DoubleProperty yPos, StringProperty text, 
			StringProperty css){
		Label title = new Label();
		title.textProperty().bind(text);
		title.translateXProperty().bind(xPos);
		title.translateYProperty().bind(yPos);
		//check for bad stuff...
//		title.styleProperty().bind(text);
		
	}
}
