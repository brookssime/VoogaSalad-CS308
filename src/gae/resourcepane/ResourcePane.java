package gae.resourcepane;

import java.util.List;

import javafx.scene.control.Menu;
import gae.GAEPane;
import gae.menupane.MenuAdder;

public class ResourcePane extends GAEPane {
		
	public ResourcePane(MenuAdder adder) {
		super(ResourcePane.class.getName(), adder);
	}

	@Override
	public List<Menu> getMenus() {
		return null;
	}

}
