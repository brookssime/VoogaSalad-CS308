package engine.gameLogic;


import java.awt.geom.Point2D;

public class Placement {
	
	private Point2D.Double myLocation;
	private double myHeading;
	
	public Placement(){	
	}
	
	public Placement(Point2D.Double location){
		myLocation = location;
		myHeading = 0.0;
	}
	
	public Placement(Point2D.Double location, double d) {
		myLocation = location;
		myHeading = d;
	}

	public void setLocation(Point2D.Double location){
		myLocation = location;
	}
	
	public void setHeading(double heading){
		myHeading = heading;
	}
	
	public Point2D.Double getLocation(){
		return myLocation;
	}
	
	public double getHeading(){
		return myHeading;
	}
}
