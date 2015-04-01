package interfaces;

/**
 * The Generator interface handles objects that generate other objects.
 * Ex. A tower can GENERATE a projectile
 * @author brookssime
 * 
 *
 */
public interface Generator {

	void setPort(double x, double y);
	void generate(Generatable generatable);
}
