package image_drawer;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

//This entire file is part of my masterpiece.
//Negatu Asmamaw.

public class MainMenu extends MenuBar{
	
	public MainMenu(DrawingCanvas myCanvas){
		
		Menu setting = new Menu("Setting");
		Menu file = new Menu("File");
		
		MenuItem saveItem = new MenuItem("Save Image");
		MenuItem colorItem = new MenuItem("Pen Color");
		MenuItem canvasSizeItem = new MenuItem("Canvas Size");
		MenuItem penSizeItem = new MenuItem("Pen Size");

		setting.getItems().addAll(colorItem, canvasSizeItem, penSizeItem);
		file.getItems().addAll(saveItem);
		
		getMenus().addAll(file, setting);
		

		saveItem.setOnAction(e -> {
			SaveDialog save = new SaveDialog(myCanvas);
			save.start();
		});

		canvasSizeItem.setOnAction(e -> {
			SizeDialog size = new SizeDialog(myCanvas);
			size.start();
		});

		colorItem.setOnAction(e -> {
			ColorDialog color = new ColorDialog(myCanvas);
			color.start();
		});
		
		penSizeItem.setOnAction(e->{
			PenSize penSize = new PenSize(myCanvas);
			penSize.start();
		});
		
	}

}
