package image_drawer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * @author Negatu
 *	
 *	This class represents the drawing canvas - drawing area. 
 */

//This entire file is part of my masterpiece.
//Negatu Asmamaw.

public class DrawingCanvas extends Canvas {
	
	private Point mousePosition;
	private GraphicsContext gc;

	public DrawingCanvas(double width, double height) {
		
		this.setWidth(width);
		this.setHeight(height);
		
		gc = this.getGraphicsContext2D();
		
		
		/**
		 * a mouse position on the canvas is recorded when it is clicked. 
		 */
		this.setOnMousePressed(e->{
			mousePosition = new Point(e.getX(), e.getY());
		});
		
		/**
		 * traces the mouse as it moves around inside the drawing canvas. 
		 */
		this.setOnMouseDragged(e->{
			gc.strokeLine(mousePosition.getX(), mousePosition.getY(), e.getX(), e.getY());
			mousePosition = new Point(e.getX(), e.getY());
		});

	}
	
	public void setBG(Color c){
		gc.setFill(c);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
}
