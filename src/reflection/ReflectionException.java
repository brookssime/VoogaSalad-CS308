/*
 * 
 */
package reflection;


// TODO: Auto-generated Javadoc
/**
 * A general exception that represents all possible Java Reflection exceptions.
 *
 * @author Robert C. Duvall
 */
public final class ReflectionException extends RuntimeException {
    // for serialization
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Create an exception based on an issue in our code.
     *
     * @param message the message
     * @param args the args
     */
    public ReflectionException (String message, Object... args) {
        super(format(message, args));
    }

    /**
     * Create an exception based on a caught exception.
     *
     * @param exception the exception
     */
    public ReflectionException (Throwable exception) {
        super(exception);
    }

    /**
     * Create an exception based on a caught exception with a different message.
     *
     * @param cause the cause
     * @param message the message
     * @param args the args
     */
    public ReflectionException (Throwable cause, String message, Object... args) {
        super(format(message, args), cause);
    }

    // remove duplicate code, also placeholder for future improvements (like logging)
    /**
     * Format.
     *
     * @param message the message
     * @param args the args
     * @return the string
     */
    private static String format (String message, Object... args) {
        return String.format(message, args);
    }
}
