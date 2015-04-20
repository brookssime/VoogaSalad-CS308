package gae.editorpane;

import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import gae.BundleGrabber;
import gae.GAEPane;
import gae.menupane.MenuAdder;

/**
 * 
 * @author sunjeevdevulapalli
 *This is a temporary implementation of the Game Editor. It allows the user to set a name and initial scene
 *for the Game Player to begin playing. 
 */
public class GameEditor extends GAEPane{
	
	private final ResourceBundle myConfigs;

	public GameEditor(MenuAdder adder) {
		super(GameEditor.class.getSimpleName(), adder);
		myConfigs = BundleGrabber.grabBundle("configs", GameEditor.class.getSimpleName());
		myRoot.getChildren().add(addContent());
	}

	private VBox addContent() {
		VBox group = new VBox(30);
		group.setPadding(new Insets(25));
		
		HBox nameBox = new HBox();
		nameBox.getChildren().add(new Text(myConfigs.getString("name")));
		nameBox.getChildren().add(new TextField());
		group.getChildren().add(nameBox);
		
		Button button = new Button(myConfigs.getString("first_scene"));
		group.getChildren().add(button);
		button.setOnAction(e -> {
			System.out.println("Backend's Job!");
		});
		
		Button update = new Button("Update");
		group.getChildren().add(update);
		update.setOnAction(e -> {
			System.out.println("Backend's Job!");
		});
		return group;
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
