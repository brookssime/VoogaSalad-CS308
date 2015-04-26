package interfaces;

import java.util.List;

import engine.gameLogic.Placement;
import engine.gameLogic.Range;
import engine.sprites.Projectile;

public interface Shootable {
	
	void update();
	Collidable selectTarget(List<Collidable> targets);
	void setFirePath(Placement target, Placement cur);
	Projectile fire();
	boolean isReady();
	Range getRangeObject();
	
}