package interfaces;

import java.util.List;

/*
 * Yo Peter, can you comment what this class does, Duvall will probs want explanation
 */

public interface Authorable {
	
	void setName(String s);
	String getName();
	
	void updateParams(List<Object> params);

}
