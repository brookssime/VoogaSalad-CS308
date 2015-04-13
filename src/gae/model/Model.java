package gae.model;

import gae.inventory.Inventory;
import gae.inventorypane.UpdateListener;
import interfaces.Authorable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Not yet implemented
 * @author Peter
 */
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
		myInventory.updateObject(type, obj, params);
	}

	@Override
	public void editObject(String type, String obj) {
		// TODO Auto-generated method stub
		Authorable curItem = myInventory.getObject(type, obj);
		
		
	}
	
	@Override
	public void removeObject(String type, String obj) {
		myInventory.removeObject(type, obj);
	}
	
	@Override
	public Set<String> getList(String type) {
		return myInventory.getList(type);
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
	public void setListener(String type, UpdateListener ul) {
		// TODO Auto-generated method stub
		myInventory.setListener(type, ul);
	}

	@Override
	public ArrayList<String> getElements(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
