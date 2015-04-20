package engine;

import java.lang.annotation.*;

/**
 * Annotations for method parameters. 
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 *
 */

@Retention(RetentionPolicy.RUNTIME)

public @interface ParameterAnnotation {
	
	/**
	 * Name.
	 *
	 * @return the string
	 */
	public String name();

}
