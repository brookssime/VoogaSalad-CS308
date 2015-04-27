package engine.sprites;

import java.awt.Point;

import engine.gameLogic.Placement;

public class Port extends Sprite{

	Point myLocation;
	
	public Port(){
		
	}
	
	public void setLocation(Point location){
		myLocation = location;
	}
	
	public Point getLocation(){
		return myLocation;
	}

	@Override
	public Placement move() {
		return new Placement(myLocation); // REVIEW: Make sure this doesn't ever need to return an orientation...currently set to null
	}

	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
	}
}