package engine;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)

public @interface ParameterAnnotation {
	
	public String name();

}
