package engine;

import java.util.LinkedList;
import java.util.List;

import engine.gameLogic.Placement;

public class Movement {
	
	LinkedList<Placement> myPlacements;
	
	public Movement(List<Placement> placementList){
		myPlacements = (LinkedList<Placement>) placementList;
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
	
	public Integer size(){
		return myPlacements.size();
	}
	
	public void append(Placement p){
		myPlacements.add(p);
		// REVIEW make sure this effectively keeps the list from ending 
		// by keeping the object still if nothing else is added
	}

}
