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
	
	public void addMap(String type);

	//not using
	public void addObject(String type, String location);

	//obj is name of object, method is actual method (set), param is what goes into method
	public void runOnObject(String obj, Method method, Object... params);
	
	public void runOnObjectSwap(String obj, Method method, Object... params);
	
	public boolean isInvObject(String type);
	
	public List<Method> getEditorMethods(String obj);
	
	public List<Method> getSpecialEditorMethods(String obj);

	//get version of above //still check for null
	public Object getFromObject(String obj, String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException;

	public List<NodeButton> getButtonList(String obj);
	
	public void removeObject(String obj);

	public String getType(String obj);

	public Set<String> getList(String type);
									

	public void saveFile();

	public void exportFile(String game);

	public void setListener(String type, UpdateListener ul);

	// type is the name of the editor like the class name
	// obj is the name of the string key
	// params
}
