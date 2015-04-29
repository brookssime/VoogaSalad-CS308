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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//TODO: Fix grid position
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
		
		//ACTUAL GRID EDITOR CODE
		Button gridDone = new Button("Create Grid");
		mainPane.add(gridDone, 1, 4);
		gridDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	Stage gridStage = new Stage();
                    	gridStage.setTitle("Make your grid");
                    	Group gridGroup = new Group();
                    	Scene gridScene = new Scene(gridGroup, myHeight*10, myWidth*10);
                    	//makeGrid(gridScene);
                    	gridGroup.getChildren().add(borderPane(gridScene));
                    	gridStage.setScene(gridScene);
                    	gridStage.show();
                    	System.out.println("Grid Created");
                    	
                    }
                });
		
        //NON-EDITOR CODE
		root.getChildren().add(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Node single() {
    	TestSingleSelect single = new TestSingleSelect();
    	single.setUpEditor();
		return single.root();
	}

    private Node borderPane(Scene s){
    	TabPane tabPane = new TabPane();
    	BorderPane borderPane = new BorderPane();
    	
        Tab tiles = new Tab("Tiles");
        tiles.setClosable(false);
        makeGrid(s);
        tiles.setContent(myGrid);
        tabPane.getTabs().add(tiles);
        
        Tab sprites = new Tab("Sprites");
        sprites.setClosable(false);
        makeGrid(s);
        sprites.setContent(myGrid);
        tabPane.getTabs().add(sprites);
       
        borderPane.prefHeightProperty().bind(s.heightProperty());
        borderPane.prefWidthProperty().bind(s.widthProperty());
        borderPane.setCenter(tabPane);
        return borderPane;
    }
    
	private void makeGrid(Scene s){
    	myGrid = new GridPane();
    	myGrid.prefHeightProperty().bind(s.heightProperty());
    	myGrid.prefWidthProperty().bind(s.widthProperty());
    	myGrid.setGridLinesVisible(true);
    	myGrid.setAlignment(Pos.CENTER);
    	myGrid.setPadding(new Insets(5));
    	
    	for(int r=0; r<myHeight; r++){
    		for(int c=0; c<myWidth; c++){
    			Node single = single();
    			myGrid.add(single, c, r);
    		}
    	}
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

