package player.level;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.ImageCursor;

public class GridCell{
	private int row;
	private int col;
	private ImageView image;
	private boolean dropable;
	public void setPosition(int r, int c){
		row = r;
		col =c;
	}
	public GridCell(Image im, int r, int c){
		image = new ImageView(im);
		dropable = false;
		init();
		
	}
	public void setSize(double width, double height){
		image.setFitHeight(height);
		image.setFitWidth(width);
	}
	public ImageView getView(){
		return image;
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
			   //ColorAdjust adjust = new ColorAdjust();
			   //adjust.setSaturation(-1.0);
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
