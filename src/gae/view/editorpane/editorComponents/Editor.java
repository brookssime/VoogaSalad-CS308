package gae.view.editorpane.editorComponents;

import interfaces.MethodAnnotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;





import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import gae.model.Receiver;
import gae.view.GAEPane;
import gae.view.editorpane.EditorAdder;
import gae.view.menupane.MenuAdder;

public class Editor extends GAEPane {
	/**
	 * @author Negatu
	 * 
	 *         an editor window that creates different editor components based
	 *         on the classname passed to it.
	 * 
	 * @param classname
	 *            - the class name of the object to be instantiated.
	 */

	private VBox myForm;
	private ScrollPane myLayout;
	private BorderPane myPane;
	private EditorComponentFactory myFactory;
	private Receiver myReceiver;
	private EditorAdder myEditorAdder;
	
	private int default_width = 900;
	private int default_height = 700;

	private String myObj;

	public Editor(MenuAdder adder, Receiver receiver, String obj, EditorAdder ea) {
		super(Editor.class.getSimpleName(), adder);
		myObj = obj;
		myReceiver = receiver;
		myEditorAdder = ea;

		List<Method> objMethods = new ArrayList<Method>(myReceiver.getEditorMethods(obj));


		myForm = new VBox();
		myLayout = new ScrollPane(myForm);
		myPane = new BorderPane();
		myPane.setPrefSize(default_width, default_height);
		myLayout.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myPane.setCenter(myLayout);
		myRoot.getChildren().add(myPane);

		myFactory = new EditorComponentFactory();
		for (Method method : objMethods) {
			MethodAnnotation methodAnnotation = method
					.getAnnotation(MethodAnnotation.class);
			String componentType = methodAnnotation.type();
			EditorComponent fieldEditor = myFactory.generateComponent(
					componentType, myReceiver, method, myObj, myEditorAdder);
			myForm.getChildren().add(fieldEditor);
		}

	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
