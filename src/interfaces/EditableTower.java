/*
 * 
 */
package interfaces;

import java.util.List;

import com.sun.javafx.geom.Point2D;

import engine.Projectile;

// TODO: Auto-generated Javadoc
/**
 * The Interface EditableTower.
 */
public interface EditableTower {
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name);
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName();
	
	/**
	 * Sets the image string.
	 *
	 * @param imageString the new image string
	 */
	void setImageString(String imageString);
	
	/**
	 * Gets the image string.
	 *
	 * @return the image string
	 */
	String getImageString();
	
	/**
	 * Sets the access list.
	 *
	 * @param accessList the new access list
	 */
	void setAccessList(List<Integer> accessList);
	
	/**
	 * Sets the range.
	 *
	 * @param range the new range
	 */
	void setRange(Integer range);
	
	/**
	 * Sets the fire rate.
	 *
	 * @param fireRate the new fire rate
	 */
	void setFireRate(Integer fireRate);
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	void setLocation(Point2D location);
	
	/**
	 * Sets the health.
	 *
	 * @param health the new health
	 */
	void setHealth(Integer health);
	
	/**
	 * Sets the radius.
	 *
	 * @param radius the new radius
	 */
	void setRadius(Integer radius);
	
	/**
	 * Sets the projectile.
	 *
	 * @param projectile the new projectile
	 */
	void setProjectile(Projectile projectile);
	
}
