package engine;

import java.awt.geom.Point2D;

public class Placement {
	
	private Point2D myLocation;
	private double myHeading;
	
	public Placement(){	
	}
	
	public void setLocation(Point2D location){
		myLocation = location;
	}
	
	public void setHeading(double heading){
		myHeading = heading;
	}
	
	public Point2D getLocation(){
		return myLocation;
	}
	
	public double getHeading(){
		return myHeading;
	}
}