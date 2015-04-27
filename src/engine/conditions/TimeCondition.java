package engine.conditions;

import engine.NodeState;
import engine.gameScreens.LevelNode;

public class TimeCondition extends Condition{
	

	public TimeCondition(LevelNode levelNode) {
		super();
	}

	@Override
	public NodeState evaluate(LevelNode levelNode) {
		
		if(levelNode.getTotalTime()!=0 && levelNode.calculateRemainingTime()==0){
			return NodeState.TIME_UP;
		}
		return NodeState.RUNNING;
	}

}
