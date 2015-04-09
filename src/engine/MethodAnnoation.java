package engine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for class methods. 
 * @author Negatu
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnoation {

	boolean editor();
}
