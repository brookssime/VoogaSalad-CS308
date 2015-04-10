package engine;

public class Grid {
	
	public Tile[][] myTiles;
	
	public Grid(int width, int height){
		myTiles = new Tile[width][height];
	}
	
	
	public void addTile(Tile t, int x, int y){
		myTiles[x][y] = t;
	}
	
	
}
