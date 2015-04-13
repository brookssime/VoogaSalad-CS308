/*
 * 
 */
package engine;

import interfaces.Authorable;

import java.awt.Point;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Port.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Port implements Authorable{

	/** The my name. */
	private String myName;
	
	/** The my image string. */
	private String myImageString;
	
	/** The my port id. */
	private Integer myPortID;
	
	/** The my location. */
	private Point myLocation;
	
	/**
	 * Instantiates a new port.
	 */
	public Port(){
		
	}
	
	/**
	 * Instantiates a new port.
	 *
	 * @param imageString the image string
	 * @param portID the port id
	 * @param location the location
	 */
	public Port(String imageString, Integer portID, Point location){
		myImageString = imageString;
		myPortID = portID;
		myLocation = location;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}
