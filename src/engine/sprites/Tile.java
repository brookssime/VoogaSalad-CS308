package engine.sprites;

import java.awt.geom.Point2D;


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
		// TODO change if we ever need to consider Tiles of width != 1
		return 1;

	}
}
