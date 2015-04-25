package engine;

import java.util.LinkedList;
import java.util.Random;

import engine.gameLogic.Placement;

public class Path {
	
	//LinkedList<Placement> myPlacements;
	LinkedList<Movement> myMovements;
	
	public Path(LinkedList<Movement> movements){
		myMovements = movements;
	}
	
	public Placement getNextPlacement(){
		if (myMovements.getFirst().getNext() == null)
			myMovements.pop();
		return myMovements.getFirst().getNext();
	}
	
	public void setNextMovement(Movement m){
		myMovements.pop();
		myMovements.addFirst(m);
	}
	
	
	
	/*public Placement getNext(){
		return myPlacements.pop();
	}


	
	Placement intersects(Path p){
		
		return null;
		
	}
	
	LinkedList<Placement> getPlacements(){
		return myPlacements;
	}*/

}
