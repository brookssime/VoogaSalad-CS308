package gae;

import gae.menupane.MenuAdder;
import gae.menupane.MenuManager;
import gae.menupane.MenuPane;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

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

	private Node setupMenuPane() {
		MenuManager menuManager = new MenuManager();
		myMenuAdder = (MenuAdder) menuManager;
		MenuPane menuPane = new MenuPane(myMenuAdder, menuManager.getMenuBar());
		return menuPane.getPane();
	}

	private Node setupEditorPane() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node setupResourcePane() {
		ResourcePane resourcePane = new ResourcePane(myMenuAdder);
		return resourcePane.getPane();
	}

	private Node setupTimelinePane() {
		// TODO Auto-generated method stub
		return null;
	}

}