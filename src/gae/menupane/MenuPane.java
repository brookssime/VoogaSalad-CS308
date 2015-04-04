package gae.menupane;

import gae.BundleGrabber;
import gae.GAEPane;

import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuPane extends GAEPane {

	private static final ResourceBundle myConfigs = BundleGrabber.grabBundle(
			"configs", "menupane");

	public MenuPane(MenuAdder adder, MenuBar mb) {
		super(myConfigs.getString("Root_Type"), adder);
		myRoot.getChildren().add(mb);
	}

	@Override
	public List<Menu> getMenus() {
		return null;
	}

}
