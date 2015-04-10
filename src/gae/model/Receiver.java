package gae.model;

import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import engine.Game;

public interface Receiver {
	
	public void addObject(String type);
	public void updateObject(String type, String obj, List<Object> params);
	public void editObject(String type, String obj);
	public void saveFile();
	public void exportFile(String game);
	public void setBind(String type, ObjectProperty<ObservableList<String>> prop);

}
