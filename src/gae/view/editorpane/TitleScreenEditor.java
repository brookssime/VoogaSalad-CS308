package gae.view.editorpane;

import gae.BundleGrabber;
import gae.editorComponents.EditorComponent;
import gae.model.Receiver;
import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import reflection.Reflection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author sunjeevdevulapalli
 * Allows the user to edit the title screen editor. 
 *
 */
public class TitleScreenEditor extends EditorPane{
	
	private static final int VBOX_PADDING = 25;
	private static final int VBOX_SPACING = 10;
	private final ResourceBundle myConfigs;

	public TitleScreenEditor(MenuAdder adder, Receiver receiver) {
		super(adder, receiver);
		myConfigs = BundleGrabber.grabBundle("configs", TitleScreenEditor.class.getSimpleName());
		myRoot.getChildren().add(setRootProperties(receiver));
	}
	
	private VBox setRootProperties(Receiver receiver){
		VBox titleScreenComponents = new VBox(VBOX_SPACING);
		titleScreenComponents.setPadding(new Insets(VBOX_PADDING));	
		String className = "engine.TitleScene";
		Object myObject = Reflection.createInstance(className);
		ArrayList<Method> objMethods = new ArrayList<Method>(
				Reflection.getEditorMethods(myObject.getClass().toString()));
		
		for(Method method : objMethods){
			titleScreenComponents.getChildren().add(getComponent(method, myObject, receiver));
		}
		
		return null;
	}

	private EditorComponent getComponent(Method method, Object myObject, Receiver receiver) {
		// 1) determine which editor component we're dealing with
		// 2) construct new editor component and pass it the receiver
		// 3) return the editor component
		return null;
	}


}
