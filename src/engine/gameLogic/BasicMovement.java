package engine.gameLogic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import engine.Movement;
import engine.Path;
import engine.sprites.Tile;
import interfaces.MovementStrategy;

public class BasicMovement implements MovementStrategy{

	private int mySpeed;
	
	@Override
	public Path generatePath(List<Tile> tiles) {
		
		Tile[] tileArray = (Tile[]) tiles.toArray();
		LinkedList<Movement> movements = new LinkedList<Movement>();
		Point lastCorner = findStart(tiles).getLocation();
		for (int i = 2; i < tileArray.length; i++){
			if(tileArray[i-2].getCenterLocation().x != tileArray[i].getCenterLocation().x &&  // if this one is removed in both dimensions from the one two previous -- indicates an elbow
					tileArray[i-2].getCenterLocation().y != tileArray[i].getCenterLocation().y){
				
				movements.add(makeLine(lastCorner, tileArray[i-1].getCenterLocation()));
				lastCorner = tileArray[i-1].getCenterLocation(); 
			}
		}

		return new Path(movements); 
	}
	
	private Movement makeLine(Point start, Point point) {
		boolean horizontal =  (start.y==point.y); // if the ys are equal, horizontal = true
		boolean increasing = (horizontal)?(point.x > start.x):(point.y > start.y);
		double distance = start.distance(point);
		double orientation = 90.0 - Math.toDegrees(Math.atan2(point.y - start.y, point.x - start.x));
		List<Placement> pList = new ArrayList<Placement>(); 
	
		while(start.distance(point) > distance){
			pList.add(new Placement(start, orientation)); 
			start = new Point(start.x + (horizontal?(increasing?mySpeed:-1*mySpeed):0), start.y + (horizontal?0:(increasing?mySpeed:-1*mySpeed)));
		}
		return new Movement(pList);
	}
	/*
	 * finds the starting point of this straight path--will be the point in the first tile 
	 * in the center of the edge directly across from the second tile
	 * 
	 */
	
	public Placement findStart(List<Tile> tiles){
		int x0 = (int) (tiles.get(0).getCenterLocation().x + Math.cos(Math.atan2(tiles.get(1).getCenterLocation().y - tiles.get(0).getCenterLocation().y, 
				tiles.get(1).getCenterLocation().x - tiles.get(0).getCenterLocation().x)));
		int y0 = (int) (tiles.get(0).getCenterLocation().y + Math.sin(Math.atan2(tiles.get(1).getCenterLocation().y - tiles.get(0).getCenterLocation().y, 
				tiles.get(1).getCenterLocation().x - tiles.get(0).getCenterLocation().x)));
		double theta = 90 - (Math.toDegrees(Math.atan2(tiles.get(1).getCenterLocation().y - tiles.get(0).getCenterLocation().y, 
				tiles.get(1).getCenterLocation().x - tiles.get(0).getCenterLocation().x)));
		return new Placement(new Point(x0, y0), theta);
	}

}
