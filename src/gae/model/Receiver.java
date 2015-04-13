package gae.model;

import gae.inventorypane.UpdateListener;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public interface Receiver {
	
	public void addObject(String type);
	public void updateObject(String type, String obj, List<Object> params);
	public void removeObject(String type, String obj);
	public void editObject(String type, String obj);
	public Set<String> getList(String type);
	public void saveFile();
	public void exportFile(String game);
	public void setListener(String type, UpdateListener ul);
	public ArrayList<String> getElements(String type);

	//type is the name of the editor like the class name
	//obj is the name of the string key
	//params
}
