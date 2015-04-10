package gae.editorpane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GridEditor extends Pane{
	
	private String[][] myTiles;
	private Button createGrid;
	private Label rows;
	private Label cols;
	
	
	public GridEditor(){
		rows = new Label("Rows");
		cols = new Label("Columns");
		createGrid = new Button("CreateGrid");
		createGrid.setOnAction(e->{
			createTable();
		});
	}
	
	public void createTable(){
		int r = Integer.parseInt(rows.getText());
		int c = Integer.parseInt(cols.getText());
		myTiles = new String[r][c];
	}
	
	public void addTile(String tile, int x, int y){
		myTiles[x][y] = tile;
	}
	

}
