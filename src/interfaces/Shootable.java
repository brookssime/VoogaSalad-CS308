package interfaces;

import java.util.List;

import engine.Placement;
import engine.gameInfo.GridObject;
import engine.sprites.Projectile;
import engine.sprites.Range;

public interface Shootable {
	
	void update();
	Collidable selectTarget(List<Collidable> targets);
	Projectile fire();
	boolean isReady();
	Range getRangeObject();
}