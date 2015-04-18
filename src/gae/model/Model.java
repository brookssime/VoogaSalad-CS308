package gae.model;

import gae.model.inventory.Inventory;
import gae.view.inventorypane.UpdateListener;
import interfaces.Authorable;

import java.lang.reflect.Method;
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
		myInventory.addObject(type);
	}

	@Override
	public void runOnObject(String type, String obj, Method method, Object...params) {
		myInventory.runOnObject(type, obj, method, params);
	}

	@Override
	public void editObject(String type, String obj) {
		Authorable curItem = myInventory.getObject(type, obj);
		//TODO: make correct editor show up
		
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

	//might not be used
	@Override
	public void setListener(String type, UpdateListener ul) {
		myInventory.setListener(type, ul);
	}
	
	//We need a way of getting every instances of one kind (all created towers for example)

}
