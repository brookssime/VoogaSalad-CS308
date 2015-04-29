package gae.view.editorpane.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;

/**
 * Grid Editor
 * Special editor that uses the editor components
 * Editor components used: 
 * 		single selector (for tiles -> path vs nature; for sprites)
 * 		text field (for width and height)
 * 		toggle button (for placing tiles vs sprites)
 * 		queue editor for waves
 * 		
 * Make the editor component nodes be added to the grid instead of the editor pane
 * @author ReyinaSenatus
 *
 */


//TODO: set up queue editor for waves
//TODO: Make grid fit in scene
//TODO: Implement with editor components
//TODO: Return the correct info
//TODO: Change content of each tab to sprite or tile
public class GridEditor extends EditorComponent{
	
	public GridEditor(Receiver receiver, Method method, String objectName) {
		super(receiver, method, objectName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUpEditor() {
		// TODO Auto-generated method stub
		
	}

}
