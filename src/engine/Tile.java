package engine;

import interfaces.Authorable;

import java.awt.Point;
import java.awt.Shape;
import java.util.List;

public class Tile{
	
	private String myName;
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
