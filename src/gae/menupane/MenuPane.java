/*
 * 
 */
package gae.menupane;

import gae.GAEPane;

import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;


// TODO: Auto-generated Javadoc
/**
 * The Class MenuPane.

 * 
 * @author Peter
 * Adds the MenuBar to the pane.
 *
 */
public class MenuPane extends GAEPane {

	/**
	 * Instantiates a new menu pane.
	 *
	 * @param adder the adder
	 * @param mb the mb
	 */
	public MenuPane(MenuAdder adder, MenuBar mb) {
		super(MenuPane.class.getSimpleName(), adder);
		myRoot.getChildren().add(mb);
	}

	/* (non-Javadoc)
	 * @see gae.menupane.Menuable#getMenus()
	 */
	@Override
	public List<Menu> getMenus() {
		return null;
	}

}
