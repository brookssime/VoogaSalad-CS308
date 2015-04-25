package player.level;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.ImageCursor;

public class GridCell{
	private int row;
	private int col;
	private ImageView image;
	private StackPane myPane;
	private TowerOption toweroption;
	private boolean dropable;
	private String id;
	private boolean showOption;
	public void setPosition(int r, int c){
		row = r;
		col =c;
		
		
	}
	public GridCell(Image im, int r, int c){
		toweroption = new TowerOption();
		image = new ImageView(im);
		dropable = false;
		showOption  =false;
		init();
		
	}
	public void setSize(double width, double height){
		myPane = new StackPane();
		
		image.setFitHeight(height);
		image.setFitWidth(width);
		myPane.setMaxSize(width, height);
		image.setOnMouseClicked((MouseEvent e) ->{
			if(showOption ==false) return;
			System.out.println("show option");
			toweroption.setPos(40, -60);
			toweroption.getCircle().setCenterX(myPane.getScaleX()+40);
			toweroption.getCircle().setCenterY(myPane.getScaleY()+40);
			myPane.toFront();
			if(toweroption.getShown()){
				toweroption.hide();
			} else
			toweroption.show();
			
		//image.setClip(toweroption.getCircle());
			
		});
		
		
		myPane.getChildren().addAll(toweroption.getPane(),image);
	}
	public StackPane getPane(){
		return myPane;
	}
	public void init(){
		
		image.setOnDragDropped((DragEvent t) -> {
			 System.out.println("Drage dropped");
			 if(dropable ==false) return;
		   Dragboard db = t.getDragboard();
		   boolean success  = false;
		   if(db.hasImage()){
			   Image myImage = db.getImage();
			 image.setImage( myImage);
			   success = true;
			   showOption = true;
			   //ColorAdjust adjust = new ColorAdjust();
			   //adjust.setSaturation(-1.0);
		   }
		   if(db.hasString()){
			   id = db.getString();
		   }
		   t.setDropCompleted(success);
		   t.consume();
		});
		
		image.setOnDragOver((DragEvent event)->{
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		});
	}
	public void setDropable(boolean b) {
		dropable = b;
		
	}
}
