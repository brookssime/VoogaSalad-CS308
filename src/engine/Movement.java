package engine;

import java.util.LinkedList;

import engine.gameLogic.Placement;

public class Movement {
	
	LinkedList<Placement> myPlacements;
	
	public Movement(LinkedList<Placement> placements){
		myPlacements = placements;
	}
	
	public Placement getNext(){
		return myPlacements.pop();
	}
	
	LinkedList<Placement> getPlacements(){
		return myPlacements;
	}

	public Placement getLast() {
		return myPlacements.getLast();
	}

}
