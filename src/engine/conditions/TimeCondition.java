package engine.conditions;

import engine.Environment;

public class TimeCondition extends Condition{

	public TimeCondition(Environment gameData) {
		super(gameData);
	}

	@Override
	public boolean evaluate() {
		return false;
	}

}
