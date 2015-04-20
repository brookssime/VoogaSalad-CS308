/*
 * 
 */
package gae.view;

import gae.BundleGrabber;
import gae.view.menupane.MenuAdder;
import gae.view.menupane.Menuable;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

import javafx.scene.layout.Pane;

// TODO: Auto-generated Javadoc
/**
 * The Class GAEPane. ======= /**
 * 
 * @author Peter The main Pane class that all panes extend. It creates a pane in
 *         myRoot and also allows panes to add methods to the menu using the
 *         Menuable interface.
 *
 */
public abstract class GAEPane implements Menuable {

	/** The my root. */
	protected Pane myRoot;

	/** The my menu adder. */
	protected MenuAdder myMenuAdder;

	/** The my configs. */
	private final ResourceBundle myConfigs;

	/**
	 * Instantiates a new GAE pane.
	 *
	 * @param className
	 *            the class name
	 * @param adder
	 *            the adder
	 */
	public GAEPane(String className, MenuAdder adder) {
		myMenuAdder = adder;
		myConfigs = BundleGrabber.grabBundle("configs", className);
		if (myConfigs.containsKey("Root_Type")) {
			try {
				setRoot(Class.forName(myConfigs.getString("Root_Type")));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				setRoot(Class.forName("javafx.scene.layout.Pane"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		myMenuAdder.addMenus(getMenus());
	}

	/**
	 * Sets the root.
	 *
	 * @param type
	 *            the new root
	 */
	private void setRoot(Class<?> type) {
		try {
			myRoot = (Pane) type.getConstructor((Class<?>[]) null).newInstance(
					(Object[]) null);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the pane.
	 *
	 * @return the pane
	 */
	public Pane getPane() {
		return myRoot;
	}

}
