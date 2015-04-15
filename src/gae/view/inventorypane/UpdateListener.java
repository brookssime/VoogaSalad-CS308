package gae.view.inventorypane;

import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class UpdateListener {
	
	private ListView<String> myList;
	private ObservableList<String> myUpdate;
	
	public UpdateListener(ListView<String> list) {
		myList = list;
	}
	
	public void setUpdate(ObservableList<String> update) {
		myUpdate = update;
	}

	public void run() {
		myList.setItems(myUpdate);
	}

}
