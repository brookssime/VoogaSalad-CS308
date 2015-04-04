package GameEngine;

import java.util.List;

import interfaces.Collidable;
import interfaces.Movable;

public class Enemy implements Collidable, Movable{

	private Integer mySpeed;
	private Integer myDamage;
	private List<Integer> myWalkable;
	private String myImageString;
	//State?
	//Path?
	
	@Override
	public void evaluateCollision(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
