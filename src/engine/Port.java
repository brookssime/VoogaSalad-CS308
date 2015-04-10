package GameEngine;

import java.awt.Point;

public class Port {

	private String myImageString;
	private Integer myPortID;
	private Point myLocation;
	
	public Port(String imageString, Integer portID, Point location){
		myImageString = imageString;
		myPortID = portID;
		myLocation = location;
	}
}
