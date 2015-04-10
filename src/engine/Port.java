package engine;

import interfaces.Authorable;

import java.awt.Point;
import java.util.List;

public class Port implements Authorable{

	private String myName;
	private String myImageString;
	private Integer myPortID;
	private Point myLocation;
	
	public Port(){
		
	}
	
	public Port(String imageString, Integer portID, Point location){
		myImageString = imageString;
		myPortID = portID;
		myLocation = location;
	}

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}
