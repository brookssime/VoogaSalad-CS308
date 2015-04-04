package gae.menupane;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;

public class MenuManager implements MenuAdder {

	private final MenuBar myMenuBar;

	public MenuManager() {
		myMenuBar = new MenuBar();
		setDefault();
	}

	public MenuBar getMenuBar() {
		return myMenuBar;
	}

	public void addMenus(List<Menu> newMenus) {
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

	private void setDefault() {
		DefaultMenus dm = new DefaultMenus();
		myMenuBar.getMenus().addAll(dm.getMenus());
	}

}
