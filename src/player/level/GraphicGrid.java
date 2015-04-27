package player.level;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import engine.Grid;
import engine.gameLogic.Placement;
import engine.sprites.Sprite;
import engine.sprites.Tile;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GraphicGrid{
	private GridPane myGrid;
	private StackPane myPane;
	private double screenWidth, screenHeight;
	
	public GraphicGrid(double screenWidth, double screenHeight){
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		myPane = new StackPane();
	}
	public Node getNode(){
		myGrid = new GridPane();
//		int grid[][] = {
//				{1,1,2,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,0,0,0,0,0,0,0,0,0,0,1,1,1},
//				{1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
//				{1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
//				{1,1,1,1,1,1,1,1,1,1,1,3,1,1,1},
//
//				
//				
//				
//				
//				
//		};
//		for (int row = 0; row < grid.length; row++)
//		{
//			for (int column = 0; column < grid[0].length; column++)
//			{
//				ImageView myImage = new ImageView();
//				//System.out.println(screenWidth);
//				//System.out.println(screenHeight);
//				
//				myImage.setFitWidth((80*screenWidth/1436));
//				myImage.setFitHeight((80*(screenHeight/877)));
//				String filename = "";
//				if(grid[row][column]==1) filename = "../../images/wall.png";
//				if(grid[row][column]==2) filename = "../../images/port.png";
//				if(grid[row][column]==3) filename = "../../images/home.png";
//				if(grid[row][column]==0) filename = "../../images/path.png";
//				GridCell c = new GridCell(new  Image(getClass().getResourceAsStream(filename)),row,column );
//				c.setSize(80*screenWidth/1436, 80*(screenHeight/877));
//				if(grid[row][column]==1) {
//					c.setDropable(true);
//				};
//				//myImage.setImage(new  Image(getClass().getResourceAsStream(filename)));
//				
//				myGrid.add(c.getPane(), column, row);
//			}
//		}
		myPane.getChildren().add(myGrid);
		return myPane;
	}
	
	public void updateGrid(Grid grid){
		if(grid == null) {
			System.out.println("null grid");
			return;
		}
		
		Tile[][] mytiles = grid.myTiles;
		if(mytiles == null) {
			System.out.println("null tiles");
			return;
		}
		for(int row = 0; row < mytiles.length;row ++){
			for(int col = 0; col < mytiles[0].length;col++){
				GridCell c= new GridCell(new Image(mytiles[row][col].getImagePath()),row,col);
				c.setSize(80*screenWidth/1436, 80*(screenHeight/877));
				//TODO: need a name for the place on which a tower can be placed
				if(mytiles[0][0].getName()=="walls"){
					c.setDropable(true);
				}
				myGrid.add(c.getPane(), col, row);
				
			}
		}
	}
	public void updateSprite(Map<Sprite, Placement> myMap) {
		myPane.getChildren().clear();
		myPane.getChildren().add(myGrid);
		for(Sprite mySprite : myMap.keySet()){
			setSprite(mySprite, myMap.get(mySprite));
		}
		
	}
	private void setSprite(Sprite mySprite, Placement placement) {
		Image image = new Image(mySprite.getImagePath());
		ImageView sprite = new ImageView(image);
		myPane.getChildren().add(sprite);
		sprite.setLayoutX(placement.getLocation().x);
		sprite.setLayoutY(placement.getLocation().y);
		
	}

}
