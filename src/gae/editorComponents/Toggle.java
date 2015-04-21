package gae.editorComponents;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

/**
 * This class is to set up a toggle button for the editors This class can be
 * extended to add multiple buttons and group them together Possibly add a
 * persistent toggle group (where one button is always selected) in the future
 * 
 * @author ReyinaSenatus
 *
 */

public class Toggle {// TODO: Implement this with EditorComponent

	public Node toggleButton(String text) {
		ToggleButton tgb1 = new ToggleButton(text);
		return tgb1;
	}

	public List<Node> toggleGroups(List<String> texts) {
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
