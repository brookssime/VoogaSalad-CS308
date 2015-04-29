package gae.view.gridEditor;

import gae.view.editorpane.ComponentsDialog;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TestSingleSelect {
	Button open;
	HBox root;

	public void setUpEditor(){
		root = new HBox(5);
		//Label selectText = new Label("Select Object");
		open = new Button("X");
		open.setOnAction(e -> {
			TestDialog dialog = new TestDialog("type");
			String ret = dialog.getElement();
			open.setText(ret);
			//myReceiver.runOnObjectSwap(myObject, myMethod, ret);
		});
		
		root.getChildren().addAll(open);
	}
	
	public Node root(){
		return root;
	}
	
}
