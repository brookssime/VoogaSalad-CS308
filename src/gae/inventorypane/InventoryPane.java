package gae.inventorypane;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
//import javafx.collections.MapChangeListener;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import gae.GAEPane;
import gae.inventory.Inventory;
import gae.menupane.MenuAdder;
import gae.model.Receiver;
import engine.Tower;

/**
 * 
 * @author Peter
 * Displays the items in the inventory to the user in an easy-to-read way.
 *
 */
public class InventoryPane extends GAEPane {

	private static final String[] TYPES = { "Game", "LevelScene",
			"DialogueScene", "TitleScene", "Base", "Projectile", "Grid",
			"Wave", "Port", "Enemy", "Tower", "Tile", "Effect", "Range",
			"Store" };
	private Accordion myAccordion;
	private Receiver myReceiver;

	// private Map<String, Enemy> myEnemies;
	// private Map<String, Tower> myTowers;

	public InventoryPane(MenuAdder adder, Receiver rec) {
		super(InventoryPane.class.getSimpleName(), adder);
		setListeners();
		myAccordion = new Accordion();
//		myAccordion.maxHeightProperty().bind(arg0);
		myReceiver = rec;
		for (String type : TYPES) {
			myAccordion.getPanes().add(makePane(type));
		}
		myRoot.getChildren().add(myAccordion);
	}

	private TitledPane makePane(String type) {
		TitledPane pane = new TitledPane();
		pane.setText(type);
		ListView<String> list = new ListView<String>();
		myReceiver.setBind(type, list.itemsProperty());
		pane.setContent(list);
		return pane;
	}

	private TitledPane setupTiles() {
		TitledPane tilePane = new TitledPane();
		ListView<String> tileList = new ListView<String>();
		// tileList.setItems(myInventory.getTiles());
		// tileList.setCellFactory(new Callback<ListView<String>,
		// ListCell<String>>() {
		// @Override
		// public ListCell<String> call(ListView<String> list) {
		// return new SpriteCell();
		// }
		// });
		return tilePane;
	}

	private TitledPane setupTowers() {
		TitledPane towerPane = new TitledPane();
		towerPane.setText("Towers");
		ListView<String> towerList = new ListView<String>();
		// towerList.setItems();

		// towerList
		// .setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
		// @Override
		// public ListCell<String> call(ListView<String> list) {
		// return new SpriteCell();
		// }
		// });
		towerList.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {
					public void changed(ObservableValue<? extends String> ov,
							String old_val, String new_val) {
						// label.setText(new_val);
						// label.setTextFill(Color.web(new_val));
					}
				});

		// myInventory.addTowerListener(new MapChangeListener<String, Tower>() {
		//
		// @Override
		// public void onChanged(
		// javafx.collections.MapChangeListener.Change<? extends String, ?
		// extends Tower> arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// });
		return towerPane;
	}

	private TitledPane setupEnemies() {
		TitledPane enemyPane = new TitledPane();
		ListView<String> enemyList = new ListView<String>();
		// enemyList.setItems(myInventory.getEnemies());
		// enemyList
		// .setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
		// @Override
		// public ListCell<String> call(ListView<String> list) {
		// return new SpriteCell();
		// }
		// });
		// enemyList.itemsProperty().bind(myInventory.myEnemies);
		return enemyPane;
	}

	private void setListeners() {

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
	// static class SpriteCell extends ListCell<String> {
	// @Override
	// public void updateItem(String item, boolean empty) {
	// super.updateItem(item, empty);
	//
	// if (item != null) {
	// VBox vb = new VBox();
	// Tower sprite = myInventory.getTower(item);
	// vb.getChildren().add(new ImageView(sprite.getImageString()));
	// vb.getChildren().add(new Text(sprite.getName()));
	// setGraphic(vb);
	// }
	// }
	// }

}
