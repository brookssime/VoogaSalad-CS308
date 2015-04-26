package gae.editorComponents;

import gae.model.Receiver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * This class is to set up a toggle button for the editors This class can be
 * extended to add multiple buttons and group them together Possibly add a
 * persistent toggle group (where one button is always selected) in the future
 * 
 * @author ReyinaSenatus
 *
 */

public class ToggleEditor extends EditorComponent{
	private String text;
	private String[] texts;
	
	public ToggleEditor(Receiver receiver, Method setMethod, Method getMethod,String objectName) {
		super(receiver, setMethod, objectName);
		// TODO Auto-generated constructor stub
	}

	//@Override
	public void setUpEditor() {//TODO: Find a way to do this with string
			// TODO Auto-generated method stub
			HBox h = new HBox();
			h.getChildren().add(toggleButton());
			
	}
	
	public void toggleButtonParam(String myText){
		text = myText;
	}
	
	public void groupToggleParam(String[] myTexts){
		texts = new String[myTexts.length];
		texts = myTexts;
	}
		
	public Node toggleButton() {
		ToggleButton tgb1 = new ToggleButton(text);
		return tgb1;
	}
	
	private Node toggleButton(String s) {
		ToggleButton tgb1 = new ToggleButton(s);
		return tgb1;
	}

	public List<Node> toggleGroups() {
		List<Node> myGroupButtons = new ArrayList<Node>();
		int i = 0; // iterate through the booleans
		ToggleGroup myGroup = new ToggleGroup();

		for (String s : texts) {
			ToggleButton tgb = (ToggleButton) toggleButton(s);
			tgb.setToggleGroup(myGroup);
			myGroupButtons.add(tgb);
			i++;
		}

		return myGroupButtons;
	}

}
