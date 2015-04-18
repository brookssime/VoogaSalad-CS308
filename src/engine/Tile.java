/*
 * 
 */
package engine;

import interfaces.Authorable;

import java.awt.Point;
import java.awt.Shape;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Tile.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Tile implements Authorable{
	
	/** The my name. */
	private String myName;
	
	/** The my image path. */
	private String myImagePath;
	
	/** The my shape. */
	private Shape myShape;
	
	/** The my access id. */
	private int myAccessID;
	private int myX;
	private int myY;
	private Point myLocation = new Point();
	
<<<<<<< HEAD
	/**
	 * Instantiates a new tile.
	 *
	 * @param imagePath the image path
	 */
	public Tile(String imagePath){
		
	}
	
	/**
	 * Instantiates a new tile.
	 */
	public Tile(){
=======
	public Tile(int x, int y, String imagePath){
		myLocation.x = x;
		myLocation.y = y;
		myImagePath = imagePath;
	}
	
	public Tile(int x, int y){
>>>>>>> c518b688f0ceba76f3e4ca2866b8d587cd2934bf
		
		myLocation.x = x;
		myLocation.y = y;
		myAccessID = 0; // DEFAULTED FOR THIS CONSTRUCTOR
	}
	
	public Point getLocation(){
		return myLocation;
	}
	
	public int getAccessID(){
		return myAccessID;
	}
	
	public void setID(int x){
		myAccessID = x;
	}
	
	public int getID(){
		return myAccessID;
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

	public int getX() {
		return myLocation.x;
	}
	
	public int getY(){
		return myLocation.y;
	}
}
