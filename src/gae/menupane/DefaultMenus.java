package gae.menupane;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

/**
 * 
 * @author Peter
 * Creates the default menus in the menubar.
 *
 */
public class DefaultMenus implements Menuable {

	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = new ArrayList<Menu>();
		
		//setup File menu
		Menu menuFile = new Menu("File");
		MenuItem exitMenuItem = new MenuItem("Exit");
		exitMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+W"));
		exitMenuItem.setOnAction(e -> exit());
		menuFile.getItems().addAll(exitMenuItem);
		menus.add(menuFile);
		
		//setup Edit menu
		Menu menuEdit = new Menu("Edit");
		MenuItem undoMenuItem = new MenuItem("Undo");
		undoMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+Z"));
		undoMenuItem.setOnAction(e -> undo());
		MenuItem redoMenuItem = new MenuItem("Redo");
		redoMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+shift+Z"));
		redoMenuItem.setOnAction(e -> redo());
		menuEdit.getItems().addAll(undoMenuItem, redoMenuItem);
		menus.add(menuEdit);
		
		//setup Window menu
		Menu menuWindow = new Menu("Window");
		menus.add(menuWindow);
		
		//setup Help menu
		Menu menuHelp = new Menu("Help");
		MenuItem showHelpMenuItem = new MenuItem("Show Help");
		showHelpMenuItem.setOnAction(e -> showHelp());
		menuHelp.getItems().add(showHelpMenuItem);
		menus.add(menuHelp);
		
		return menus;
	}
	
	private void exit() {
		System.exit(0);
	}
	
	private void undo() {
		System.out.println("Not Implemented");
	}
	
	private void redo() {
		System.out.println("Not Implemented");		
	}
	
	private void showHelp() {
		File htmlFile = new File("help.html");
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (java.io.IOException e) {
			System.out.println("error caught");
			try {
				Desktop.getDesktop().open(htmlFile);
			} catch (java.io.IOException e1) {
				System.out.println("really caught");
			}
		}
	}

}
