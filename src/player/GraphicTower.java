package player;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
        currentImage.setOnMouseDragged((MouseEvent event) -> {
            activate();
            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            //currentImage.setFitHeight(100);
            currentImage.setOpacity(0.5);
            //currentImage.toFront();
            //currentImage.setMouseTransparent(true);
            //currentImage.setVisible(true);
            currentImage.setTranslateX(newTranslateX);
            currentImage.setTranslateY(newTranslateY);
            //currentImage.relocate(
            		//(int) event.getSceneX()-currentImage.getBoundsInLocal().getWidth()/2,
            		//(int) event.getSceneY()-currentImage.getBoundsInLocal().getHeight()/2);
            // Store node ID in order to know what is dragged.
            Dragboard db = currentImage.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(currentImage.getId());
            db.setContent(content);
            event.consume();
        });
        currentImage.setOnMousePressed((MouseEvent t) ->{
        	orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
            orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
        	
        }
        		);
        /*
        currentImage.setOnMouseDragged(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent mouseEvent){
        		currentImage.setLayoutX(mouseEvent.getSceneX());
        		currentImage.setLayoutX(mouseEvent.getSceneY());
        	}
        });
        */
        
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
