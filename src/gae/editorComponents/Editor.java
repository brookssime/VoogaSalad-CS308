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
	private Button exportObject;
	private EditorComponentFactory myFactory;
	private Receiver myReceiver;
	
	private String myType;
	private String myObj;

	public Editor(MenuAdder adder, Receiver receiver, String type, String obj) {
		super(Editor.class.getSimpleName(), adder);
		myType = type;
		myObj = obj;
		myReceiver = receiver;
		

		ArrayList<Method> objMethods = new ArrayList<Method>(
				Reflection.getEditorMethods("engine."+myType));
		System.out.println(objMethods);

		myLayout = new HBox();
		myView = new Group();
		myForm = new VBox();
		myLayout.getChildren().addAll(myView, myForm);
		myRoot.getChildren().add(myLayout);
		
		myFactory = new EditorComponentFactory();
		for (Method method : objMethods) {
			MethodAnnoation methodAnnotation = method.getAnnotation(engine.MethodAnnoation.class);
			String componentType = methodAnnotation.type();
			EditorComponent fieldEditor = myFactory.generateComponent(componentType, myReceiver, method, myType, myObj);
			myForm.getChildren().add(fieldEditor);
		}
		
		exportObject = new Button("Export Object");
		exportObject.setOnAction(e -> {
			//udpate/export object missing in receiver?.
			
			
		});
		myForm.getChildren().add(exportObject);
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
