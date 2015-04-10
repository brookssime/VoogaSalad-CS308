package gae;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class is testing the creation of tabs for the editor window
 * @author ReyinaSenatus
 *
 */


public class EditorTab extends Application{
	private List<String> tabNames = new ArrayList<String>(); 
	private EnemyEditor myEditor = new EnemyEditor();
	//private EditableEnemy myEdit = new EditableEnemy();
	//private Method[] myMethods = new Method[];

	//private VBox myForm;
	
    @Override
    public void start(Stage primaryStage) {
    	tabNames = myEditor.getTabNames();
    	//myMethods = getMethods(myEdit);
    	
        primaryStage.setTitle("Editor Tabs");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800); //this will depend on the GAE's main interface

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        BorderPane borderPane = new BorderPane();
        
        for (int i=0; i<tabNames.size(); i++) {//TODO: Use lambda expressions (foreach)
            Tab tab = new Tab();
            tab.setText(tabNames.get(i));
            HBox hbox = new HBox();
           // VBox form = makeForm();
            hbox.getChildren().add(new Label("Tab" + i)); //what goes inside the tab
            TextField userTextField = new TextField();
            hbox.getChildren().add(userTextField);
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(20);
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
    
    private Method[] getMethods(Object o){
    	return o.getClass().getMethods();
    } 
    
   /* private VBox makeForm(){
    	VBox myForm = new VBox();
    	for (Method method : myMethods) {
			FieldEditor aFieldEditor = new FieldEditor(method, myEdit);
			myForm.getChildren().add(aFieldEditor);
		}
    	return myForm;
    }*/
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}
