package gae;

import gae.editorpane.TitleScreenEditor;
import gae.inventory.Inventory;
import gae.menupane.MenuAdder;
import gae.menupane.MenuManager;
import gae.menupane.MenuPane;
import gae.resourcepane.ResourcePane;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Display {

	private BorderPane myRoot;
	private Scene myScene;
	private MenuAdder myMenuAdder;
	private static ResourceBundle myConfigs = BundleGrabber.grabBundle(
			"configs", "display"); // find way to add this :
									// this.getClass().getName());
	private static final int myWidth = Integer.parseInt(myConfigs
			.getString("Width"));
	private static final int myHeight = Integer.parseInt(myConfigs
			.getString("Height"));

	public Display() {
		myRoot = new BorderPane();
	}

	public Scene init() {
		myRoot.setTop(setupMenuPane());
		myRoot.setCenter(setupEditorPane());
		myRoot.setLeft(setupResourcePane());
		myRoot.setBottom(setupTimelinePane());
		myScene = new Scene(myRoot, myWidth, myHeight);
		return myScene;
	}

	private Pane setupMenuPane() {
		MenuManager menuManager = new MenuManager();
		myMenuAdder = (MenuAdder) menuManager;
		MenuPane menuPane = new MenuPane(myMenuAdder, menuManager.getMenuBar());
		return menuPane.getPane();
	}

	private Pane setupEditorPane() {
		TitleScreenEditor tsE = new TitleScreenEditor(myMenuAdder);
		return tsE.getPane();
	}

	private Pane setupResourcePane() {
		ResourcePane resourcePane = new ResourcePane(myMenuAdder, new Inventory());
		return resourcePane.getPane();
	}
	
	private Pane setupTimelinePane() {
		// TODO Auto-generated method stub
		return null;
	}

}
