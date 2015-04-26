package gae.view.gameEditor;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Out {
	
	private static final double OUT_WIDTH = 6;
	private static final double OUT_HEIGHT = 6;
	private SimpleBooleanProperty selected;
	private Rectangle myBody;
	
	public Out(){
		selected = new SimpleBooleanProperty(false);
		drawOut();
	}

	private void drawOut() {
		myBody = new Rectangle(OUT_WIDTH, OUT_HEIGHT);
		myBody.setPickOnBounds(false);
		myBody.setFill(Color.RED);
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
	
	public Rectangle getOutBody(){
		return myBody;
	}
	
	public SimpleBooleanProperty isSelected(){
		return selected;
	}
	
	public void setSelected(){
		setAndFormatSelected();
	}

}
