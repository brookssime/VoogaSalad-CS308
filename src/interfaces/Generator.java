package interfaces;

/**
 * The Generator interface handles objects that generate other objects.
 * Ex. A tower can GENERATE a projectile
 * Ex. a wave can GENERATE a enemy
 * Ex. a store can GENERATE a tower
 * Ex. a enemy can GENERATE other enemies
 * @author brookssime
 * 
 *
 */
public interface Generator {

	void setPort(double x, double y);
	void generate(Generatable generatable);
}
