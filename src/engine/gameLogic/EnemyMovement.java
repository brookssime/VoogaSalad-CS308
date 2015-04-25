package engine.gameLogic;

import interfaces.MovementStrategy;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import engine.Movement;
import engine.Path;
import engine.sprites.Tile;

public class EnemyMovement implements MovementStrategy{
	
	// should describe the EQUATION that describes movement
	
	private int mySpeed; // dx in path direction
	private double myAmplitude;
	private double myFrequency;
	
	
	public EnemyMovement(){
		
	}

	@Override
	public Path generatePath(List<Tile> tiles) {
		
		Tile[] tileArray = (Tile[]) tiles.toArray();
		
		LinkedList<Movement> movements = new LinkedList<Movement>();
		
		//TODO fix the findStart method
		Placement start = findStart(tiles);
		
		
		Tile lastStraight = tileArray[0];
		
		
		for (int i = 2; i < tileArray.length; i++){
			if(tileArray[i-2].getCenterLocation().x != tileArray[i].getCenterLocation().x &&  // if this one is removed in both dimensions from the one two previous -- indicates an elbow
					tileArray[i-2].getCenterLocation().y != tileArray[i].getCenterLocation().y){
				
				movements.add(makeStretch(lastStraight, tileArray[i-2], start));
				movements.add(makeTurn(tileArray[i-2], tileArray[i-1], tileArray[i], movements.getLast().getLast()));
				
				lastStraight = tileArray[i]; 
				start = movements.getLast().getLast();
				
			}
		}

		return new Path(movements); 
	}
	
public Movement makeTurn(Tile t0, Tile t1, Tile t2, Placement p1) {
		
	
		
		List<Placement> PlacementList = new LinkedList<Placement>();
		
		int xpivot = t0.getGridLocation().x + ((t0.getGridLocation().x < t2.getGridLocation().x)?t0.getWidth():0);
		int ypivot = t0.getGridLocation().y + ((t0.getGridLocation().y < t2.getGridLocation().y)?t0.getWidth():0);
		
		Point pivot = new Point (xpivot, ypivot);
		
		int rotationDir = isRightTurn(t0.getCenterLocation(), t1.getCenterLocation(), t2.getCenterLocation())?1:-1; // gets 1 if a right turn
		int arcLength = (int) Math.sqrt(2*Math.pow(p1.getLocation().distance(pivot),2)); 
		// basic Pythagorean for purpose of conceptualizing the distance needed to travel. this will mess with speed, but it should be negligible
		int numSegments = (arcLength / mySpeed) +1;
		int dtheta = (90/numSegments)*rotationDir;
		
		for(int i = 0; i < numSegments; i += 1){
			Placement p = new Placement(rotatePoint(p1.getLocation(), pivot, dtheta));
			p.setHeading(p1.getHeading() + dtheta);
			PlacementList.add(p);
			dtheta += dtheta;
		}
		
		
		PlacementList.add(new Placement(rotatePoint(p1.getLocation(), pivot, 90*rotationDir), p1.getHeading() + 90*rotationDir));
		// THIS ^ should add a correctly rotated placement to the end of the list, ensuring that the next stretch has a valid starting point
		return new Movement(PlacementList);
		
	}

	private boolean isRightTurn(Point p0, Point p1, Point p2){
		int x0 = p0.x; 
		int x2 = p2.x; 
		int y0 = p0.y; 
		int y2 = p2.y;
		
		int h = (int) Math.toDegrees(Math.atan2(p1.y - p0.y, p1.x - p0.x));
		
		return(x2>x0&&h==0 || 
				x2<x0 && h == 180 || 
				y2>y0 && h == 90 || 
				y2<y0 && h == 270);
		
		// TODO ^^ this will be buggy, consider weirdness in calculations and/or what to do if atan2 returns a negative value
	}

	public Placement findStart(List<Tile> tiles){
		Tile[] tileArray = (Tile[]) tiles.toArray();
	
		int x0 = (int) (tiles.get(0).getCenterLocation().x + Math.cos(Math.atan2(tiles.get(1).getCenterLocation().y - tiles.get(0).getCenterLocation().y, 
				tiles.get(1).getCenterLocation().x - tiles.get(0).getCenterLocation().x)));
		int y0 = (int) (tiles.get(0).getCenterLocation().y + Math.sin(Math.atan2(tiles.get(1).getCenterLocation().y - tiles.get(0).getCenterLocation().y, 
				tiles.get(1).getCenterLocation().x - tiles.get(0).getCenterLocation().x)));
		//x0 += 0;
		//y0 += 0;
		
		double slope = myAmplitude*myFrequency*Math.cos(0);
		double theta = 90 - (Math.toDegrees(Math.atan2(tiles.get(1).getCenterLocation().y - tiles.get(0).getCenterLocation().y, 
				tiles.get(1).getCenterLocation().x - tiles.get(0).getCenterLocation().x) + Math.atan2(slope,1)));
		
		//double theta = (45.0 - Math.atan2(tiles.get(1).getCenterLocation().y - tiles.get(0).getCenterLocation().y, 
				//tiles.get(1).getCenterLocation().x - tiles.get(0).getCenterLocation().x));
		
		// TODO (once testable in Player) fix this to return a randomly-generated start location and angle based on the tiles...
		// currently: does NOT have a random shift, so each simply starts in the center of the appropriate side, instead of being offset...
		// and the angle is hard-coded, instead of being adjustable based on offset
		
		
		return new Placement(new Point(x0, y0), theta);
		
		
	}
	
	public Movement makeStretch(Tile t1, Tile t2, Placement p1){
		
		// make initial calculations
		double distance = t2.distanceToEdge(p1.getLocation());
		double pathHeading = 90 - Math.atan2((t2.getCenterLocation().y- t1.getCenterLocation().y), 
				(t2.getCenterLocation().x - t2.getCenterLocation().x));
		
		// normalize to vertical from (0,0)
		double relativeHeading = p1.getHeading()-pathHeading;
		int xNorm = (int) (p1.getLocation().x - t1.getCenterLocation().x);
		int yNorm = (int) (p1.getLocation().y - t1.getCenterLocation().y);
		int c = 0 - yNorm; // TODO make sure this is the right way to handle c -- suspect it is not
		Placement pNorm = new Placement(new Point(xNorm, yNorm), relativeHeading);
		
		Placement cur = pNorm;
		LinkedList<Placement> pList = new LinkedList<Placement>();
		
		// build path vertically
		while(distance > 0){
			int yNew = cur.getLocation().y + mySpeed;
			int xNew = (int) (myAmplitude*Math.sin(myFrequency*yNew + c));
			double slope = myAmplitude*myFrequency*Math.cos(myFrequency*yNew + c);
			double thetaNew = 90.0 - Math.toDegrees(Math.atan2(1, slope));
					
			Placement p = new Placement(new Point(xNew, yNew), thetaNew);
			pList.add(p);
			cur = p;
			distance -=yNew;
		}
		
		// rotate
		
		/*double sin = Math.sin(Math.toRadians(pathHeading));
		double cos = Math.cos(Math.toRadians(pathHeading));*/
		Point origin = new Point(0,0);
		
		for(Placement p: pList){
			/*int xNew = (int) ((p.getLocation().x)*cos - p.getLocation().y*sin);
			int yNew = (int) ((p.getLocation().x)*sin + p.getLocation().y*cos);*/
			p.setLocation(rotatePoint(p.getLocation(), origin, pathHeading));
			//p.setLocation(new Point(xNew, yNew));
			p.setHeading(p.getHeading() + pathHeading);
		}
		
		// shift back
		
		for (Placement p: pList){
			p.setLocation(new Point(p.getLocation().x + t1.getCenterLocation().x,
					p.getLocation().y + t1.getCenterLocation().y));
		}
		
		return new Movement(pList);
	}
	
	public Point rotatePoint(Point p1, Point pivot, double angle){	
		
		  double sin = Math.sin(Math.toRadians(angle));
		  double cos = Math.cos(Math.toRadians(angle));
		  
		  Point end = new Point(p1.x, p1.y);

		  // translate point back to origin:
		  end.x -= pivot.x;
		  end.y -= pivot.y;

		  // rotate point
		  double xnew = end.x*cos - end.y*sin;
		  double ynew = end.x*sin + end.y*cos;

		  // translate point back:
		  end.x = (int) (xnew + pivot.x);
		  end.y = (int) (ynew + pivot.y);
		  
		  return end;	
	}


	

}
