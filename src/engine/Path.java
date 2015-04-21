package engine;

import java.util.LinkedList;
import java.util.Random;

import engine.gameLogic.Placement;

public class Path {
	
	LinkedList<Placement> myPlacements;
	
	public Path(){
		
	}
	
	public Path(LinkedList<Placement> placements){
		myPlacements = placements;
	}
	
	Placement getNext(){
		return myPlacements.pop();
	}

	
	//creates a new instance of this Path, including modifying for randomness
	Path generateNew(){
		return null;
	}
	
	Placement intersects(Path p){
		
		return null;
		
	}
	
	LinkedList<Placement> getPlacements(){
		return myPlacements;
	}
	
	
	
	
	//TODO: come back to this

}
