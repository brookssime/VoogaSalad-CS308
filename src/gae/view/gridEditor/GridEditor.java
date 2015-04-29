package gae.view.gridEditor;

import gae.model.Receiver;
import gae.view.editorpane.editorComponents.EditorComponent;
import interfaces.SpecialEditorAnnotation;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Grid Editor
 * Special editor that uses the editor components
 * Editor components used: 
 * 		single selector (for tiles -> path vs nature; for sprites)
 * 		text field (for width and height)
 * 		toggle button (for placing tiles vs sprites)
 * 		queue editor for waves
 * 
 * Currently, this will be it's own application until integrated with GAE pane		
 * Make the editor component nodes be added to the grid instead of the editor pane
 * 
 * @author ReyinaSenatus
 *
 */

//TODO: Make small editor things (except for queue)
//TODO: Make grid editor show up in inventory
//TODO: Figure out how to get created tiles and sprites
//TODO: Sprites used are base, port, tower, (tile)

//TODO: set up queue editor for waves
//TODO: Implement with editor components
//TODO: Return the correct info
//TODO: Change content of each tab to sprite or tile
public class GridEditor extends EditorComponent{
	private int myWidth;
	private int myHeight;
	private GridPane mainPane;
	private ArrayList<Method> mySpecialMethods;
	
	public GridEditor(Receiver receiver, Method method, String objectName) {
		super(receiver, method, objectName);
	}

	@Override
	public void setUpEditor() {
		Button b1 = new Button("Open Grid Editor");
		
		b1.setOnAction(e -> {
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Grid Editor");
			Group root = new Group();
			Scene scene = new Scene(root, 800, 800);
			mainPane = new GridPane();
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());
        
			root.getChildren().add(mainPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		});
		this.getChildren().add(b1);
        
		//get the annotations
        mySpecialMethods = new ArrayList<>(myReceiver.getSpecialEditorMethods(myObject));
	}
	
	
	
	private void gridSize(){
		Node width = width();
        mainPane.add(width, 1, 1);
		Node height = height();
		mainPane.add(height, 1, 2);
	}
	
	private Node height(){//TODO: use text field editor for this
		//TODO: Call the text field editor with your receiver, method, etc
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
	
    private Method getMethod(String name){
		for(Method method : mySpecialMethods){
			SpecialEditorAnnotation specialAnnotation = method
					.getAnnotation(SpecialEditorAnnotation.class);
			if(specialAnnotation.name().equals(name)){
				return method;
			}
		}
		return null;
	}

}
