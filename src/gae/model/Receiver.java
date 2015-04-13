package gae.model;

import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import java.util.ArrayList;

import engine.Game;

/**
 * 
 * @author sunjeevdevulapalli
 * A simple interface for the view to talk to the model.
 *
 */
public interface Receiver {
	
	public void addObject(String type);
	public void updateObject(String type, String obj, List<Object> params);
	public void editObject(String type, String obj);
	public void saveFile();
	public void exportFile(String game);
	public void setBind(String type, ObjectProperty<ObservableList<String>> prop);
	public ArrayList<String> getElements(String type);

	//type is the name of the editor like the class name
	//obj is the name of the string key
	//params
}
