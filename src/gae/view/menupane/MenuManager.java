/*
 * 
 */
package gae.view.menupane;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuManager.
 * 
 * @author Peter
 * Manages the menu. Allows other classes to add menus to the bar and get menus.
 */
public class MenuManager implements MenuAdder {

	/** The my menu bar. */
	private final MenuBar myMenuBar;

	/**
	 * Instantiates a new menu manager.
	 */
	public MenuManager() {
		myMenuBar = new MenuBar();
		setDefault();
	}

	/**
	 * Gets the menu bar.
	 *
	 * @return the menu bar
	 */
	public MenuBar getMenuBar() {
		return myMenuBar;
	}

	/* (non-Javadoc)
	 * @see gae.menupane.MenuAdder#addMenus(java.util.List)
	 */
	public void addMenus(List<Menu> newMenus) {
		if (newMenus != null) {
			ObservableList<Menu> curMenus = myMenuBar.getMenus();
			for (Menu newMenu : newMenus) {
				for (Menu curMenu : curMenus) {
					if (curMenu.getText().equals(newMenu.getText())) {
						curMenu.getItems().add(new SeparatorMenuItem());
						curMenu.getItems().addAll(newMenu.getItems());
					}
				}
				curMenus.add(curMenus.size() - 2, newMenu);
			}
		}
	}

	/**
	 * Sets the default.
	 */
	private void setDefault() {
		DefaultMenus dm = new DefaultMenus();
		myMenuBar.getMenus().addAll(dm.getMenus());
	}

}
