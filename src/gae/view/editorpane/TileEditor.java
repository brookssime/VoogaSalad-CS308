package gae.view.editorpane;

import java.util.List;

import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;
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
	private String myImagePath;
	private HelperEditor myHelper;
	
	public TileEditor(String className, MenuAdder adder) {
		super(className, adder);
		myHelper = new HelperEditor();
		GridPane myGridPane = new GridPane();
		setContent(myGridPane);
		myRoot.getChildren().add(myGridPane);
		}
	
	private void setContent(GridPane myPane){
		double titleSize = 25;
		double textSize = 20;
		String[] labels = {"Edit your tile here", "Set Image: ", "Set Name: "};
		
		myHelper.paneSetUp(myPane);
		Text myTitle = myHelper.setText(labels[0], titleSize);
		myPane.add(myTitle, 0, 0);
		
		for(int i=1; i<labels.length; i++){
			int y = 2; //location of the text label
			Text myText = myHelper.setText(labels[i], textSize);
			myPane.add(myText, 0, y);
			y += 2;
		}
		
		//TODO: FileImagePath -> String
		//TODO: Name -> String
		HBox myImageBox = myHelper.addImageButton("Choose Image: ");
		myPane.add(myImageBox, 1, 2);
		//TODO: Figure out how to use editor components
		
		Button save = myHelper.saveButton();
		myPane.add(save,  1, 12);
		save.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent e) {
                //TODO: Make this close the editor instead
            }
        });
	}
	

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

