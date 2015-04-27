package player.level;

import player.manager.LevelManager;
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

import java.awt.Point;

import engine.gameLogic.Placement;

public class GridCell{
	private int row;
	private int col;
	private ImageView image;
	private StackPane myPane;
	private TowerOption toweroption;
	private boolean dropable;
	private String spriteID;
	private boolean showOption;
	private LevelManager myManager;
	public void setPosition(int r, int c){
		row = r;
		col =c;
		
		
	}
	public GridCell(Image im, int r, int c){
		
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
		
		
		
		myPane.getChildren().addAll(image);
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
			   spriteID = db.getString();
			   Point p = new Point((int) myPane.getLayoutX(),(int) myPane.getLayoutY());
			   
			   Placement place = new Placement(p);
			   myManager.placeSprite(spriteID, place);
			   myManager.purchaseObject(spriteID);
			   toweroption = new TowerOption(myManager, spriteID, place);
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
					myPane.getChildren().add(toweroption.getPane());
					
				//image.setClip(toweroption.getCircle());
					
				});
			   
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
