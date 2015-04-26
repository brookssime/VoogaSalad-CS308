package engine;

import java.util.LinkedList;

import engine.gameLogic.Placement;

public class Path {

	LinkedList<Movement> myMovements;
	
	public Path(LinkedList<Movement> movements){
		myMovements = movements;
	}
	
	public Placement getNextPlacement(){
		if (myMovements.getFirst().getNext() == null)
			myMovements.pop();
		return getNextPlacement();
	}
	
	public void setNextMovement(Movement m){
		myMovements.pop();
		myMovements.addFirst(m);
	}
	
	public void elongate(){ // add the last, such that the path is never empty
		myMovements.getLast().append(myMovements.getLast().getLast());
	}
	
	public Integer size(){
		int c = 0;
		for (Movement m : myMovements){
			c+= m.size();
		}
		return c;
	}


}
