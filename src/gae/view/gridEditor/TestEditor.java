package gae.view.gridEditor;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
                    	if(myHeight<50){
                    		gridStage.setHeight(500);
                    	}
                    	if(myWidth<50){
                    		gridStage.setWidth(500);
                    	}
                    	gridGroup.getChildren().add(paneForGrid(gridScene));
                    	gridStage.setScene(gridScene);
                    	gridStage.show();
                    	System.out.println("Grid Created");
                    	
                    }
                });
		Button waves = new Button("Make Wave Queue");
		//TODO: make wave queue stage
		
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

    private Node paneForGrid(Scene s){//TODO: Use 2 grids for sprites vs tiles
    	TabPane tabPane = new TabPane();
    	ScrollPane scrollPane = new ScrollPane();
    	ScrollPane scrollPane2 = new ScrollPane();
    	BorderPane bp1 = new BorderPane();
    	BorderPane bp2 = new BorderPane(); 
    	
        Tab tiles = new Tab("Tiles");
        tiles.setClosable(false);
        makeGrid(s);
        Button tileDone = gridDone();
        tileDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	System.out.println("Tiles Done ");
                    	//TODO: Iterate through the grid
                    }
                });
        bp1.setTop(tileDone);
        scrollPane.setContent(myGrid);
        bp1.setCenter(scrollPane);
        tiles.setContent(bp1);
        tabPane.getTabs().add(tiles);
        
        Tab sprites = new Tab("Sprites");
        sprites.setClosable(false);
        makeGrid(s);
        scrollPane2.setContent(myGrid);
        sprites.setContent(scrollPane2);
        tabPane.getTabs().add(sprites);
        
        tabPane.prefHeightProperty().bind(s.heightProperty());
        tabPane.prefWidthProperty().bind(s.widthProperty());
        //tabPane.setContent();
        return tabPane;
    }
    
	private void makeGrid(Scene s){
    	myGrid = new GridPane();
    	myGrid.prefHeightProperty().bind(s.heightProperty());
    	myGrid.prefWidthProperty().bind(s.widthProperty());
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
    
    private Button gridDone(){
    	Button done = new Button("Grid Done");
    	return done;
    }
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }


}

