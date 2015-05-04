package gae.view.gameeditor;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.shape.Rectangle;

public abstract class Connector {

	private static final double OUT_WIDTH = 6;
	private static final double OUT_HEIGHT = 6;
	private SimpleBooleanProperty selected;
	protected Rectangle myBody;
	
	public Connector(){
		selected = new SimpleBooleanProperty(false);
		draw();
	}
	
	private void draw() {
		myBody = new Rectangle(OUT_WIDTH, OUT_HEIGHT);
		myBody.setPickOnBounds(false);
		drawColor();
		myBody.setOnMouseClicked(e -> {
			setAndFormatSelected();
		});
		
	}

	private void setAndFormatSelected() {
		ColorAdjust adjust = new ColorAdjust();
		selected.set(!selected.getValue());
		if(!selected.getValue()){
			adjust.setContrast(1.0);
			myBody.setEffect(adjust);
		}
		else{
			adjust.setContrast(-1.0);
			myBody.setEffect(adjust);
		}
	}
	
	public Rectangle getBody(){
		return myBody;
	}
	
	public SimpleBooleanProperty isSelected(){
		return selected;
	}
	
	public void setSelected(){
		setAndFormatSelected();
	}
	
	/**
	 * Sets color and specific characteristics of node
	 */
	protected abstract void drawColor();
}
