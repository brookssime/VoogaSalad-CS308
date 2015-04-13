package gae.editorpane;

import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import gae.GAEPane;
import gae.menupane.MenuAdder;

/**
 * @author Peter
 * EditorPane superclass for other editors to extend. This class was not used yet. 
 *
 */
public class EditorPane extends GAEPane {
	
	private TabPane myTabs;

	public EditorPane(MenuAdder adder) {
		super(EditorPane.class.getName(), adder);
		myTabs = new TabPane();
		myRoot.getChildren().add(myTabs);
	}
	
	public void setEditors() {
		
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
