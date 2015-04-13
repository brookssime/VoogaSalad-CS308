/*
 * 
 */
package gae;

import gae.editorpane.BaseEditor;
import gae.editorpane.DialogueSceneEditor;
import gae.editorpane.GameEditor;
import gae.editorpane.GridEditor;
import gae.editorpane.TitleScreenEditor;
import gae.inventorypane.InventoryPane;
import gae.menupane.MenuAdder;
import gae.menupane.MenuManager;
import gae.menupane.MenuPane;
import gae.model.Receiver;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

// TODO: Auto-generated Javadoc
/**
 * The Class Display.
 */
public class Display {

	/** The my root. */
	private BorderPane myRoot;
	
	/** The my receiver. */
	private Receiver myReceiver;
	
	/** The my scene. */
	private Scene myScene;
	
	/** The my menu adder. */
	private MenuAdder myMenuAdder;
	
	/** The my configs. */
	private static ResourceBundle myConfigs = BundleGrabber.grabBundle(
			"configs", "display"); // find way to add this :
									// this.getClass().getName());
	/** The Constant myWidth. */
									private static final int myWidth = Integer.parseInt(myConfigs
			.getString("Width"));
	
	/** The Constant myHeight. */
	private static final int myHeight = Integer.parseInt(myConfigs
			.getString("Height"));

	/**
	 * Instantiates a new display.
	 *
	 * @param rec the rec
	 */
	public Display(Receiver rec) {
		myRoot = new BorderPane();
		myReceiver = rec;
	}

	/**
	 * Inits the.
	 *
	 * @return the scene
	 */
	public Scene init() {
		myRoot.setTop(setupMenuPane());
		myRoot.setCenter(setupEditorPane());
		myRoot.setLeft(setupInventoryPane());
		myRoot.setBottom(setupTimelinePane());
		myScene = new Scene(myRoot, myWidth, myHeight);
		return myScene;
	}

	/**
	 * Setup menu pane.
	 *
	 * @return the pane
	 */
	private Pane setupMenuPane() {
		MenuManager menuManager = new MenuManager();
		myMenuAdder = (MenuAdder) menuManager;
		MenuPane menuPane = new MenuPane(myMenuAdder, menuManager.getMenuBar());
		return menuPane.getPane();
	}

	/**
	 * Setup editor pane.
	 *
	 * @return the pane
	 */
	private Pane setupEditorPane() {
		BaseEditor e = new BaseEditor(myMenuAdder);
//		DialogueSceneEditor e = new DialogueSceneEditor(myMenuAdder);
//		TitleScreenEditor e = new TitleScreenEditor(myMenuAdder);
//		GameEditor e = new GameEditor(myMenuAdder);
		//return e.getPane();
		return (new GridEditor());
	}

	/**
	 * Setup inventory pane.
	 *
	 * @return the pane
	 */
	private Pane setupInventoryPane() {
		InventoryPane inventoryPane = new InventoryPane(myMenuAdder, myReceiver);
		return inventoryPane.getPane();
	}
	
	/**
	 * Setup timeline pane.
	 *
	 * @return the pane
	 */
	private Pane setupTimelinePane() {
		// TODO Auto-generated method stub
		return null;
	}

}
