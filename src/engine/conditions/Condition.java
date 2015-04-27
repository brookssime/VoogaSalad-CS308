package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public abstract class Condition {
	
	protected LevelNode myLevelNode;
	
	public Condition (LevelNode levelNode) {
		myLevelNode = levelNode;
	}
	
	public abstract NodeState evaluate();

}