package gae.model;

import gae.view.inventorypane.UpdateListener;

import java.lang.reflect.Method;
import java.util.Set;


/**
 * 
 * @author Peter
 * A simple interface for the view to talk to the model.
 *
 */
public interface Receiver {
	
	public void addObject(String type);
	public void runOnObject(String obj, Method method, Object...params);
	public Object getFromObject(String obj, Method method, Object...params);
	public void removeObject(String obj);
 	public Set<String> getList(String type);//once peter figures how to do this, we will change it. 
	public void saveFile();
	public void exportFile(String game);
	public void setListener(String type, UpdateListener ul);

	//type is the name of the editor like the class name
	//obj is the name of the string key
	//params
}
