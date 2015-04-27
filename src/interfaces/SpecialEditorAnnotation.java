package interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SpecialEditorAnnotation {

	/**
	 * editor - a boolean specifying whether this method should be used by game authoring
	 * name - display name for the method. 
	 * type - type of editor the method is going to use for implementation.
	 *
	 */
	boolean specialeditor();
	public String name();
	public String type();
	public String fieldName();
}
