package interfaces;

import java.util.List;

public interface Authorable {
	
	void setName(String s);
	String getName();
	void updateParams(List<Object> params);

}
