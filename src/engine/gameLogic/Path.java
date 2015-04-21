package engine.gameLogic;

import java.util.LinkedList;

/**
 * TODO: Make this a functioning class
 * Many methods returning null currently
 * @author Sid
 *
 */
public class Path {
	
	private LinkedList<Placement> myPlacements;
	
	public Path(LinkedList<Placement> placements){
		myPlacements = placements;
	}
	
	public Placement getNext(){
		return myPlacements.pop();
	}
	
	//creates a new instance of this Path, including modifying for randomness
	public Path generateNew(){
		return null;
	}
	
	private Placement intersects(Path p){
		return null;
	}
	
	public LinkedList<Placement> getPlacements(){
		return myPlacements;
	}
}