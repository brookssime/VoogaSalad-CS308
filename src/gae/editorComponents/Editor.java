package gae.editorComponents;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import engine.MethodAnnoation;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import reflection.Reflection;
import gae.model.Receiver;
import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;

public class Editor extends GAEPane{
	/**
	 * @author Negatu
	 * 
	 * an editor window that creates different editor components based on the classname passed to it. 
	 * 
	 * @param classname - the class name of the object to be instantiated. 
	 */


	private HBox myLayout;
	private Group myView;
	private VBox myForm;
	private Object myObject;
	private Button exportObject;
	private EditorComponentFactory myFactory;
	private Receiver myReceiver;

	public Editor(MenuAdder adder, Receiver receiver, String type) {
		super(Editor.class.getSimpleName(), adder);
		myReceiver = receiver;
		
		//this needs to happen using the receiver instead once everything on our backend is sorted out.
		myObject = Reflection.createInstance(type);
		ArrayList<Method> objMethods = new ArrayList<Method>(
				Reflection.getEditorMethods(myObject));

		myLayout = new HBox();
		myView = new Group();
		myForm = new VBox();
		myLayout.getChildren().addAll(myView, myForm);
		myRoot.getChildren().add(myLayout);
		
		myFactory = new EditorComponentFactory();
		for (Method method : objMethods) {
			MethodAnnoation methodAnnotation = method.getAnnotation(engine.MethodAnnoation.class);
			String componentType = methodAnnotation.type();
			EditorComponent fieldEditor = myFactory.generateComponent(componentType, method, myObject);
			myForm.getChildren().add(fieldEditor);
		}
		
		exportObject = new Button("Export Object");
		exportObject.setOnAction(e -> {
			//export object to receiver, this is just a sample print method for now.
			myObject.toString();
			
		});
		myForm.getChildren().add(exportObject);
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
