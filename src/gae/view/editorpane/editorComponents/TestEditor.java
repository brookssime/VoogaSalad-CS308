package gae.view.editorpane.editorComponents;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestEditor extends Application {
	private int myWidth;
	private int myHeight;
	private GridPane mainPane;
	private GridPane myGrid;
	
    @Override
    public void start(Stage primaryStage) {
    	//NON-EDITOR CODE
        primaryStage.setTitle("Test GUI");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
        mainPane = new GridPane();
        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());
        
        //SETUP CODE TO TEST -> THESE ARE EDITOR COMPONENT THINGS
        Node width = width();
        mainPane.add(width, 1, 1);
		Node height = height();
		mainPane.add(height, 1, 2);
		mainPane.setGridLinesVisible(true);
		
		//ACTUAL GRID EDITOR CODE
		Button gridDone = new Button("Create Grid");
		mainPane.add(gridDone, 1, 3);
		gridDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	Stage gridStage = new Stage();
                    	gridStage.setTitle("Make your grid");
                    	Group gridGroup = new Group();
                    	Scene gridScene = new Scene(gridGroup, myHeight*2, myWidth*2);
                    	myGrid = new GridPane();
                    	myGrid.setPrefHeight(myHeight);
                    	myGrid.setPrefWidth(myWidth);
                    	myGrid.setGridLinesVisible(true);
                    	myGrid.add(new Text("Hi"), 0, 0);
                    	myGrid.add(new Text("Bye"), 100, 100);
                    	//TODO: add Hboxes to all grid tiles
                    	myGrid.setAlignment(Pos.CENTER);
                    	myGrid.setPadding(new Insets(5));
                    	//mainPane.add(myGrid, 1, 1);
                    	//root.getChildren().add(myGrid);
                    	gridGroup.getChildren().add(myGrid);
                    	gridStage.setScene(gridScene);
                    	gridStage.show();
                    	System.out.println("Grid Created");
                    	
                    }
                });
		
		/*myGrid = new GridPane();
    	myGrid.setPrefSize(500, 500);
    	myGrid.setGridLinesVisible(false);
    	mainPane.add(myGrid, 0, 0);*/
    	
        //NON-EDITOR CODE
		root.getChildren().add(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Node height(){
    	TestTextField text = new TestTextField();
    	text.setName("height");
    	text.setUpEditor();
    	text.btn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	String val = text.width.getCharacters().toString();
                    	myHeight = Integer.parseInt(val);
                    	System.out.println("My height: " + myHeight);
                    }
                });
    	return text.box();
    }
    
    private Node width(){
    	TestTextField text = new TestTextField();
    	text.setName("width");
    	text.setUpEditor();
    	
    	text.btn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	String val = text.width.getCharacters().toString();
                    	myWidth = Integer.parseInt(val);
                    	System.out.println("My width: " + myWidth);
                    }
                });
    	return text.box();
    }
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }


}

