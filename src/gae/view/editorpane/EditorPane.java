/*
 * 
 */
package gae.view.editorpane;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCombination;
import gae.model.Receiver;
import gae.view.GAEPane;
import gae.view.editorpane.editorComponents.Editor;
import gae.view.menupane.MenuAdder;

/**
 * The Class EditorPane.
 * 
 * @author Peter EditorPane superclass for other editors to extend. This class
 *         was not used yet.
 *
 */
public class EditorPane extends GAEPane implements EditorAdder {

	/** The my tabs. */
	private TabPane myTabs;
	private Receiver myReceiver;

	/**
	 * Instantiates a new editor pane.
	 *
	 * @param adder
	 *            the adder
	 */
	public EditorPane(MenuAdder adder, Receiver receiver) {
		super(EditorPane.class.getSimpleName(), adder);
		myTabs = new TabPane();
		myRoot.getChildren().add(myTabs);
		myReceiver = receiver;

		// if you uncomment below, this example works.

 		// Editor editor = new Editor(myMenuAdder, myReceiver, "Tower");
		// Tab newTab = new Tab("Peter"); newTab.setContent(editor.getPane());
		 //myTabs.getTabs().add(newTab);
	}

	@Override
	public void addEditor(String obj) {
		Tab newTab = new Tab(obj);
		Editor newEditor = new Editor(myMenuAdder, myReceiver, obj, this);
		newTab.setContent(newEditor.getPane());
		myTabs.getTabs().add(newTab);
	}
	
	@Override
	public void closeTab() {
		for (Tab tab : myTabs.getTabs()) {
			if (tab.isSelected()) {
				myTabs.getTabs().remove(tab);
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gae.menupane.Menuable#getMenus()
	 */
	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = new ArrayList<Menu>();

		Menu menuEditor = new Menu("Editor");
		MenuItem closeTabMenuItem = new MenuItem("Close Tab");
		closeTabMenuItem.setOnAction(e -> closeTab());
		closeTabMenuItem.setAccelerator(KeyCombination
				.keyCombination("shortcut+W"));
		menuEditor.getItems().add(closeTabMenuItem);

		menus.add(menuEditor);
		return menus;
	}

}
