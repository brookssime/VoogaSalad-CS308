/*
 * 
 */
package interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for class methods. 
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {

	/**
	 * Editor.
	 *
	 * @return true, if successful
	 */
	boolean editor();
}