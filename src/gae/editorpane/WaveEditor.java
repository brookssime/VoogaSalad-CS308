package gae.editorpane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class WaveEditor extends Pane{
	
	private VBox myFields;
	private Label myWaveName;
	private ListField myEnemys;
	private DelayFieldEditor myDelays;
	private Button export;
	
	
	
	public WaveEditor(String waveName){
		myFields = new VBox();
		myWaveName = new Label(waveName);
		myEnemys = new ListField("Enemys");
		myDelays = new DelayFieldEditor();
		export = new Button("Add Wave");
		export.setOnAction(e->{
			//ping the receiver/model here. 
		});
		
		myFields.getChildren().addAll(myWaveName, myEnemys, myDelays, export);
		getChildren().add(myFields);
		
	}
}
