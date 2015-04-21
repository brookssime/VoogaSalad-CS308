/*
 * 
 */
package engine;

import interfaces.Authorable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;
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

	private Point2D.Double myLocation = new Point2D.Double();
	
	public Tile(int x, int y, String imagePath){
		myLocation.x = (double)x;
		myLocation.y = (double)y;
		myImagePath = imagePath;
	}
	
	public Tile(int x, int y){
		myLocation.x = x;
		myLocation.y = y;
	}
	
	public Point2D.Double getLocation(){
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
		return (int) myLocation.x;
	}
	
	public int getY(){
		return (int) myLocation.y;

	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
