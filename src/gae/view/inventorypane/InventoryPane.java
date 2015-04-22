package gae.view.inventorypane;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import gae.model.Receiver;
import gae.view.GAEPane;
import gae.view.editorpane.EditorPane;
import gae.view.menupane.MenuAdder;

/**
 * 
 * @author Peter Displays the items in the inventory to the user in an
 *         easy-to-read way.
 *
 */
public class InventoryPane extends GAEPane {

	private static final String[] TYPES = { "Game", "LevelScene",
			"DialogueScene", "TitleScene", "Base", "Projectile", "Grid",
			"Wave", "Port", "Enemy", "Tower", "Tile", "Effect", "Range",
			"Store" };
	private Accordion myAccordion;
	private Receiver myReceiver;
	private EditorPane myEditor;

	public InventoryPane(MenuAdder adder, Receiver rec, EditorPane ep) {
		super(InventoryPane.class.getSimpleName(), adder);
		myAccordion = new Accordion();
		myReceiver = rec;
		myEditor = ep;
		for (String type : TYPES) {
			myAccordion.getPanes().add(makePane(type));
		}
		myRoot.getChildren().add(myAccordion);
	}

	private TitledPane makePane(String type) {
		TitledPane pane = new TitledPane();
		pane.setText(type);
		ObservableList<String> theList = FXCollections.observableArrayList();
		ListView<String> list = new ListView<String>(theList);
		UpdateListener ul = new UpdateListener(list);
		myReceiver.setListener(type, ul);
		VBox mainbox = new VBox();
		HBox buttonBox = new HBox();
		Button addButton = makeAdd(type, list);
		Button editButton = makeEdit(type, list);
		Button removeButton = makeRemove(type, list);
		buttonBox.getChildren().addAll(addButton, editButton, removeButton);
		mainbox.getChildren().addAll(buttonBox, list);
		pane.setContent(mainbox);
		return pane;
	}

	private Button makeAdd(String type, ListView<String> list) {
		Button button = new Button("Add");
		button.setOnMouseClicked(e -> {
			myReceiver.addObject(type);
		});
		return button;
	}

	private Button makeEdit(String type, ListView<String> list) {
		Button button = new Button("Edit");
		button.setOnMouseClicked(e -> {
			if (list.getSelectionModel().getSelectedItem() != null) {
				myEditor.addEditor(list.getSelectionModel().getSelectedItem());
			}
		});
		return button;
	}

	private Button makeRemove(String type, ListView<String> list) {
		Button button = new Button("Remove");
		button.setOnMouseClicked(e -> {
			if (list.getSelectionModel().getSelectedItem() != null) {
				myReceiver.removeObject(list.getSelectionModel()
						.getSelectedItem());
			}
		});
		return button;
	}

	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = new ArrayList<Menu>();

		Menu menuInventory = new Menu("New...");

		for (String type : TYPES) {
			MenuItem newMenuItem = new MenuItem("New " + type);
			newMenuItem.setOnAction(e -> {
				myReceiver.addObject(type);
			});
			menuInventory.getItems().add(newMenuItem);
		}

		menus.add(menuInventory);

		return menus;
	}

}
