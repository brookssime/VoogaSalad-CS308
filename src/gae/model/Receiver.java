package gae.model;

import engine.gameScreens.NodeButton;
import gae.view.inventorypane.UpdateListener;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Peter A simple interface for the view to talk to the model.
 *
 */
public interface Receiver {
	
	void addMap(String type);

	//not using
	void addObject(String type, String location);

	//obj is name of object, method is actual method (set), param is what goes into method
	void runOnObject(String obj, Method method, Object... params);
	
	void runOnObjectSwap(String obj, Method method, Object... params);
	
	boolean isInvObject(String type);
	
	List<Method> getEditorMethods(String obj);
	
	List<Method> getSpecialEditorMethods(String obj);

	//get version of above //still check for null
	Object getFromObject(String obj, String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException;

	List<NodeButton> getButtonList(String obj);
	
	void removeObject(String obj);

	String getType(String obj);

	Set<String> getList(String type);
									

	void saveFile();

	void exportFile(String game);

	void setListener(String type, UpdateListener ul);

	// type is the name of the editor like the class name
	// obj is the name of the string key
	// params
}
