package gae.inventorypane;

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
import gae.GAEPane;
import gae.menupane.MenuAdder;
import gae.model.Receiver;

public class InventoryPane extends GAEPane {

	private static final String[] TYPES = { "Game", "LevelScene",
		"DialogueScene", "TitleScene", "Base", "Projectile", "Grid",
		"Wave", "Port", "Enemy", "Tower", "Tile", "Effect", "Range",
	"Store" };
	private Accordion myAccordion;
	private Receiver myReceiver;

	public InventoryPane(MenuAdder adder, Receiver rec) {
		super(InventoryPane.class.getSimpleName(), adder);
		myAccordion = new Accordion();
		myReceiver = rec;
		for (String type : TYPES) {
			myAccordion.getPanes().add(makePane(type));
		}
		myRoot.getChildren().add(myAccordion);
	}

	private TitledPane makePane(String type) {
		TitledPane pane = new TitledPane();
		pane.setText(type);
		ObservableList<String> theList= FXCollections.observableArrayList(myReceiver.getList(type));
		ListView<String> list = new ListView<String>(theList);
		UpdateListener ul = new UpdateListener(list);
		myReceiver.setListener(type, ul);
		VBox mainbox = new VBox();
		HBox buttonBox = new HBox();
		Button addButton = makeAdd(type, list);
		Button editButton = makeEdit(type, list);
		Button removeButton = makeRemove(type, list);
		buttonBox.getChildren().addAll(addButton, editButton, removeButton);
		//		list.setPrefHeight(0);
		//		VBox.setVgrow(list, Priority.ALWAYS);
		mainbox.getChildren().addAll(buttonBox, list);
		pane.setContent(mainbox);
		return pane;
	}

	private Button makeAdd(String type, ListView<String> list) {
		Button button = new Button("Add");
		button.setOnMouseClicked(e -> {
			myReceiver.addObject(type);
			list.setItems(FXCollections.observableArrayList(myReceiver.getList(type)));
		});
		return button;
	}

	private Button makeEdit(String type, ListView<String> list) {
		Button button = new Button("Edit");
		button.setOnMouseClicked(e -> {
			if (list.getSelectionModel().getSelectedItem() != null) {
				myReceiver.editObject(type, list.getSelectionModel().getSelectedItem());
				System.out.println(list.getSelectionModel().getSelectedItem());
				list.setItems(FXCollections.observableArrayList(myReceiver.getList(type)));
			}
		});
		return button;
	}

	private Button makeRemove(String type, ListView<String> list) {
		Button button = new Button("Remove");
		button.setOnMouseClicked(e -> {
			if (list.getSelectionModel().getSelectedItem() != null) {

				myReceiver.removeObject(type, list.getSelectionModel().getSelectedItem());
				list.setItems(FXCollections.observableArrayList(myReceiver.getList(type)));
			}
		});
		return button;
	}

	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = new ArrayList<Menu>();

		Menu menuInventory = new Menu("Inventory");
		MenuItem newGameMenuItem = new MenuItem("New Game");
		newGameMenuItem.setOnAction(e -> myReceiver.addObject("Game"));
		MenuItem newLevelSceneMenuItem = new MenuItem("New Level Scene");
		newLevelSceneMenuItem.setOnAction(e -> myReceiver
				.addObject("LevelScene"));
		MenuItem newDialogueSceneMenuItem = new MenuItem("New Dialogue Scene");
		newDialogueSceneMenuItem.setOnAction(e -> myReceiver
				.addObject("DialogueScene"));
		MenuItem newTitleSceneMenuItem = new MenuItem("New Title Scene");
		newTitleSceneMenuItem.setOnAction(e -> myReceiver
				.addObject("TitleScene"));
		MenuItem newEnemyMenuItem = new MenuItem("New Enemy");
		newEnemyMenuItem.setOnAction(e -> myReceiver.addObject("Enemy"));
		MenuItem newTowerMenuItem = new MenuItem("New Tower");
		newTowerMenuItem.setOnAction(e -> myReceiver.addObject("Tower"));
		MenuItem newBaseMenuItem = new MenuItem("New Base");
		newBaseMenuItem.setOnAction(e -> myReceiver.addObject("Base"));
		MenuItem newTileMenuItem = new MenuItem("New Tile");
		newTileMenuItem.setOnAction(e -> myReceiver.addObject("Tile"));
		MenuItem newProjectileMenuItem = new MenuItem("New Projectile");
		newProjectileMenuItem.setOnAction(e -> myReceiver
				.addObject("Projectile"));
		MenuItem newGridMenuItem = new MenuItem("New Grid");
		newGridMenuItem.setOnAction(e -> myReceiver.addObject("Grid"));
		MenuItem newWaveMenuItem = new MenuItem("New Port");
		newWaveMenuItem.setOnAction(e -> myReceiver.addObject("Port"));
		menuInventory.getItems().addAll(newGameMenuItem, newLevelSceneMenuItem,
				newDialogueSceneMenuItem, newTitleSceneMenuItem,
				newEnemyMenuItem, newTowerMenuItem, newBaseMenuItem,
				newTileMenuItem, newProjectileMenuItem, newGridMenuItem,
				newWaveMenuItem);

		menus.add(menuInventory);

		return menus;
	}

}
