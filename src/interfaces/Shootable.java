package interfaces;

import java.util.List;

import engine.GridObject;
import engine.Placement;
import engine.Projectile;
import engine.Range;

public interface Shootable {
	
	void update();
	Collidable selectTarget(List<Collidable> targets);
	Projectile fire();
	boolean isReady();
	Range getRangeObject();
}