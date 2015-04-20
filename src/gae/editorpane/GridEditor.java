package gae.editorpane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Negatu
 * A temporary Grid Editor for the editor pane. Allows the game designer to edit different tiles in
 * a grid that will represent our Tower Defense Game.
 *
 */
public class GridEditor extends Pane{
	private HBox fieldEditor;
	private VBox myLayout;
	private GridTable myTable;
	private Button createGrid;
	private Label rows;
	private TextField rowField;
	private Label cols;
	private TextField colField;
	
	
	public GridEditor(){
		fieldEditor = new HBox();
		myLayout = new VBox();
		rows = new Label("Rows");
		rowField = new TextField();
		cols = new Label("Columns");
		colField = new TextField();
		createGrid = new Button("CreateGrid");
		createGrid.setOnAction(e->{
			createTable();
		});
		fieldEditor.getChildren().addAll(rows, rowField, cols, colField, createGrid);
		myLayout.getChildren().add(fieldEditor);
		getChildren().add(myLayout);
	}
	
	public void createTable(){
		int r = Integer.parseInt(rowField.getText());
		int c = Integer.parseInt(colField.getText());
		myTable = new GridTable(r, c);
		myLayout.getChildren().add(myTable);
	}
	

}
