package engine.conditions;

import engine.Environment;

public class HealthCondition extends Condition{

	public HealthCondition(Environment gameData) {
		super(gameData);
	}

	@Override
	public boolean evaluate() {
		return false;
	}

}
