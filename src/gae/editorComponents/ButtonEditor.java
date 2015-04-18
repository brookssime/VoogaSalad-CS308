package gae.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;

import javafx.scene.Parent;

public class ButtonEditor extends EditorComponent{

	public ButtonEditor(Receiver receiver, Method method, String classname, String objectName) {
		super(receiver, method, classname, objectName);
	}

	@Override
	public void setUpEditor() {
		this.getChildren().add(buttonEditor());
	}

	private Parent buttonEditor() {
		
		return null;
	}

}
