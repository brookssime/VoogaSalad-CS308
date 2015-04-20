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

public class Tile{

	
	/** The my name. */
	private String myName;
	
	/** The my image path. */
	private String myImagePath;

	private Point myLocation = new Point();
	
	public Tile(int x, int y, String imagePath){
		myLocation.x = x;
		myLocation.y = y;
		myImagePath = imagePath;
	}
	
	public Tile(int x, int y){
		myLocation.x = x;
		myLocation.y = y;
	}
	
	public Point getLocation(){
		return myLocation;
	}
	
	public void setImagePath(String imagePath){
		myImagePath = imagePath;
	}

	public void setName(String name) {
		myName = name;
	}

	public String getImagePath(){
		return myImagePath;
	}
	

	public String getName() {
		return myName;
	}


	public int getX() {
		return myLocation.x;
	}
	
	public int getY(){
		return myLocation.y;

	}
}
