/*
 * 
 */
package gae.view.menupane;

import gae.model.Receiver;
import gae.view.GAEPane;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuPane.
 * 
 * 
 * @author Peter Adds the MenuBar to the pane.
 *
 */
public class MenuPane extends GAEPane {
	
	private Receiver myReceiver;

	/**
	 * Instantiates a new menu pane.
	 *
	 * @param adder
	 *            the adder
	 * @param mb
	 *            the mb
	 */
	public MenuPane(MenuAdder adder, MenuBar mb, Receiver receiver) {
		super(MenuPane.class.getSimpleName(), adder);
		myReceiver = receiver;
		myRoot.getChildren().add(mb);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gae.menupane.Menuable#getMenus()
	 */
	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = new ArrayList<Menu>();
		Menu fileMenu = new Menu("File");
		MenuItem saveMenuItem = new MenuItem("Save GAE");
		saveMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		saveMenuItem.setOnAction(e -> myReceiver.saveFile());
		
		fileMenu.getItems().add(saveMenuItem);
		
		menus.add(fileMenu);
		
		return menus;
	}

}
