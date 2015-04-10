package engine;

import javafx.geometry.Point2D;

public interface EditableTitleScreen {

	public void setText(String name, Point2D positions);
	
	public void setButton(String name, Point2D position);
	
	public void setImage(String name);
	
}
