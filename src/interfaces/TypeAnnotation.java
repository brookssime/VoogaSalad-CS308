package interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TypeAnnotation {

	/**
	 * types - types of objects the method is going to use for implementation.
	 *
	 */
	String type();
}
