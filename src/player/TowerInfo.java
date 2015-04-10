package player;


import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import engine.Tower;



public class TowerInfo{
	private Image image;
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
	
	public TowerInfo(Tower t){
		
	}
	
	public TowerInfo(String imageFile, String name,int price,  int range, int damage ){
		image = new Image((getClass().getResourceAsStream(imageFile)));
		this.name = name;
		this.price = price;
		this.range = range;
		this.damage = damage;
		display = new HBox();
		info = new VBox();
		nameLabel = new Label("name: "+name);
		priceLabel = new Label("price: "+price);
		rangeLabel = new Label("range: "+range);
		damageLabel = new Label("damage: "+damage);
		info.getChildren().addAll(nameLabel,priceLabel,rangeLabel,damageLabel);
		display.getChildren().addAll(new ImageView(image),info);
		
		
	}
	
	public Node getDisplay(){
		return display;
	}

	
}
