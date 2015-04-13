package engine;

import interfaces.Authorable;

import java.awt.Point;
import java.awt.Shape;
import java.util.List;

public class Tile implements Authorable{
	
	private String myName;
	private String myImagePath;
	private Shape myShape;
	private int myAccessID;
	private int myX;
	private int myY;
	private Point myLocation = new Point();
	
	public Tile(int x, int y, String imagePath){
		myLocation.x = x;
		myLocation.y = y;
		myImagePath = imagePath;
	}
	
	public Tile(int x, int y){
		
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

	public int getX() {
		return myLocation.x;
	}
	
	public int getY(){
		return myLocation.y;
	}
}
