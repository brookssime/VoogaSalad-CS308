package gae;

import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Menu;
import gae.menupane.MenuAdder;

public class ResourcePane extends GAEPane {
	
	private static final ResourceBundle myConfigs = BundleGrabber.grabBundle("configs", "resourcepane");

	public ResourcePane(MenuAdder adder) {
		super(myConfigs.getString("Root_Type"), adder);
//		myRoot = new 
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Menu> getMenus() {
		return null;
	}

}
