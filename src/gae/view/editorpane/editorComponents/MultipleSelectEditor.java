package gae.view.editorpane.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 
 * @author sunjeevdevulapalli
 * 
 *         Used the following resource as a template, especially for GameObject:
 *         https
 *         ://code.google.com/p/javafx-demos/source/browse/trunk/javafx-demos
 *         /src/main/
 *         java/com/ezest/javafx/demogallery/listview/CheckBoxListCellDemo
 *         .java?r=96
 *
 */
public class MultipleSelectEditor extends EditorComponent{

	public MultipleSelectEditor(Receiver receiver, Method setMethod,
			String objectName) {
		super(receiver, setMethod, objectName);
	}

	@Override
	public void setUpEditor() {
		//Steps:
		//1) need to get parameters -> objects of type...but what type...? []
		//2) then need to construct UI [DONE]
		//3) then set UI with getFromObject method [DONE]
		//4) then create button to update inventory [DONE]
		
		Button btn = new Button("Select Access");
//		this.getChildren().add(btn);
		btn.setOnAction(e -> {
			Stage stage = new Stage();
			stage.setScene(new Scene(makeScene()));
			stage.show();
		});
	}

	@SuppressWarnings("unchecked")
	private Parent makeScene() {
		ObservableList<GameObject> data = FXCollections.observableArrayList();
		ArrayList<Integer> list = null;
		try{
			//list = ((ArrayList<Integer>) myReceiver.getFromObject(myObject, myGetMethod, (Object[]) null));
		} catch (Exception e) {
			System.err.println("Cannot convert Object to ArrayList");
			e.printStackTrace();
		}
		
		//get list
		//use annotation to get type
		//use fetched value to populate list
		for (int i = 0; i < 20; i++) {
			data.add(new GameObject(list.contains(i) ? true : false, "Access ID: "
					+ i));
		}

		final ListView<GameObject> listView = new ListView<GameObject>();
		listView.setPrefSize(200, 250);
		listView.setEditable(true);
		listView.setItems(data);
		

		Callback<GameObject, ObservableValue<Boolean>> getProperty = new Callback<GameObject, ObservableValue<Boolean>>() {
			@Override
			public BooleanProperty call(GameObject layer) {
				return layer.selectedProperty();

			}
		};
		Callback<ListView<GameObject>, ListCell<GameObject>> forListView = CheckBoxListCell
				.forListView(getProperty);
		listView.setCellFactory(forListView);

		StackPane root = new StackPane();
		Button btn = new Button("Accept");

		btn.setOnAction(e -> {
			ArrayList<Integer> accessArray = new ArrayList<>();
			for (GameObject g : data) {
				if(g.getSelected()){
					System.out.println(g.getSelected());
					//Format: "Access ID: i
					try {
						System.out.println(g.getName().split("\\s++")[2]);
						accessArray.add(Integer.parseInt(g.getName().split("\\s++")[2]));
					} catch (IndexOutOfBoundsException e1){
						System.err.println("Cannot find Index");
						e1.printStackTrace();
					}
					
				}
			}
			// update backend inventory
			myReceiver.runOnObject(myObject, myMethod, accessArray);
		});

		VBox vb = new VBox();
		vb.getChildren().addAll(listView, btn);
		root.getChildren().add(vb);
		
		return root;
	}

	
	
	class GameObject {
		private SimpleBooleanProperty selected;
		private SimpleStringProperty name;

		public GameObject(boolean id, String name) {
			this.selected = new SimpleBooleanProperty(id);
			this.name = new SimpleStringProperty(name);
		}

		public boolean getSelected() {
			return selected.get();
		}

		public void setSelected(boolean selected) {
			this.selected.set(selected);
		}

		public String getName() {
			return name.get();
		}

		public void setName(String fName) {
			name.set(fName);
		}

		public SimpleBooleanProperty selectedProperty() {
			return selected;
		}

		@Override
		public String toString() {
			return getName();
		}
	}

}