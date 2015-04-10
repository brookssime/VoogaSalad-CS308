package player;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import engine.Tower;



public class TowerInfo{
	private ImageView image;
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
	private static final int IMAGESIZE = 80;
	
	public TowerInfo(Tower t){
		
	}
	
	public TowerInfo(String imageFile, String name,int price,  int range, int damage ){
		image = new ImageView(new Image((getClass().getResourceAsStream(imageFile))));
		image.setFitHeight(IMAGESIZE);
		image.setFitWidth(IMAGESIZE);
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
