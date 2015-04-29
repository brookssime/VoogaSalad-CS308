package gae.view.titleScreenEditor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import engine.gameScreens.NodeButton;


/**
 * This class will take in information about nodes (location, text etc...) and display them in a pane that
 * can be scaled
 * @author sunjeevdevulapalli
 *
 */
public class Visualizer {
	
	private static final double SCREENWIDTH = 1000;
	private static final double SCREENHEIGHT = 800;
	private static final String CSS = "-fx-border-color:black;";
	private Group myGroup;
	private Pane myRoot;
	private List<NodeButton> myButtons;
	
	public Visualizer(){
		myButtons = new ArrayList<>();
		myGroup = new Group();
		myRoot = new Pane();
		myRoot.setStyle(CSS);
		myRoot.getChildren().add(myGroup);
		initScreen();
	}
	
	private void initScreen() {
		myRoot.setPrefSize(SCREENWIDTH, SCREENHEIGHT);
	}

	
	public void setButtonProperties(StringProperty text, StringProperty  css, DoubleProperty scale, 
			StringProperty xPos, StringProperty yPos){
		Label button = new Label();
		button.textProperty().bind(text);
		button.styleProperty().bind(css);
		button.scaleXProperty().bind(scale);
		button.scaleYProperty().bind(scale);
		DoubleProperty x = new SimpleDoubleProperty();
		DoubleProperty y = new SimpleDoubleProperty();
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(xPos, x, converter);
		Bindings.bindBidirectional(yPos, y, converter);
		button.translateXProperty().bind(x);
		button.translateYProperty().bind(y);
		
		myRoot.getChildren().add(button);
	}
	
	public void setScale(double scale){
		myGroup.setScaleX(myGroup.getScaleX() * scale);
		myGroup.setScaleY(myGroup.getScaleY() * scale);
		myRoot.setScaleX(myGroup.getScaleX() * scale);
		myRoot.setScaleY(myGroup.getScaleY() * scale);
	}
	
	public void setImage(String filepath){
		
	}
	
	public Pane getPane(){
		return myRoot;
	}
	
	public void setTextProperties(StringProperty xPos, StringProperty yPos, StringProperty text, 
			StringProperty css){
		Label title = new Label();
		DoubleProperty x = new SimpleDoubleProperty();
		DoubleProperty y = new SimpleDoubleProperty();
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(xPos, x, converter);
		Bindings.bindBidirectional(yPos, y, converter);
		myRoot.getChildren().add(title);
		title.textProperty().bind(text);
		title.translateXProperty().bind(x);
		title.translateYProperty().bind(y);
		//check for bad stuff...
		title.styleProperty().bind(css);
		
	}
}
