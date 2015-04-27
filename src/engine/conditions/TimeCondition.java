package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public class TimeCondition extends Condition{
	
	private boolean isTimed;

	public TimeCondition(LevelNode levelNode) {
		super(levelNode);
		isTimed = (myLevelNode.getTotalTime()!=0);
	}

	@Override
	public NodeState evaluate() {
		if(isTimed && myLevelNode.calculateRemainingTime()==0){
			return NodeState.TIME_UP;
		}
		return NodeState.RUNNING;
	}

}
