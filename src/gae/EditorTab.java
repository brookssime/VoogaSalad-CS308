package gae;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class is testing the creation of tabs for the editor window
 * @author ReyinaSenatus
 *
 */


public class EditorTab extends Application{

	/*private Stage myStage;
	//private Display myDisplay;
	
	public void start(Stage stage) {
		this.inits(stage);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void inits(Stage stage) {
		myStage = stage;
		myStage.setTitle("Tab tester");
		//myDisplay = new Display();
		//myStage.setScene(myDisplay.init());
		myStage.show();
	}*/
	
	public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tabs");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        BorderPane borderPane = new BorderPane();
        for (int i = 0; i < 5; i++) {
            Tab tab = new Tab();
            tab.setText("Tab" + i);
            HBox hbox = new HBox();
            hbox.getChildren().add(new Label("Tab" + i));
            hbox.setAlignment(Pos.CENTER);
            tab.setContent(hbox);
            tabPane.getTabs().add(tab);
        }
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
