package player;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GraphicGrid implements Observer{
	private GridPane myGrid;
	private double screenWidth, screenHeight;
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public GraphicGrid(double screenWidth, double screenHeight){
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	public Node getNode(){
		myGrid = new GridPane();
		int grid[][] = {
				{1,1,2,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,0,0,0,0,0,0,0,0,0,0,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,3,1,1,1},

				
				
				
				
				
		};
		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[0].length; column++)
			{
				ImageView myImage = new ImageView();
				System.out.println(screenWidth);
				System.out.println(screenHeight);
				myImage.setFitWidth((80*screenWidth/1436));
				myImage.setFitHeight((80*(screenHeight/877)));
				String filename = "";
				if(grid[row][column]==1) filename = "../images/wall.png";
				if(grid[row][column]==2) filename = "../images/port.png";
				if(grid[row][column]==3) filename = "../images/home.png";
				if(grid[row][column]==0) filename = "../images/path.png";
				
				myImage.setImage(new  Image(getClass().getResourceAsStream(filename)));
				
				myGrid.add(myImage, column, row);
			}
		}
		return myGrid;
	}

}
