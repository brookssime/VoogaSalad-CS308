package interfaces;

import java.lang.annotation.*;

/**
 * Annotations for method parameters. 
 * 
 * @author Negatu
 *
 */

@Retention(RetentionPolicy.RUNTIME)

public @interface ParameterAnnotation {
	
	/**
	 * Name - the display name of the parameter in the editor
	 */
	public String name();

}
