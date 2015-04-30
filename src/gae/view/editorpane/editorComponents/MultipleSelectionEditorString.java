package gae.view.editorpane.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;
import java.util.List;

public class MultipleSelectionEditorString extends MultipleSelectEditor{

	public MultipleSelectionEditorString(Receiver receiver, Method setMethod,
			String objectName) {
		super(receiver, setMethod, objectName);
	}

	@Override
	protected void sendToInventory(List<String> list) {
		myReceiver.runOnObject(myObject, myMethod, list);
		
	}

}
