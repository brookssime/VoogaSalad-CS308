package engine;

import interfaces.MovementStrategy;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import engine.gameLogic.Placement;
import engine.sprites.Tile;

public class EnemyMovement implements MovementStrategy{
	
	// should describe the EQUATION that describes movement
	
	private int mySpeed; // dx in path direction
	private double myAmplitude;
	private double myFrequency;
	private double turnSharpness;
	
	public EnemyMovement(){
		
	}

	@Override
	public Path generatePath(LinkedList<Tile> tiles) {
		
		Tile[] tileArray = (Tile[]) tiles.toArray();
		Placement[] placementArray = new Placement[tiles.size()];
		for (int i = 0; i < tiles.size(); i++)
			placementArray[i] = new Placement(tileArray[i].getCenterLocation());
		
		LinkedList<Placement> myMovements = new LinkedList<Placement>();
		Placement lastStraight = new Placement();
		lastStraight = placementArray[0];
		
		for (int i = 2; i < placementArray.length; i++){
			if(placementArray[i-2].getLocation().x != placementArray[i].getLocation().x && placementArray[i-2].getLocation().y != placementArray[i].getLocation().y){
				myMovements.addAll(makeStretch(lastStraight, placementArray[i-2]));
				myMovements.addAll(makeTurn(myMovements.get(myMovements.size()-1), placementArray[i]));
				lastStraight = myMovements.get(myMovements.size()-1); // TODO MAKE SURE this gets the right Placement coming out of the turn	
			}
		}
		
		// TODO MAKE SURE THIS CAST WORKS
		return new Path(myMovements); 
	}
	
	public LinkedList<Placement> makeStretch(Tile t1, Tile t2, Placement p1){
		// make initial calculations
		double distance = p1.getLocation().distance(t1.getGridLocation());
		double pathHeading = 90 - Math.atan2((t2.getCenterLocation().y- t1.getCenterLocation().y), 
				(t2.getCenterLocation().x - t2.getCenterLocation().x));
		
		// normalize to vertical from (0,0)
		double relativeHeading = p1.getHeading()-pathHeading;
		int xNorm = (int) (p1.getLocation().x - t1.getCenterLocation().x);
		int yNorm = (int) (p1.getLocation().y - t1.getCenterLocation().y);
		int c = 0 - yNorm;
		Placement pNorm = new Placement(new Point(xNorm, yNorm), relativeHeading);
		
		Placement cur = pNorm;
		LinkedList<Placement> path = new LinkedList<Placement>();
		
		// build path vertically
		while(!t2.isWithin(cur.getLocation())){
			int yNew = cur.getLocation().y + mySpeed;
			int xNew = (int) (myAmplitude*Math.sin(myFrequency*yNew + c));
			double thetaNew = myAmplitude*myFrequency*Math.cos(myFrequency*yNew + c);
			Placement p = new Placement(new Point(xNew, yNew), thetaNew);
			path.add(p);
			cur = p;
		}
		
		// rotate
		
		
	}


	
	/*public LinkedList<Placement> makeStretch(Placement p1, Placement p2){
	
		
		Point2D.Double start = (Point2D.Double) p1.getLocation().clone(); // TODO MAKE SURE THE UPDATES BELOW...
		Point2D.Double end = (Point2D.Double) p2.getLocation().clone();
		
		int myCoordProperty = 0;
	
		// 1. Adjust actual coordinates as necessary from Tile Locations
		
		if(start.x != end.x){
			start.setLocation(start.x + ((start.x < end.x)?1:0) , start.y); 
			end.setLocation(end.x + ((start.x < end.x)?0:1), end.y);
			myCoordProperty = 0;
		}
		
		else if(start.y != end.y){
			start.setLocation(start.x, start.y + ((start.y < end.y)?1:0));
			end.setLocation(end.x, end.y + ((start.y < end.y)?0:1));
			myCoordProperty = 1;
		}
		
		// ...RESULT IN p1 and p2 BEING UPDATED HERE^^ TODO
		// calculate Placements based on points and coordinate property
		
		start = p1.getLocation();
		end = p2.getLocation();
		
		LinkedList<Placement> path = new LinkedList<Placement>();
		
		Random freqRandom = new Random((long) (2*(1/myFrequency)));
		double c = freqRandom.nextDouble()-1/myFrequency;
		double zeroLoc = getCoordProperty(start, myCoordProperty); // baseline in direction we care about
		double distance = getCoordProperty(start, myCoordProperty) - getCoordProperty(end,myCoordProperty); // distance in direction we care about
		
		// if current is less than target, increment positively; else, increment negatively
		int modifier  = ((getCoordProperty(start, myCoordProperty)) < (getCoordProperty(end, myCoordProperty))?1:-1);
		
		// initializes actual start location
		setCoordProperty(start, myCoordProperty, getCoordProperty(start, myCoordProperty)+c);
		Point2D.Double cur = new Point2D.Double(start.x, start.y);
		
		// find where start intersects graph
		
		while(distance > 0){
			// find slope at current spot
			double slope = myAmplitude*myFrequency*(Math.cos(myFrequency*((getCoordProperty(cur, myCoordProperty) - zeroLoc))) + c);
			//slope = Math.toDegrees(slope);
			double orientationPolar = Math.toDegrees(Math.atan2(slope, 1.0)); // polar degrees representation from horizontal
			double orientationHeading = -1*orientationPolar + 90; // heading degrees representation from vertical
			double orientationVert = orientationHeading + ((modifier > 0)?0:180) + ((myCoordProperty == 0)?0:90);
			// make a new Placement out of the current spot
			Placement place = new Placement(cur, orientationVert); 
			path.add(place);
			// calculate and set new coord location based on speed
			setCoordProperty(cur, myCoordProperty, (getCoordProperty(cur, myCoordProperty) + (modifier)*mySpeed));
			// calculate new dependent location based on new coord location
			double newPos = myAmplitude*Math.sin(myFrequency*(getCoordProperty(cur, myCoordProperty) - zeroLoc) + c);
			// set dependent location
			setCoordProperty(cur, myCoordProperty^1, newPos); // TODO fix this logical and -- THIS WILL NOT WORK THE 
			// CORRECTLY SINCE DIRECTIONPROPERTY IS AN INT WHEN YOU WANT IT TO BE BOOLEAN
			distance -= mySpeed;
			
		}
		
		return path;
		
	}*/
	
	public List<Placement> makeTurn(Placement start, Placement end) {
		
		// TODO
		// Determine, based on coords, which quadrant end is in wrt start
		// determine which kind of turn this is and what that means about our incrementing of the orientations
		// based on this, accurately surmise the diagonal and find an accurate end location
		
		// USE A SEQUENCE OF SMALL STRETCHES AND COMBINE THEM
		
		List<Placement> PlacementList = new LinkedList<Placement>();
		
		//PlacementList.addAll()
		
		return null;
	}
	
	private double getCoordProperty(Point2D.Double p, int i){
		if(i == 0)
			return p.x;
		return p.y;
	}
	
	private void setCoordProperty(Point2D.Double p, int i, double D){
		if(i == 0)
			p.x = D;
		else
			p.y = D;	
	}

}
