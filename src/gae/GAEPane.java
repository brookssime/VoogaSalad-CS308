package gae;

import gae.menupane.MenuAdder;
import gae.menupane.Menuable;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

import javafx.scene.layout.Pane;

/**
 * 
 * @author Peter
 * The main Pane class that all panes extend. It creates a pane in myRoot and also allows panes to 
 * add methods to the menu using the Menuable interface.
 *
 */
public abstract class GAEPane implements Menuable {

	protected Pane myRoot;
	protected MenuAdder myMenuAdder;
	private final ResourceBundle myConfigs;


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
	
	public Pane getPane() {
		return myRoot;
	}

}
