package gae.editorpane;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ListField extends HBox{
	private Button myAdder;
	private ArrayList<String> myList;
	
	public ListField(String name){
		myList = new ArrayList<String>();
		myAdder = new Button("Add "+name);
		myAdder.setOnAction(e->{
			ComponentsDialog mydialog = new ComponentsDialog(name);
			String elementName = mydialog.getElement();
			if (elementName!= null){
				addLabel(elementName);
			}
		});
		getChildren().add(myAdder);
	}
	
	private void addLabel(String elementName){
		myList.add(elementName);
		this.getChildren().add(new Label(elementName));
	}

	public ArrayList<String> getList(){
		return myList;
	}
}
