/*
 * 
 */
package gae.view.editorpane;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import gae.editorComponents.Editor;
import gae.model.Receiver;
import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;


// TODO: Auto-generated Javadoc
/**
 * The Class EditorPane.
 * @author Peter
 * EditorPane superclass for other editors to extend. This class was not used yet. 
 *
 */
public class EditorPane extends GAEPane {
	
	/** The my tabs. */
	private TabPane myTabs;
	private Receiver myReceiver;

	/**
	 * Instantiates a new editor pane.
	 *
	 * @param adder the adder
	 */
	public EditorPane(MenuAdder adder, Receiver receiver) {
		super(EditorPane.class.getSimpleName(), adder);
		myTabs = new TabPane();
		myRoot.getChildren().add(myTabs);
		myReceiver = receiver;
		
		//Testing tabs.
		Editor editor = new Editor(myMenuAdder, myReceiver, "engine.ExampleEnemy");
		Tab newTab = new Tab("Peter");
		newTab.setContent(editor.getPane());
		myTabs.getTabs().add(newTab);
	}
	
	public void addEditor(Node editor) {
		Tab newTab = new Tab();
		newTab.setContent(editor);
	}

	/* (non-Javadoc)
	 * @see gae.menupane.Menuable#getMenus()
	 */
	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
