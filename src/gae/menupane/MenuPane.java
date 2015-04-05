package gae.menupane;

import gae.GAEPane;

import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuPane extends GAEPane {

	public MenuPane(MenuAdder adder, MenuBar mb) {
		super(MenuPane.class.getName(), adder);
		myRoot.getChildren().add(mb);
	}

	@Override
	public List<Menu> getMenus() {
		return null;
	}

}
