package gae.view.editorpane.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;

public class EditorComponentFactory {

	public EditorComponent generateComponent(String editorType,
			Receiver receiver, Method setMethod, String objName) {
		if (editorType.equalsIgnoreCase("textfield")) {
			return (new TextFieldEditor(receiver, setMethod, objName));
		} else if (editorType.equalsIgnoreCase("imageselect")) {
			return (new ImageSelector(receiver, setMethod, objName));
		} else if (editorType.equalsIgnoreCase("slider")) {
			return (new SliderEditor(receiver, setMethod, objName));
		} else if (editorType.equalsIgnoreCase("queueeditor")) {
			return (new QueueEditor(receiver, setMethod, objName));
		} else if (editorType.equalsIgnoreCase("multiselect")) {
			return (new MultipleSelectEditor(receiver, setMethod, objName));
		}

		// we should implement a better error handling here.
		throw new RuntimeException(
				"Unable to generate the name editor component type: "
						+ editorType);
	}

}
