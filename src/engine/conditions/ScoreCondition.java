package engine.conditions;

import engine.Environment;

public class ScoreCondition extends Condition{

	public ScoreCondition(Environment gameData) {
		super(gameData);
	}

	@Override
	public boolean evaluate() {
		return false;
	}

}
