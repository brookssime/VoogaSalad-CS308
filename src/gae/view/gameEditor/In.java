package gae.view.gameEditor;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * needs to be refactored so that Out and In are not duplicated code!
 * @author sunjeevdevulapalli
 *
 */
public class In {

	private static final double OUT_WIDTH = 6;
	private static final double OUT_HEIGHT = 6;
	private SimpleBooleanProperty selected;
	private Rectangle myBody;

	public In(){
		selected = new SimpleBooleanProperty(false);
		drawIn();
	}
	private void drawIn() {
		myBody = new Rectangle(OUT_WIDTH, OUT_HEIGHT);
		myBody.setFill(Color.BLACK);
		
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
	
	public Rectangle getInBody(){
		return myBody;
	}
	
	public SimpleBooleanProperty isSelected(){
		return selected;
	}
	
	public void setSelected(){
		setAndFormatSelected();
	}
	
}
