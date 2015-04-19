package interfaces;

import java.util.List;
import engine.GridObject;
import engine.Placement;
import engine.Projectile;

public interface Shootable {
	
	void update(List<GridObject> targets);
	GridObject selectTarget(List<GridObject> targets);
	Projectile fire(Placement p);

}