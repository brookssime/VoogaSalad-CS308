package interfaces;

import java.util.List;

import com.sun.javafx.geom.Point2D;

import engine.Projectile;

public interface EditableTower {
	void setName(String name);
	String getName();
	void setImageString(String imageString);
	String getImageString();
	void setAccessList(List<Integer> accessList);
	void setRange(Integer range);
	void setFireRate(Integer fireRate);
	void setLocation(Point2D location);
	void setHealth(Integer health);
	void setRadius(Integer radius);
	void setProjectile(Projectile projectile);
	
}