package engine.sprites;

import interfaces.MethodAnnotation;

import java.awt.Point;

import engine.gameLogic.GameObject;

public class Tile extends GameObject{

	private String myImagePath;
	private int myWidth;
	private Point myGridLocation = new Point();

	public Tile(){
		
	}
	
	public Tile(int x, int y){
		myGridLocation.x = x;
		myGridLocation.y = y;
	}
	
	public Point getGridLocation(){
		return myGridLocation;
	}
	
	/********Called by GAE***********/
	
	@MethodAnnotation(editor=true, name = "Set Image", type = "imageselect", fieldName = "myImagePath")
	public void setImagePath(String imagePath){
		myImagePath = imagePath;
	}
	
	@MethodAnnotation(editor=true, name = "Set Width", type = "textfield", fieldName = "myWidth")
	public void setWidth(int width){
		myWidth = width;
	}

	/*******Called by MovementStrategy classes*****/
	
	public int getWidth() {
		return myWidth;
	}
	
	public double distanceToEdge(Point p){
		Point c = this.getCenterLocation();
		double d1 = p.distance(c);
		double theta = Math.atan2(p.y-c.y, p.x-c.x);
		
		if(Math.cos(theta) == 0)
			theta = 0.0;
		double adjust = Math.abs(myWidth/2 / Math.cos(theta));
		
		
		return d1 - Math.abs(adjust);
		
	}
	
	public Point getCenterLocation(){
		return new Point(myGridLocation.x + myWidth/2, myGridLocation.y + myWidth/2);
	}
	
	/*******Called by Grid*********/
	
	public void setGridLocation(Point p){
		myGridLocation = p;
	}
	
	public Tile clone(){
		Tile t = new Tile();
		t.myImagePath = this.myImagePath;
		t.myWidth = t.myWidth;
		return t;
	}
	
	/*******Outdated--delete once GAE is complete********/
	
	/*private boolean isWithin(Point point){
	return (point.x > this.myGridLocation.x &&
			point.x < this.myGridLocation.x + (double)this.myWidth &&
			point.y > this.myGridLocation.y &&
			point.y < this.myGridLocation.y + (double)this.myWidth);
}*/
	
	/*public String getImagePath(){
	return myImagePath;
}*/
	
}
