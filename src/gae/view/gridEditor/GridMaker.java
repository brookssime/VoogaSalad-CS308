// This entire file is part of my masterpiece.
// REYINA SENATUS

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
	private TabPane tabPane;
	
	public GridMaker(Receiver r){
		myReceiver = r;
	}
	
	protected Node paneForGrid(Scene s, GridPane grid, Stage st){
		gridStage = st;
    	tabPane = new TabPane();
    	
    	grid("Tile", grid, s); //Makes the tile grid
    	grid("Sprite", grid, s); //Makes the sprites grid
    	
        tabPane.prefHeightProperty().bind(s.heightProperty());
        tabPane.prefWidthProperty().bind(s.widthProperty());
        return tabPane;
    }
	
	private void grid(String str, GridPane grid, Scene s){
    	ScrollPane scrollPane = new ScrollPane();
    	BorderPane bp1 = new BorderPane();
        Tab t = new Tab(str);
        t.setClosable(false);
        if(str == "Tile"){
        	tileGrid = makeGrid(s, "Tile", grid); 
        }
        else{
        	spriteGrid = makeGrid(s, "Base", grid);
        }
        
        Button done = new Button(s + " Grid Done");
        done.setOnAction(e -> {
                    	System.out.println(s + "s Done ");
                    	if(tabPane.getTabs().size()>1){
                			tabPane.getTabs().remove(0);
                    	}
                    	else{
                    		gridStage.close();
                    		if(str == "Sprite"){
                    			finishSG = sprites();
                    		}
                    		else{
                    			finishTG = tiles();
                    		}
                    	}
                });
        
        bp1.setTop(done);
        scrollPane.setContent(tileGrid);
        bp1.setCenter(scrollPane);
        t.setContent(bp1);
        tabPane.getTabs().add(t);
	}
	
	private GridPane makeGrid(Scene s, String type, GridPane grid){
    	GridPane myGrid = new GridPane();
    	myGrid.prefHeightProperty().bind(s.heightProperty());
    	myGrid.prefWidthProperty().bind(s.widthProperty());
    	myGrid.setAlignment(Pos.CENTER);
    	myGrid.setPadding(new Insets(5));
    	
    	int height1 = (int) grid.getPrefHeight();
    	int width1 = (int) grid.getPrefWidth();
    	
    	myGrid.setAlignment(Pos.CENTER);
    	if((height1==0) | (width1==0)){
    		myGrid.add(new Text("No valid size entries. Try again"), 0, 0);
    	}
    	else{
    		for(int r=0; r<height1; r++){
    			for(int c=0; c<width1; c++){
    				ColumnConstraints column = new ColumnConstraints(25);
    				myGrid.getColumnConstraints().add(column);
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
