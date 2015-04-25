package engine.gameLogic;

import java.awt.Point;

public class Placement {
	
	private Point myLocation;
	private double myHeading;
	
	public Placement(){	
	}
	
	public Placement(Point location){
		myLocation = location;
		myHeading = 0.0;
	}
	
	public Placement(Point location, double d) {
		myLocation = location;
		myHeading = d;
	}

	public void setLocation(Point location){
		myLocation = location;
	}
	
	public void setHeading(double heading){
		myHeading = heading;
	}
	
	public Point getLocation(){
		return myLocation;
	}
	
	public double getHeading(){
		return myHeading;
	}
}
