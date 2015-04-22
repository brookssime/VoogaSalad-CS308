package player;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import engine.sprites.Tower;

/*
 * display the tower info such as price range damage and name
 * 
 */

public class TowerInfo{
	private StackPane image;
	private String name;
	private int price;
	private int range;
	private int damage;
	private HBox display;
	private VBox info;
	private Label nameLabel;
	private Label priceLabel;
	private Label rangeLabel;
	private Label damageLabel;
	private static final int LABELSPACING = 5;
	private static final double IMAGESIZE =  80*(RunGamePlayer.screenHeight/877);
	
	public TowerInfo(Tower t){
		
	}
	
	public TowerInfo(String imageFile, String name,int price,  int range, int damage ){
		image = new StackPane();
		Image towerimage = new Image((getClass().getResourceAsStream(imageFile)));
		ImageView myimage = new ImageView(towerimage);
		myimage.setFitHeight(IMAGESIZE);
		myimage.setFitWidth(IMAGESIZE);
		image.getChildren().add(myimage);
		GraphicTower myTower = new GraphicTower(towerimage,display);
		image.getChildren().add(myTower.getNode());
		this.name = name;
		this.price = price;
		this.range = range;
		this.damage = damage;
		display = new HBox();
		info = new VBox();
		info.setSpacing(LABELSPACING);
		nameLabel = new Label("name: "+name);
		priceLabel = new Label("price: "+price);
		rangeLabel = new Label("range: "+range);
		damageLabel = new Label("damage: "+damage);
		info.getChildren().addAll(nameLabel,priceLabel,rangeLabel,damageLabel);
		display.setSpacing(20);
		display.setPadding(new Insets(10,10,10,10));
		display.getChildren().addAll(image,info);
		
		
	}
	
	public Node getDisplay(){
		return display;
	}

	
}
