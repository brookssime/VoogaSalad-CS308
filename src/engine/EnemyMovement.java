package engine;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Random;

public class EnemyMovement {
	
	// should describe the EQUATION that describes movement
	
	private Double mySpeed; // dx in path direction
	private Double myAmplitude;
	private Double myFrequency;
	
	public EnemyMovement(){
		
	}
	
	Double getAmplitude(){
		return myAmplitude;
	}
	
	LinkedList<Placement> makeStretch(Point2D.Double start, Point2D.Double end, int directionProperty){
		
		LinkedList<Placement> path = new LinkedList<Placement>();
		
		Random freqRandom = new Random((long) (2*(1/myFrequency)));
		Double c = freqRandom.nextDouble()-1/myFrequency;
		Double zeroLoc = getCoordProperty(start, directionProperty); // baseline in direction we care about
		Double distance = getCoordProperty(start, directionProperty) - getCoordProperty(end,directionProperty); // distance in direction we care about
		
		// if current is less than target, increment positively; else, increment negatively
		int modifier  = ((getCoordProperty(start, directionProperty)) < (getCoordProperty(end, directionProperty))?1:-1);
		
		// initializes actual start location
		setCoordProperty(start, directionProperty, getCoordProperty(start, directionProperty)+c);
		Point2D.Double cur = new Point2D.Double(start.x, start.y);
		
		// find where start intersects graph
		
		while(distance > 0){
			// find slope at current spot
			double slope = myAmplitude*myFrequency*(Math.cos(myFrequency*((getCoordProperty(cur, directionProperty) - zeroLoc))) + c);
			//slope = Math.toDegrees(slope);
			double orientationPolar = Math.toDegrees(Math.atan2(slope, 1.0)); // polar degrees representation from horizontal
			double orientationHeading = -1*orientationPolar + 90; // heading degrees representation from vertical
			double orientationVert = orientationHeading + ((modifier > 0)?0:180) + ((directionProperty == 0)?0:90);
			// make a new Placement out of the current spot
			Placement place = new Placement(cur, orientationVert); 
			path.add(place);
			// calculate and set new coord location based on speed
			setCoordProperty(cur, directionProperty, (getCoordProperty(cur, directionProperty) + (modifier)*mySpeed));
			// calculate new dependent location based on new coord location
			double newPos = myAmplitude*Math.sin(myFrequency*(getCoordProperty(cur, directionProperty) - zeroLoc) + c);
			// set dependent location
			setCoordProperty(cur, directionProperty^1, newPos);
			distance -= mySpeed;
			
		}
		
		return path;
		
	}
	
	
	
	Double getCoordProperty(Point2D.Double p, int i){
		if(i == 0)
			return p.x;
		return p.y;
	}
	
	void setCoordProperty(Point2D.Double p, int i, double D){
		if(i == 0)
			p.x = D;
		else
			p.y = D;	
	}

}
