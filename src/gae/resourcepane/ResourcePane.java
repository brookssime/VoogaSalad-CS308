package gae.resourcepane;

import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.TreeView;
import gae.GAEPane;
import gae.menupane.MenuAdder;

public class ResourcePane extends GAEPane {
	
	private TreeView<String> myTreeView;
		
	public ResourcePane(MenuAdder adder) {
		super(ResourcePane.class.getSimpleName(), adder);
	}

	@Override
	public List<Menu> getMenus() {
		return null;
	}

}
