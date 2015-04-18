package engine;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Tester {
	
	public static void main(String[] args){
		
		//testPathFinding();	
		//testTargeting();
	}
	
	private static ArrayList<Point> myTestPath = new ArrayList<Point>();
	
	/*public static void testPathFinding(){
		
		System.out.println("~~~~~PATHFINDING ALGORITHM~~~~~");
		Grid g = new Grid(10, 10);
		
		myTestPath.add(new Point(0, 0));
		myTestPath.add(new Point(1, 0));
		myTestPath.add(new Point(2, 0));
		myTestPath.add(new Point(2, 1));
		myTestPath.add(new Point(2, 2));
		myTestPath.add(new Point(2, 3));
		myTestPath.add(new Point(3, 3));
		myTestPath.add(new Point(4, 3));
		myTestPath.add(new Point(5, 3));
		myTestPath.add(new Point(6, 3)); 
		myTestPath.add(new Point(7, 3));
		myTestPath.add(new Point(8, 3));
		myTestPath.add(new Point(9, 3));
		
		ArrayList<Tile> myTiles = new ArrayList<Tile>();
		for(Point p : myTestPath)
			myTiles.add(new Tile(p.x, p.y));
		
		g.setPort(myTiles.get(0));
		
		for (Tile t : myTiles){
			t.setID((Integer)10);
			g.addTile(t, t.getX(), t.getY());
		}
		
		Enemy e = new Enemy();
		e.getWalkables().add(myTiles.get(0).getID());
		List<Tile> foundPath = g.myGridManager.findPath(e);
		e.setTilePath(g.myGridManager.findPath(e));
		
		System.out.println("TESTER PATH");
		for(Tile t : myTiles){
			System.out.print("("+t.getX()+ ", "+ t.getY()+") ");
		}
		
		System.out.println("\nFOUND PATH");
		for (Tile t: foundPath)
			System.out.print("(" + t.getX() + ", " + t.getY()+") ");
		
		for(int x = 0; x < myTiles.size(); x++){
			if(myTiles.get(x) != foundPath.get(x)){
				System.out.println("\nFAIL on step " + x);

			}
		}
		System.out.println("\n\nPATHS MATCH");
	}
	
	public static void testTargeting(){
		System.out.println("~~~~~TARGETING ALGORITHM~~~~~");
		
		Grid g = new Grid(10, 10);
		
		myTestPath.add(new Point(0, 0));
		myTestPath.add(new Point(1, 0));
		myTestPath.add(new Point(2, 0));
		myTestPath.add(new Point(2, 1));
		myTestPath.add(new Point(2, 2));
		myTestPath.add(new Point(2, 3));
		myTestPath.add(new Point(3, 3));
		myTestPath.add(new Point(4, 3));
		myTestPath.add(new Point(5, 3));
		myTestPath.add(new Point(6, 3)); 
		myTestPath.add(new Point(7, 3));
		myTestPath.add(new Point(8, 3));
		myTestPath.add(new Point(9, 3));
		
		ArrayList<Tile> myTiles = new ArrayList<Tile>();
		for(Point p : myTestPath)
			myTiles.add(new Tile(p.x, p.y));
		
		g.setPort(myTiles.get(0));
		
		for (Tile t : myTiles){
			t.setID((Integer)10);
			g.addTile(t, t.getX(), t.getY());
		}
		
		Tower t = new Tower(5, 2, 3);
		
		Enemy e = new Enemy();
		e.getWalkables().add(myTiles.get(0).getID());
		e.setTilePath(g.myGridManager.findPath(e));
		
		while(!e.getTilePath().isEmpty()){
			e.move();
			
			System.out.println(t.calculateShot(e));
			
		}
			
		
	}*/
}


