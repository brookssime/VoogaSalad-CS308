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
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridMaker {
	private GridPane tileGrid;
	private GridPane spriteGrid;
	private Receiver myReceiver;
	private Stage gridStage;
	private GridPane finishTG; //Final Tile grid
	private GridPane finishSG; //Final Sprite grid
	
	public GridMaker(Receiver r){
		myReceiver = r;
	}
	
	protected Node paneForGrid(Scene s, GridPane grid, Stage st){
		gridStage = st;
    	TabPane tabPane = new TabPane();
    	ScrollPane scrollPane = new ScrollPane();
    	ScrollPane scrollPane2 = new ScrollPane();
    	BorderPane bp1 = new BorderPane();
    	BorderPane bp2 = new BorderPane(); 
    	
        Tab tiles = new Tab("Tiles");
        tiles.setClosable(false);
        tileGrid = makeGrid(s, "Tile", grid); //This may not work
        Button tileDone = new Button("Tile Grid Done");
        tileDone.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	System.out.println("Tiles Done ");
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
        spriteGrid = makeGrid(s, "Base", grid); 
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
	
	private GridPane makeGrid(Scene s, String type, GridPane grid){
    	GridPane myGrid = new GridPane();
    	myGrid.prefHeightProperty().bind(s.heightProperty());
    	myGrid.prefWidthProperty().bind(s.widthProperty());
    	myGrid.setAlignment(Pos.CENTER);
    	myGrid.setPadding(new Insets(5));
    
    	//myGrid.getColumnConstraints().add(new ColumnConstraints(50));
    	//myGrid.getRowConstraints().add(new RowConstraints(50));
    	
    	System.out.println("My height3 " + grid.getHeight());
    	int height1 = (int) grid.getPrefHeight();
    	int width1 = (int) grid.getPrefWidth();
    	System.out.println("My width3 " + width1);
    	
    	if((height1==0) | (width1==0)){
    		myGrid.add(new Text("No valid size entries. Try again"), 0, 0);
    	}
    	else{
    		for(int r=0; r<height1; r++){
    			for(int c=0; c<width1; c++){
    				Node single = single(type);
    				myGrid.add(single, c, r);
    			}
    		}
    	}
    	return myGrid;
    }
	
	private Node single(String type) {
    	GridSingleSelect single = new GridSingleSelect();
    	
    	Set<String> mySet = myReceiver.getList(type); 
    	System.out.println("My set "+mySet.size());
    	
    	if(type.equals("Base")){
    		single.setUpEditor(mySet, type, true, myReceiver);
    	}
    	else{
    		single.setUpEditor(mySet, type, false, myReceiver);
    	}
        
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
