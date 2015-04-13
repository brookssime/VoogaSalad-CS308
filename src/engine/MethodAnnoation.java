/*
 * 
 */
package engine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// TODO: Auto-generated Javadoc
/**
 * Annotation for class methods. 
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnoation {

	/**
	 * Editor.
	 *
	 * @return true, if successful
	 */
	boolean editor();
}
