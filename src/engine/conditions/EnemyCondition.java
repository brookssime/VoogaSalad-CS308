package engine.conditions;

import engine.Environment;

public class EnemyCondition extends Condition{

	public EnemyCondition(Environment gameData) {
		super(gameData);
	}

	@Override
	public boolean evaluate() {
		return myGridManager.getWaves().isEmpty();
	}

}
