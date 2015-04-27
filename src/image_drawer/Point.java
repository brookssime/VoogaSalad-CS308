package image_drawer;

/**
 * 
 * @author Negatu
 *	
 *	This class represents a point on the drawing canvas. 
 */
public class Point {
	private double xPos;
	private double yPos;
	
	public Point(double x, double y){
		xPos = x;
		yPos = y;
	}
	
	public void setPoint(double x, double y){
		xPos = x;
		yPos = y;
	}
	
	public double getX(){
		return xPos;
	}
	
	public double getY(){
		return yPos;
	}
}
