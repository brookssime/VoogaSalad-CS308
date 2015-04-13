package gae.editorpane;

import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import gae.GAEPane;
import gae.menupane.MenuAdder;

public class EditorPane extends GAEPane {
	
	private TabPane myTabs;

	public EditorPane(MenuAdder adder) {
		super(EditorPane.class.getName(), adder);
	}
	
	public void setEditors(GAEPane editor) {
		myRoot.getChildren().add(editor.getPane());

	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
