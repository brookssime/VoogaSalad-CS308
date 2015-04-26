package engine.gameScreens;

import java.awt.Point;
import java.util.List;

import engine.gameLogic.GameObject;

public class NodeButton extends GameObject{
	
	public Point myLocation;
	public GameNode myTarget;
	
	public GameNode advance(){
		return myTarget;
	}
	
	
}
