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
 * Editor for Effects of the Bases
 * @author ReyinaSenatus
 *
 */

public class EffectEditor extends GAEPane{
	private String myImagePath;
	private HelperEditor myHelper;
	
	public EffectEditor(String className, MenuAdder adder) {
		super(className, adder);
		myHelper = new HelperEditor();
		GridPane myGridPane = new GridPane();
		setContent(myGridPane);
		myRoot.getChildren().add(myGridPane);
	}

	private void setContent(GridPane myPane){
		double titleSize = 25;
		double textSize = 20;
		String[] labels = {"Edit your effect here", "Set Name: ",
				"Set Speed Damage: ", "Set Speed Frequenct: ", "Set Speed Reps: ",
				"Hold Speed Damage for (0 is forever): ", "Set Health Damage: ",
				"Set Health Frequency: ", "Set Health Reps: "};
		
		myHelper.paneSetUp(myPane);
		Text myTitle = myHelper.setText(labels[0], titleSize);
		myPane.add(myTitle, 0, 0);
		
		for(int i=1; i<labels.length; i++){
			int y = 2; //location of the text label
			Text myText = myHelper.setText(labels[i], textSize);
			myPane.add(myText, 0, y);
			y += 2;
		}
		
		//TODO: (int) Speed Damage
		//TODO: (Double) speedFrequency
		//TODO: (int) speedReps
		//TODO: (Double) holdSpeedDamageFor (0== Forever)
		//TODO: (int) Health Damage
		//TODO: (Double) healthFrequency
		//TODO: (int) healthReps
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
