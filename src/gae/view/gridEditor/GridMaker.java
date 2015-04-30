package gae.view.gridEditor;
/**
 * Helper class for gridEditor
 * Makes the grid 
 * 
 * @author ReyinaSenatus
 */
import gae.model.Receiver;

import java.util.HashSet;
import java.util.Set;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridMaker {
	private GridPane mainPane;
	private int height;
	private int width;
	private GridPane tileGrid;
	private GridPane spriteGrid;
	private Receiver myReceiver;
	private Stage gridStage;
	private GridPane finishTG; //Final Tile grid
	private GridPane finishSG; //Final Sprite grid
	
	protected void grid(GridPane p, int myHeight, int myWidth, Receiver r){
		myReceiver = r;
		height = myHeight;
		width = myWidth;
		mainPane = p;
		Button gridDone = new Button("Create Grid");
		mainPane.add(gridDone, 1, 4);
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
                    	else if(myWidth<50){
                    		gridStage.setWidth(500);
                    	}
                    	gridGroup.getChildren().add(paneForGrid(gridScene));
                    	gridStage.setScene(gridScene);
                    	gridStage.show();
                    	System.out.println("Grid Created");
                    	
                    }
                });
	}
	
	private Node paneForGrid(Scene s){
    	TabPane tabPane = new TabPane();
    	ScrollPane scrollPane = new ScrollPane();
    	ScrollPane scrollPane2 = new ScrollPane();
    	BorderPane bp1 = new BorderPane();
    	BorderPane bp2 = new BorderPane(); 
    	
        Tab tiles = new Tab("Tiles");
        tiles.setClosable(false);
        tileGrid = makeGrid(s, "Tile"); //This may not work
        Button tileDone = new Button("Tile Grid Done");
        tileDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	System.out.println("Tiles Done ");
                    	tabPane.getTabs().remove(0);
                    	if(tabPane.getTabs().size()>1){
                			tabPane.getTabs().remove(0);
                    	}
                    	else{
                    		gridStage.close();
                    		finishTG = tiles();
                    	}
                    }
                });
        bp1.setTop(tileDone);
        scrollPane.setContent(tileGrid);
        bp1.setCenter(scrollPane);
        tiles.setContent(bp1);
        tabPane.getTabs().add(tiles);
        
        
        Tab sprites = new Tab("Sprites");
        sprites.setClosable(false);
        spriteGrid = makeGrid(s, "Base"); //TODO: Not sure if will work
        Button spriteDone = new Button("Sprites Grid Done");
        spriteDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	System.out.println("Sprites Done ");
                    	if(tabPane.getTabs().size()>1){
                    			tabPane.getTabs().remove(1);
                    	}
                    	else{
                    		gridStage.close();
                    		finishSG = sprites();
                    	}
                    }
                });
        bp2.setTop(spriteDone);
        scrollPane2.setContent(spriteGrid);
        bp2.setCenter(scrollPane2);
        sprites.setContent(bp2);
        tabPane.getTabs().add(sprites);
        
        tabPane.prefHeightProperty().bind(s.heightProperty());
        tabPane.prefWidthProperty().bind(s.widthProperty());
        //tabPane.setContent();
        return tabPane;
    }
	
	private GridPane makeGrid(Scene s, String type){
    	GridPane myGrid = new GridPane();
    	myGrid.prefHeightProperty().bind(s.heightProperty());
    	myGrid.prefWidthProperty().bind(s.widthProperty());
    	myGrid.setAlignment(Pos.CENTER);
    	myGrid.setPadding(new Insets(5));
    	
    	if((height==0) | (width==0)){
    		myGrid.add(new Text("No valid size entries. Try again"), 0, 0);
    	}
    	else{
    		for(int r=0; r<height; r++){
    			for(int c=0; c<width; c++){
    				Node single = single(type);
    				myGrid.add(single, c, r);
    			}
    		}
    	}
    	return myGrid;
    }
	
	private Node single(String type) {//TODO: Get stuff from the receiver
    	TestSingleSelect single = new TestSingleSelect();
    	Set<String> mySet = (Set<String>) myReceiver.getList(type);
    	if(type=="Base"){
    		mySet.addAll((Set<String>) myReceiver.getList("Port"));
    		mySet.addAll((Set<String>) myReceiver.getList("Tower"));
    		//TODO: Not sure if above code with work
    	}
    	single.setUpEditor(mySet);
		return single.root();
	}
	
	protected GridPane sprites(){
		GridPane sg = spriteGrid;
		return sg;
	}
	
	protected GridPane tiles(){
		GridPane tg = tileGrid;
		return tg;
	}
	
}
