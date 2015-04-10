package gae.model;

import gae.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;

public class Model implements Receiver {
	
	Inventory myInventory;
	
	public Model() {
		
		myInventory = new Inventory();
		
	}

	@Override
	public void addObject(String type) {
		// TODO Auto-generated method stub
		myInventory.addObject(type);
	}

	@Override
	public void updateObject(String type, String obj, List<Object> params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editObject(String type, String obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportFile(String game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBind(String type, ObjectProperty<ObservableList<String>> prop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getElements(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
