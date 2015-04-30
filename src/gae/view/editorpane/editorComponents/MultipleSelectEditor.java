package gae.view.editorpane.editorComponents;

import gae.model.Receiver;
import interfaces.TypeAnnotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
public abstract class MultipleSelectEditor extends EditorComponent{

	public MultipleSelectEditor(Receiver receiver, Method setMethod,
			String objectName) {
		super(receiver, setMethod, objectName);
	}

	@Override
	public void setUpEditor() {
		
		Button btn = new Button("Select Access");
//		this.getChildren().add(btn);
		btn.setOnAction(e -> {
			Stage stage = new Stage();
			stage.setScene(new Scene(makeScene(stage)));
			stage.show();
		});
		this.getChildren().add(btn);
	}

	@SuppressWarnings("unchecked")
	private Parent makeScene(Stage stage) {
		ObservableList<GameObject> data = FXCollections.observableArrayList();
		
		
		//get list
		//use annotation to get type
		//use fetched value to populate list
		//TODO: figure out how to fetch type from annotation.
		TypeAnnotation typeAnnotation = myMethod
				.getAnnotation(TypeAnnotation.class);
		
		String type = typeAnnotation.type();
		Set<String> list = myReceiver.getList(type);
//		ArrayList<String> myChecked = (ArrayList<String>) myFetchedValue;
			for (String o: list){
				data.add(new GameObject(false, o));
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
			ArrayList<String> accessArray = new ArrayList<>();
			for (GameObject g : data) {
				if(g.getSelected()){
					System.out.println("Name " +g.getName());
					accessArray.add(g.getName());
					System.out.println("Here");
					System.out.println(g.getName());
					//myReceiver.runOnObjectSwap(myObject, myMethod, g.getName());
				}
			}
			// update backend inventory
			sendToInventory(accessArray);
			stage.close();
			
		});

		VBox vb = new VBox();
		vb.getChildren().addAll(listView, btn);
		root.getChildren().add(vb);
		
		return root;
	}

	protected abstract void sendToInventory(List<String> list);
	
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