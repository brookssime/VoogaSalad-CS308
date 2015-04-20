package gae.editorComponents;

import interfaces.MethodAnnotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import reflection.Reflection;
import gae.model.Receiver;
import gae.view.GAEPane;
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

	private HBox myLayout;
	private Group myView;
	private VBox myForm;
	private Button exportObject;
	private EditorComponentFactory myFactory;
	private Receiver myReceiver;

	private String myObj;

	public Editor(MenuAdder adder, Receiver receiver, String obj) {
		super(Editor.class.getSimpleName(), adder);
		myObj = obj;
		myReceiver = receiver;

		ArrayList<Method> objMethods = new ArrayList<Method>(
				Reflection.getEditorMethods("engine." + myReceiver.getType(obj)));
		System.out.println(objMethods);

		ArrayList<Method> setMethods = new ArrayList<Method>();
		ArrayList<Method> getMethods = new ArrayList<Method>();

		for (Method method : objMethods) {
			MethodAnnotation ma = method
					.getAnnotation(MethodAnnotation.class);
			if (ma.gsType().equals("setter")) {
				setMethods.add(method);
			} else {
				if (ma.gsType().equals("getter")) {
					getMethods.add(method);
				}
			}
		}

		myLayout = new HBox();
		myView = new Group();
		myForm = new VBox();
		myLayout.getChildren().addAll(myView, myForm);
		myRoot.getChildren().add(myLayout);

		myFactory = new EditorComponentFactory();
		for (Method method : setMethods) {
			MethodAnnotation methodAnnotation = method
					.getAnnotation(MethodAnnotation.class);
			String componentType = methodAnnotation.type();
			EditorComponent fieldEditor = myFactory.generateComponent(
					componentType, myReceiver, method, myObj);
			myForm.getChildren().add(fieldEditor);
		}

		exportObject = new Button("Export Object");
		exportObject.setOnAction(e -> {
			// udpate/export object missing in receiver?.

			});
		myForm.getChildren().add(exportObject);
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
