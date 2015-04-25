package gae.view.editorpane;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;

/**
 * Editor for the enemies 
 * @author ReyinaSenatus
 *
 */

public class EnemyEditor extends GAEPane{
	
	private String myImagePath;
	private HelperEditor myHelper;
	
	public EnemyEditor(String className, MenuAdder adder) {
		super(className, adder);
		myHelper = new HelperEditor();
		GridPane myGridPane = new GridPane();
		setContent(myGridPane);
		myRoot.getChildren().add(myGridPane);
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setContent(GridPane myPane){
		double titleSize = 25;
		double textSize = 20;
		String[] myLabels = {"Edit your enemy here", "Set Image: ", "Set Name: ",
				"Set Health: ", "Set Walkable Tiles: ", "Set Speed: ", "Set Damage to base: "};
		
		myHelper.paneSetUp(myPane); //TODO:Make sure this works or make it return a node
		Text myTitle = myHelper.setText(myLabels[0], titleSize);
		myPane.add(myTitle, 0, 0);
		
		for(int i=1; i<myLabels.length; i++){
			int y = 2; //location of the text label
			Text myText = myHelper.setText(myLabels[i], textSize);
			myPane.add(myText, 0, y);
			y += 2;
		}
		
		//TODO: Image -> File Path
		//TODO: Name -> String
		//TODO: Health -> Integer
		//TODO: String[] -> names of walkable tile (make multiple text fields or parse them with comma)
		//TODO: speed -> int
		//TODO: int -> damage to base
		
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

	
}
