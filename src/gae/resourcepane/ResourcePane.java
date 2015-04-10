package gae.resourcepane;

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
import engine.Tower;

public class ResourcePane extends GAEPane {

	private Accordion myAccordion;
	private static Inventory myInventory;

	// private Map<String, Enemy> myEnemies;
	// private Map<String, Tower> myTowers;

	public ResourcePane(MenuAdder adder, Inventory inven) {
		super(ResourcePane.class.getSimpleName(), adder);
		myInventory = inven;
		setListeners();
		myAccordion = new Accordion();
		myAccordion.getPanes().addAll(setupTiles(), setupTowers(),
				setupEnemies());
		myRoot.getChildren().add(myAccordion);
	}

	private TitledPane setupTiles() {
		TitledPane tilePane = new TitledPane();
		ListView<String> tileList = new ListView<String>();
		// tileList.setItems(myInventory.getTiles());
		tileList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> list) {
				return new SpriteCell();
			}
		});
		return tilePane;
	}

	private TitledPane setupTowers() {
		TitledPane towerPane = new TitledPane();
		ListView<String> towerList = new ListView<String>();
		towerList.setItems(myInventory.getTowers());
		

		towerList
				.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
					@Override
					public ListCell<String> call(ListView<String> list) {
						return new SpriteCell();
					}
				});
		towerList.getSelectionModel().selectedItemProperty().addListener(
	            new ChangeListener<String>() {
	                public void changed(ObservableValue<? extends String> ov, 
	                    String old_val, String new_val) {
//	                        label.setText(new_val);
//	                        label.setTextFill(Color.web(new_val));
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
		enemyList
				.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
					@Override
					public ListCell<String> call(ListView<String> list) {
						return new SpriteCell();
					}
				});
		// enemyList.itemsProperty().bind(myInventory.myEnemies);
		return enemyPane;
	}

	private void setListeners() {

	}

	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = new ArrayList<Menu>();

		Menu menuInventory = new Menu("Inventory");
		MenuItem newTowerMenuItem = new MenuItem("New Tower");
		
		menus.add(menuInventory);
		
		return menus;
	}

	static class SpriteCell extends ListCell<String> {
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);

			if (item != null) {
				VBox vb = new VBox();
				Tower sprite = myInventory.getTower(item);
				vb.getChildren().add(new ImageView(sprite.getImageString()));
				vb.getChildren().add(new Text(sprite.getName()));
				setGraphic(vb);
			}
		}
	}

}
