package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public abstract class Condition {
	
	
	public Condition () {
	}
	
	public abstract NodeState evaluate(LevelNode levelNode);

}