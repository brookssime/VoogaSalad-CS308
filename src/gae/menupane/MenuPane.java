package gae.menupane;

import gae.GAEPane;

import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

/**
 * 
 * @author Peter
 * Adds the MenuBar to the pane.
 *
 */
public class MenuPane extends GAEPane {

	public MenuPane(MenuAdder adder, MenuBar mb) {
		super(MenuPane.class.getSimpleName(), adder);
		myRoot.getChildren().add(mb);
	}

	@Override
	public List<Menu> getMenus() {
		return null;
	}

}
