/*
 * 
 */
package engine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for class methods. 
 * 
 * @author Negatu
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {

	/**
	 * editor - a boolean specifying whether this method should be used by game authoring
	 * name - display name for the method. 
	 * type - type of editor the method is going to use for implementation.
	 *
	 */
	boolean editor();
	public String name();
	public String type();
	public String gsType();
}
