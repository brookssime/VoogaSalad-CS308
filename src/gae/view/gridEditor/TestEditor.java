package gae.view.gridEditor;

import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.KeyEvent;
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
	private Stage gridStage;
	
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
        mainPane.add(width, 10, 10);
		Node height = height();
		mainPane.add(height, 10, 20);
		
		//ACTUAL GRID EDITOR CODE
		Button gridDone = new Button("Create Grid");
		mainPane.add(gridDone, 10, 40);
		gridDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	gridStage = new Stage();
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
		
        //NON-EDITOR CODE
		root.getChildren().add(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Node single() {
    	GridSingleSelect single = new GridSingleSelect();
    	Set<String> mySet = new HashSet<String>();
    	mySet.add("1");
    	mySet.add("Five");

    	//single.setUpEditor(mySet);
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
        Button tileDone = new Button("Tile Grid Done");
        tileDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	System.out.println("Tiles Done ");
                    	//TODO: Iterate through the grid for tiles
                    	tabPane.getTabs().remove(0);
                    	if(tabPane.getTabs().size()>1){
                			tabPane.getTabs().remove(0);
                    	}
                    	else{
                    		gridStage.close();
                    	}
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
        Button spriteDone = new Button("Sprites Grid Done");
        spriteDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	System.out.println("Sprites Done ");
                    	//TODO: Iterate through the grid for sprites
                    	if(tabPane.getTabs().size()>1){
                    			tabPane.getTabs().remove(1);
                    	}
                    	else{
                    		gridStage.close();
                    	}
                    }
                });
        bp2.setTop(spriteDone);
        scrollPane2.setContent(myGrid);
        bp2.setCenter(scrollPane2);
        sprites.setContent(bp2);
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
    	
    	if((myHeight==0) | (myWidth==0)){
    		myGrid.add(new Text("No valid size entries. Try again"), 0, 0);
    	}
    	else{
    		for(int r=0; r<myHeight; r++){
    			for(int c=0; c<myWidth; c++){
    				Node single = single();
    				myGrid.add(single, c, r);
    			}
    		}
    	}
    }
    
    private Node height(){
    	GridTextField text = new GridTextField();
    	text.setName("height");
    	text.setUpEditor();
    	
    	text.btn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	String val = text.textVal.getCharacters().toString();
                    	myHeight = Integer.parseInt(val);
                    	System.out.println("My height: " + myHeight);
                    }
                });
    	
    	return text.box();
    }
    
    private Node width(){
    	GridTextField text = new GridTextField();
    	text.setName("width");
    	text.setUpEditor();
    	
    	text.btn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	String val = text.textVal.getCharacters().toString();
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

