package gae.view.gameEditor;

import javafx.scene.paint.Color;

/**
 * 
 * Maybe add implementation so these guys set where they are? i.e their position?
 * @author sunjeevdevulapalli
 *
 */
public class In extends Connector{
	
	public In(){
		super();
	}

	@Override
	protected void drawColor() {
		myBody.setFill(Color.RED);
	}
	
	
}
