package player.level;

import player.manager.LevelManager;
import player.manager.PlayerManager;
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
import engine.sprites.Tile;

public class GridCell{
	private int row;
	private int col;
	private ImageView image;
	private StackPane myPane;
	private TowerOption toweroption;
	private boolean droppable;
	private String spriteID;  //the spriteID of tower which is on this cell
	private boolean showOption;
	private LevelManager myManager;
	private Tile myTile;
	public void setPosition(int r, int c){
		row = r;
		col =c;
		
		
	}
	public GridCell( Tile tile, int r, int c, LevelManager manager){
		myManager = manager;
		myTile = tile;
		System.out.println(tile.getImagePath());
		image = new ImageView();
		image.setImage(PlayerManager.myImageLoader.loadImageFile(tile.getImagePath()));
		
		droppable = false;
		showOption  =false;
		init();
		
	}
	public void setDroppable(String id){
		if(id.equals(myTile.getName())){
			droppable = true;
			
		}
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
		 //System.out.println("Drage dropped");
		image.setOnDragDropped((DragEvent t) -> {
			 System.out.println("Drage dropped");
			 if(droppable ==false) return;
		   Dragboard db = t.getDragboard();
		   boolean success  = false;
		   if(db.hasImage()){
			   Image myImage = db.getImage();
			 image.setImage( myImage);
			   success = true;
			   showOption = true;
			   //ColorAdjust adjust = new ColorAdjust();
			   //adjust.setSaturation(-1.0);
		   } else return;
		   int range = 100;
		   //if(db.hasUrl()){
			 //   range= Integer.parseInt(db.getUrl());
		   //} else return;
		   if(db.hasString()){
			   String[] info = db.getString().split(" ");
			   spriteID = info[0];
			   range = Integer.parseInt(info[1]);
			   Point p = new Point((int) myPane.getLayoutX(),(int) myPane.getLayoutY());
			   
			   Placement place = new Placement(p);

			   myManager.placeSprite(spriteID, place);
			   myManager.purchaseObject(spriteID);
			   toweroption = new TowerOption(myManager, spriteID, place, range);
			   image.setOnMouseClicked((MouseEvent x) ->{
					if(showOption ==false) return;
					System.out.println("show option");
					toweroption.setPos(40, -60);
					toweroption.getCircle().setCenterX(myPane.getScaleX()+40);
					toweroption.getCircle().setCenterY(myPane.getScaleY()+40);
					toweroption.setSell(e->{
						myManager.sellObject(spriteID, place);
						image.setImage(PlayerManager.myImageLoader.loadImageFile(myTile.getImagePath()));
								//new Image(myTile.getImagePath()));
						spriteID = null;
					});
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
		droppable = b;
		
	}
}
