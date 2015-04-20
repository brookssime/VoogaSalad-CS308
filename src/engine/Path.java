package engine;

import java.util.LinkedList;

public class Path {
	
	LinkedList<Placement> myPlacements;
	
	public Path(){
		
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
