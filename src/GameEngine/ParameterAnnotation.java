package GameEngine;

import java.lang.annotation.*;

/**
 * Annotations for method parameters. 
 * @author Negatu
 *
 */

@Retention(RetentionPolicy.RUNTIME)

public @interface ParameterAnnotation {
	
	public String name();

}
