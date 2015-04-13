/*
 * 
 */
package gae.editorpane;

import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import gae.GAEPane;
import gae.menupane.MenuAdder;


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

	/**
	 * Instantiates a new editor pane.
	 *
	 * @param adder the adder
	 */
	public EditorPane(MenuAdder adder) {
		super(EditorPane.class.getName(), adder);
	}
	
	public void setEditors(GAEPane editor) {
		myRoot.getChildren().add(editor.getPane());


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
