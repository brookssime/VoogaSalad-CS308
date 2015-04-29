package player.level;


import player.RunGamePlayer;
import player.manager.PlayerManager;
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
	private String spriteID;
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
	private static final double IMAGESIZE =  80*(1400/877);
	private LevelInfo myLevelInfo;
	private Tower myTower;
	
	public TowerInfo(Tower t, LevelInfo info){
		
		//TODO: need get damage spriteID from Tower
		myTower = t;
		init(t.getImagePath(),t.getName(),t.getPrice(),t.getRange(), Integer.parseInt(t.getSpriteInfo().get("damage")), info);
		myLevelInfo = info;
		
	}
	
	public void init(String imageFile, String name,int price,  int range, int damage, LevelInfo levelinfo ){
		image = new StackPane();
		Image towerimage = PlayerManager.myImageLoader.loadImageFile(imageFile, IMAGESIZE);
				//new Image((getClass().getResourceAsStream(imageFile)),IMAGESIZE,IMAGESIZE,false,false);
		ImageView myimage = new ImageView(towerimage);
		myimage.setFitHeight(IMAGESIZE);
		myimage.setFitWidth(IMAGESIZE);
		image.getChildren().add(myimage);
		GraphicTower myTower = new GraphicTower(towerimage,display, levelinfo, this.myTower);
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
