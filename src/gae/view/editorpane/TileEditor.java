package gae.view.editorpane;

import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author ReyinaSenatus
 * Allows the game designer to edit the tile in the Editor Pane.
 *
 */
public class TileEditor extends GAEPane{

	//TODO: FileImagePath -> String
	//TODO: Name -> String
	
	public TileEditor(String className, MenuAdder adder) {
		super(className, adder);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

