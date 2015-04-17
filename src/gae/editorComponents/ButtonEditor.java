package gae.editorComponents;

import java.lang.reflect.Method;

import javafx.scene.Parent;

public class ButtonEditor extends EditorComponent{

	public ButtonEditor(Method method, Object object) {
		super(method, object);
	}

	@Override
	public void setUpEditor() {
		this.getChildren().add(buttonEditor());
	}

	private Parent buttonEditor() {
		
		return null;
	}

}
