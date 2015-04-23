package player;

import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.DragEvent;

import java.util.Observable;
import java.util.Observer;

public class GraphicTower implements Observer{
	private final Image previewImage;
    private final Image activeImage;
    private final Image equippedImage;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    private static final double IMAGESIZE =  80*(RunGamePlayer.screenHeight/877);
    
    private final ImageView currentImage;
    
    public void putOn() {
        currentImage.setImage(equippedImage);
    }
    
    public void takeOff() {
        currentImage.setImage(previewImage);
    }
    
    private void activate() {
        currentImage.setImage(activeImage);
    }
    
    public String getImageViewId() {
        return currentImage.getId();
    }
    
    public Node getNode() {
        return currentImage;
    }
    
    public GraphicTower(Image images , Node display) {
        this.previewImage = images;
        this.activeImage = images;
        this.equippedImage = images;
        
        currentImage = new ImageView(images);
        //currentImage.setImage(previewImage);
        currentImage.setId(this.getClass().getSimpleName() + System.currentTimeMillis());
        currentImage.setFitHeight(IMAGESIZE);
		currentImage.setFitWidth(IMAGESIZE);
		
		 currentImage.setOnDragDetected((MouseEvent event) -> {
			 //orgSceneX = event.getSceneX();
	           // orgSceneY = event.getSceneY();
	            //orgTranslateX = ((ImageView)(event.getSource())).getTranslateX();
	            //orgTranslateY = ((ImageView)(event.getSource())).getTranslateY();
	        	
	            //activate();
			 	System.out.println("Drage Detected");
	            Dragboard db = currentImage.startDragAndDrop(TransferMode.MOVE);
	            ClipboardContent content = new ClipboardContent();
	            // Store node ID in order to know what is dragged.
	            content.putString(currentImage.getId());
	           
	            //Image myimage = new Image(images, IMAGESIZE,IMAGESIZE,false,false); 
	            //ImageCursor myCursor = new ImageCursor(myimage);
	            //myCursor.getBestSize(IMAGESIZE, IMAGESIZE);
	            //((Node) event.getSource()).setCursor(myCursor);
	            //((Node)event.getSource()).set
	            db.setDragView(images,7,7);
	            db.setContent(content);
	            event.consume();
	            //movingImage();
	        });
		 
		 currentImage.setOnDragOver((DragEvent event) -> {
			 //System.out.println("Drage over");
			 //double offsetX = event.getSceneX() - orgSceneX;
	            //double offsetY = event.getSceneY() - orgSceneY;
	            //double newTranslateX = orgTranslateX + offsetX;
	            //double newTranslateY = orgTranslateY + offsetY;
	            //currentImage.setOpacity(0.7);
	            //currentImage.setTranslateX(newTranslateX);
	            //currentImage.setTranslateY(newTranslateY);
	           // if (event.getGestureSource() != itemPane &&
	           //         event.getDragboard().hasString()) {
	            //    event.acceptTransferModes(TransferMode.MOVE);
	            //}
	            event.consume();
	        });  
	        
		 
		 currentImage.setOnDragDropped((DragEvent event) -> {
	            //activate();
			 	System.out.println("Drage drop");
	            Dragboard db = currentImage.startDragAndDrop(TransferMode.MOVE);
	            ClipboardContent content = new ClipboardContent();
	            // Store node ID in order to know what is dragged.
	            content.putString(currentImage.getId());
	            db.setContent(content);
	            event.consume();
	        });
	        
		 /*
       
        currentImage.setOnMouseMoved((MouseEvent event) -> {
        	System.out.println("mouse moving");
            //activate();
            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            currentImage.setOpacity(0.7);
            //currentImage.setTranslateX(newTranslateX);
            //currentImage.setTranslateY(newTranslateY);
           
        });
        */
        
        //currentImage.setOnMouseDragExited();
       // currentImage.seton
//        
//      currentImage.setOnMouseDragReleased((MouseEvent t) -> {
//        	//System.out.println("finished drag");
//     //   	currentImage.setTranslateX(orgTranslateX);
//     //       currentImage.setTranslateY(orgTranslateY);
//        	
//        });
//        currentImage.setOnMouseReleased((MouseEvent t) -> {
//        	System.out.println("finished drag");
//        	currentImage.setTranslateX(orgTranslateX);
//            currentImage.setTranslateY(orgTranslateY);
//        	
//        });
//        
//        currentImage.setOnMousePressed((MouseEvent t) -> {
//        	orgSceneX = t.getSceneX();
//            orgSceneY = t.getSceneY();
//            orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
//            orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
//        	
//        }
//        		);
        /*
        currentImage.setOnMouseDragged(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent mouseEvent){
        		currentImage.setLayoutX(mouseEvent.getSceneX());
        		currentImage.setLayoutX(mouseEvent.getSceneY());
        	}
        });
        */
        
    }

	private void movingImage() {
		
		  currentImage.setOnMouseMoved((MouseEvent event) -> {
	        	System.out.println("mouse moving");
	            //activate();
	            double offsetX = event.getSceneX() - orgSceneX;
	            double offsetY = event.getSceneY() - orgSceneY;
	            double newTranslateX = orgTranslateX + offsetX;
	            double newTranslateY = orgTranslateY + offsetY;
	            currentImage.setOpacity(0.7);
	            //currentImage.setTranslateX(newTranslateX);
	            //currentImage.setTranslateY(newTranslateY);
	           
	        });
		  /*
		 currentImage.setOnMouseDragged((MouseEvent event) -> {
	        	System.out.println("mouse dragging");
	            //activate();
	            double offsetX = event.getSceneX() - orgSceneX;
	            double offsetY = event.getSceneY() - orgSceneY;
	            double newTranslateX = orgTranslateX + offsetX;
	            double newTranslateY = orgTranslateY + offsetY;
	            currentImage.setOpacity(0.7);
	            //currentImage.setTranslateX(newTranslateX);
	            //currentImage.setTranslateY(newTranslateY);
	           
	        });
	        */
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
