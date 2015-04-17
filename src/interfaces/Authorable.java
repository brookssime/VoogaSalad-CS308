/*
 * 
 */
package interfaces;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Interface Authorable.
 *
 */

public interface Authorable {
	
	/**
	 * Sets the name.
	 *
	 * @param s the new name
	 */
	void setName(String s);
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName();
	
	/**
	 * Update params.
	 *
	 * @param params the params
	 */

	void updateParams(List<Object> params);

}
