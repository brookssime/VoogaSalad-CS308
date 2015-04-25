package engine.sprites;

import java.awt.Point;
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
	
	private int myWidth;


	private Point myGridLocation = new Point();

	
	public Tile(int x, int y, String imagePath){
		myGridLocation.x = x;
		myGridLocation.y = y;
		myImagePath = imagePath;
	}
	
	public Tile(int x, int y){
		myGridLocation.x = x;
		myGridLocation.y = y;
	}
	
	public Point getCenterLocation(){
		return new Point(myGridLocation.x + myWidth/2, myGridLocation.y + myWidth/2); // TODO THIS ASSUMES (0,0) is bottom-left on the Grid
	}
	
	public Point getGridLocation(){
		return myGridLocation;
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
		return (int) myGridLocation.x;
	}
	
	public int getY(){
		return (int) myGridLocation.y;

	}
	
	public void setWidth(int width){
		myWidth = width;
	}

	public int getWidth() {
		// TODO change if we ever need to consider Tiles of width != 1
		return myWidth;

	}
	
	public boolean isWithin(Point point){
		return (point.x > this.myGridLocation.x &&
				point.x < this.myGridLocation.x + (double)this.myWidth &&
				point.y > this.myGridLocation.y &&
				point.y < this.myGridLocation.y + (double)this.myWidth);
	}
	
	// TODO untested
	
	public double distanceToEdge(Point p){
		Point c = this.getCenterLocation();
		double d1 = p.distance(c);
		double theta = Math.atan2(p.y-c.y, p.x-c.x);
		
		if(Math.cos(theta) == 0)
			theta = 0.0;
		double adjust = Math.abs(myWidth/2 / Math.cos(theta));
		
		
		return d1 - Math.abs(adjust);
		
	}
}
