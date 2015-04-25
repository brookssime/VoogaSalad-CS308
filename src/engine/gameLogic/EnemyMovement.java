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
	private double turnSharpness;
	
	public EnemyMovement(){
		
	}

	@Override
	public Path generatePath(List<Tile> tiles) {
		
		Tile[] tileArray = (Tile[]) tiles.toArray();
		
		LinkedList<Movement> movements = new LinkedList<Movement>();
		Placement start = findStart(tiles);
		
		// TODO set this to the initial position on the grid
		Tile lastStraight = tileArray[0];
		
		
		for (int i = 2; i < tileArray.length; i++){
			if(tileArray[i-2].getCenterLocation().x != tileArray[i].getCenterLocation().x &&  // if this one is removed in both dimensions from the one two previous -- indicates an elbow
					tileArray[i-2].getCenterLocation().y != tileArray[i].getCenterLocation().y){
				
				movements.add(makeStretch(lastStraight, tileArray[i-2], start));
				movements.add(makeTurn(tileArray[i-2], tileArray[i], movements.getLast().getLast()));
				
				lastStraight = tileArray[i]; 
				start = movements.getLast().getLast();
				
			}
		}

		return new Path(movements); 
	}
	
public Movement makeTurn(Tile t1, Tile t2, Placement p1) {
		
		// TODO
		// Determine, based on coords, which quadrant end is in wrt start
		// determine which kind of turn this is and what that means about our incrementing of the orientations
		// based on this, accurately surmise the diagonal and find an accurate end location
		
		// USE A SEQUENCE OF SMALL STRETCHES AND COMBINE THEM
		
		List<Placement> PlacementList = new LinkedList<Placement>();
		
		//PlacementList.addAll()
		
		return null;
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
			double thetaNew = myAmplitude*myFrequency*Math.cos(myFrequency*yNew + c); 
			Placement p = new Placement(new Point(xNew, yNew), thetaNew);
			pList.add(p);
			cur = p;
			distance -=yNew;
		}
		
		// rotate
		
		double sin = Math.sin(Math.toRadians(pathHeading));
		double cos = Math.cos(Math.toRadians(pathHeading));
		
		for(Placement p: pList){
			int xNew = (int) ((p.getLocation().x)*cos - p.getLocation().y*sin);
			int yNew = (int) ((p.getLocation().x)*sin + p.getLocation().y*cos);
			p.setLocation(new Point(xNew, yNew));
			p.setHeading(p.getHeading() + pathHeading);
		}
		
		// shift back
		
		for (Placement p: pList){
			p.setLocation(new Point(p.getLocation().x + t1.getCenterLocation().x,
					p.getLocation().y + t1.getCenterLocation().y));
		}
		
		return new Movement(pList);
	}


	

}
