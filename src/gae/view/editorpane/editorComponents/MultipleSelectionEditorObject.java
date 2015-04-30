package gae.view.editorpane.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;
import java.util.List;

public class MultipleSelectionEditorObject extends MultipleSelectEditor{

	public MultipleSelectionEditorObject(Receiver receiver, Method setMethod,
			String objectName) {
		super(receiver, setMethod, objectName);
	}

	@Override
	protected void sendToInventory(List<String> list) {
		for(String s : list){
			myReceiver.runOnObjectSwap(myObject, myMethod, s);
		}
		
	}

}
