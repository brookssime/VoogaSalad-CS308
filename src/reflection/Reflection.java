/*
 * 
 */
package reflection;

import interfaces.MethodAnnotation;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * This class provides a variety of convenience methods for dynamically calling
 * methods and allocating classes. This utility class simplifies some of Java's
 * reflection API and fixes some issues.
 */
public class Reflection {

	/**
	 * Given a String representing the fully qualified name of a class, returns
	 * an initialized instance of the corresponding class using default
	 * constructor. Returns null if string does not name a valid class.
	 *
	 * @param className
	 *            the class name
	 * @return the object
	 * @throws ReflectionException
	 *             the reflection exception
	 */
	public static Object createInstance(String className)
			throws ReflectionException {
		try {
			return Class.forName(className).newInstance();
		} catch (ClassNotFoundException e) {
			throw new ReflectionException("Incorrectly named class %s",
					className);
		} catch (Exception e) {
			throw new ReflectionException(
					"No public default constructor for %s", className);
		}
	}

	/**
	 * Given String representing fully qualified name of a class and the actual
	 * parameters, returns initialized instance of the corresponding class using
	 * matching constructor.
	 *
	 * @param name
	 *            the name
	 * @param args
	 *            the args
	 * @return the object
	 * @throws ReflectionException
	 *             the reflection exception
	 */
	public static Object createInstance(String name, Object... args)
			throws ReflectionException {
		try {
			Class<?> c = Class.forName(name);
			for (Constructor<?> current : c.getDeclaredConstructors()) {
				Class<?>[] formals = current.getParameterTypes();
				if (typesMatch(current, formals, args)) {
					return current.newInstance(convertArgs(current, formals,
							args));
				}
			}
			throw new ReflectionException(
					"No matching public constructor for %s", name);
		} catch (ClassNotFoundException e) {
			throw new ReflectionException("Incorrectly named class %s", name);
		} catch (Exception e) {
			throw new ReflectionException(
					"No matching public constructor for %s", name);
		}
	}

	/**
	 * Given a target object with a no argument method of the given name, call
	 * the named method on that object and return the result.
	 * 
	 * If the method's return type is void, null in returned.
	 *
	 * @param target
	 *            the target
	 * @param name
	 *            the name
	 * @return the object
	 * @throws ReflectionException
	 *             the reflection exception
	 */
	public static Object callMethod(Object target, String name)
			throws ReflectionException {
		try {
			Method toCall = target.getClass().getDeclaredMethod(name,
					new Class[0]);
			return toCall.invoke(target, new Object[0]);
		} catch (Exception e) {
			throw new ReflectionException(
					"No matching public method %s for %s", name, target
							.getClass().getName());
		}
	}

	/**
	 * Given a target object with a method of the given name that takes the
	 * given actual parameters, call the named method on that object and return
	 * the result.
	 * 
	 * If the method's return type is void, null in returned.
	 *
	 * @param target
	 *            the target
	 * @param name
	 *            the name
	 * @param args
	 *            the args
	 * @return the object
	 * @throws ReflectionException
	 *             the reflection exception
	 */
	public static Object callMethod(Object target, String name, Object... args)
			throws ReflectionException {
		if (args == null || args.length == 0) {
			return callMethod(target, name);
		}
		try {
			for (Method current : target.getClass().getDeclaredMethods()) {
				if (name.equals(current.getName())) {
					Class<?>[] formals = current.getParameterTypes();
					if (typesMatch(current, formals, args)) {
						return current.invoke(target,
								convertArgs(current, formals, args));
					}
				}
			}
			throw new ReflectionException(
					"No matching public method %s for %s", name, target
							.getClass().getName());
		} catch (Exception e) {
			throw new ReflectionException(
					"No matching public method %s for %s", name, target
							.getClass().getName());
		}
	}

	/**
	 * Given a target object with an instance variable with the given name, get
	 * the value of the named variable on that object and return it.
	 *
	 * @param target
	 *            the target
	 * @param name
	 *            the name
	 * @return the field value
	 * @throws ReflectionException
	 *             the reflection exception
	 */
	public static Object getFieldValue(Object target, String name)
			throws ReflectionException {
		try {
			return target.getClass().getDeclaredField(name).get(target);
		} catch (Exception e) {
			throw new ReflectionException(
					"No matching public instance variable for %s", target
							.getClass().getName());
		}
	}

	/**
	 * Given an array of Objects, returns their corresponding Classes.
	 *
	 * @param args
	 *            the args
	 * @return the class[]
	 */
	public static Class<?>[] toClasses(Object[] args) {
		Class<?>[] results = new Class[args.length];
		for (int k = 0; k < args.length; k++) {
			results[k] = args[k].getClass();
		}
		return results;
	}

	/**
	 * return a list of methods for a given object that can be edited by the
	 * editor window.
	 *
	 * @param target
	 *            object
	 * @return a list of editor methods
	 */
	public static List<Method> getEditorMethods(String classname) {
		try {
			Method[] allMethods = Class.forName(classname).getDeclaredMethods();
			List<Method> targetMethods = new ArrayList<>();
			for (Method method : allMethods) {
				MethodAnnotation methodAnnotation = method
						.getAnnotation(interfaces.MethodAnnotation.class);
				if (methodAnnotation != null && methodAnnotation.editor()) {
					targetMethods.add(method);
				}
			}
			return targetMethods;
		} catch (Exception e) {
			throw new ReflectionException("Classname not found: " + classname);
		}
	}
	
	// are parameters of compatible types and in same order?
	/**
	 * Types match.
	 *
	 * @param function
	 *            the function
	 * @param formals
	 *            the formals
	 * @param actuals
	 *            the actuals
	 * @return true, if successful
	 */
	private static boolean typesMatch(Member function, Class<?>[] formals,
			Object[] actuals) {
		if ((actuals.length == formals.length)
				|| (actuals.length >= formals.length && isVarArgs(function))) {
			int idx = 0;
			// check each parameter individually
			for (; idx < formals.length - 1; idx++) {
				if (!isInstance(formals[idx], actuals[idx])) {
					return false;
				}
			}
			// check each of the last actual args to see if they can be one of
			// varargs
			Class<?> type = (formals[idx].isArray()) ? formals[idx]
					.getComponentType() : formals[idx];
			for (; idx < actuals.length; idx++) {
				if (!isInstance(type, actuals[idx])) {
					return false;
				}
			}
			// it was possible, and nothing else returned false, so
			return true;
		}
		// sizes don't match
		return false;
	}

	// if necessary, convert parameters into varArg array that Java expects
	/**
	 * Convert args.
	 *
	 * @param function
	 *            the function
	 * @param formals
	 *            the formals
	 * @param actuals
	 *            the actuals
	 * @return the object[]
	 */
	private static Object[] convertArgs(Member function, Class<?>[] formals,
			Object[] actuals) {
		Object[] results = actuals;
		if (isVarArgs(function)) {
			results = new Object[formals.length];
			int idx = 0;
			for (; idx < formals.length - 1; idx++) {
				// simply copy the basic parameters
				results[idx] = actuals[idx];
			}
			Class<?> type = formals[idx].getComponentType();
			Object varArgs = Array.newInstance(type, actuals.length
					- formals.length + 1);
			for (; idx < actuals.length; idx++) {
				// fill the varArg array with the remaining parameters
				Array.set(varArgs, idx - formals.length + 1, actuals[idx]);
			}
			results[results.length - 1] = varArgs;
		}
		return results;
	}

	// Java should implement this correctly, but alas ...
	/**
	 * Checks if is instance.
	 *
	 * @param clss
	 *            the clss
	 * @param instance
	 *            the instance
	 * @return true, if is instance
	 */
	private static boolean isInstance(Class<?> clss, Object instance) {
		final String TYPE = "TYPE";
		try {
			// handle primitives specially
			if (clss.isPrimitive()) {
				Class<?> thePrimitive = (Class<?>) getFieldValue(instance, TYPE);
				if (!isAssignableFrom(clss, thePrimitive)) {
					// primitives are not exactly the same
					return false;
				}
			} else if (!clss.isInstance(instance)) {
				// not an instance of class or its sub-classes
				return false;
			}
			return true;
		} catch (Exception e) {
			// tried to compare primitive to non-primitive
			return false;
		}
	}

	// Java should implement this correctly, but alas ...
	// isVarArgs is a method of both constructors and methods,
	// but not to any of their common super-types
	/**
	 * Checks if is var args.
	 *
	 * @param function
	 *            the function
	 * @return true, if is var args
	 */
	private static boolean isVarArgs(Member function) {
		// BUGBUG: should call isVarArgs directly
		return Modifier.isTransient(function.getModifiers());
	}

	// Java should implement this correctly, but alas ...
	// right now, no added functionality, because of potential ambiguities
	/**
	 * Checks if is assignable from.
	 *
	 * @param formal
	 *            the formal
	 * @param arg
	 *            the arg
	 * @return true, if is assignable from
	 */
	private static boolean isAssignableFrom(Class<?> formal, Class<?> arg) {
		return formal.isAssignableFrom(arg);
	}
}
