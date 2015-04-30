package gae.view.editorpane.editorComponents;

import gae.model.Receiver;
import gae.view.gameEditor.GameEditor;
import gae.view.gridEditor.GridEditor;
import gae.view.titleScreenEditor.TitleScreenEditor;

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
		} else if (editorType.equalsIgnoreCase("gameeditor")){
			return (new GameEditor(receiver, setMethod, objName));
		} else if (editorType.equalsIgnoreCase("grid")){
			return (new GridEditor(receiver, setMethod, objName));
		} else if (editorType.equalsIgnoreCase("titlescene")){
			return (new TitleScreenEditor(receiver, setMethod, objName));
		} else if (editorType.equalsIgnoreCase("multiselect")) {
			return (new MultipleSelectionEditorString(receiver, setMethod, objName));
		} else if(editorType.equalsIgnoreCase("multiselectobject")) {
			return (new MultipleSelectionEditorObject(receiver, setMethod, objName));
		}else if (editorType.equalsIgnoreCase("singleselect")){
			return (new SingleSelectionEditor(receiver, setMethod, objName));
		}

		// we should implement a better error handling here.
		throw new RuntimeException(
				"Unable to generate the name editor component type: "
						+ editorType);
	}

}
