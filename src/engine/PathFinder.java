package engine;

import interfaces.Collidable;
import interfaces.Movable;
import interfaces.Shootable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PathFinder {
	
	//private Tile[][] myTiles;
	private Grid myGrid;
	private HashMap<String, Path> myEnemyPaths; 
	// this will be an issue when multiple enemies of the same type require different paths..
	// ie multiple different ports with the same waves
	
	public PathFinder(Grid grid){
		myGrid = grid;
	}
	
	//REFACTOR to make this a generic setPath()... for both enemies and projectiles
	void setEnemyPath(Enemy enemy, Wave w){
		if(!myEnemyPaths.containsKey(enemy.getName()))
			myEnemyPaths.put(enemy.getName(), findEnemyPath(enemy, myGrid.getPortFor(w)));
		
		enemy.setPath(myEnemyPaths.get(enemy.getName()));
	}
	

	
	public Path findEnemyPath(Enemy enemy, Tile port){
		Tile current = port;
		LinkedList<Tile> path = new LinkedList<Tile>();
		boolean pathFound = false;
		while(!pathFound){
			path.add(current);
			current = findNextTile(current, enemy);	
			if (current == null){ // perhaps give Tile a way to check if it has a Tower on it...?
				pathFound = true;
				
			}
		}
		return convertToPath(path);
	}
	
	private Path convertToPath(LinkedList<Tile> tiles){
		
		return null;
	}
	
	
	
	public Tile findNextTile(Tile current, Enemy enemy){
		for (Tile t: getTileNeighbors(current)){
			if(enemy.getWalkables().contains(t.getName()) && !enemy.getTilePath().contains(t)){
				enemy.getTilePath().add(t);
				return t;
			}
		}
		return null;
		// TODO
		// SHOULD return null if no next tile is found, or if this tile is a base..there is a null check in findPath	
	}
	
	public List<Tile> getTileNeighbors(Tile t){
		if (t == null)
			System.out.println("Grid.getTileNeighbors called with null Tile");
		int x = t.getX();
		int y = t.getY();
		List<Tile> neighbors = new ArrayList<Tile>();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for (int i = 0; i < dx.length; i++){
			if(x + dx[i] < myGrid.getTiles().length && 
					x + dx[i] >= 0 &&
					y + dy[i] < myGrid.getTiles()[0].length &&
					y + dy[i] >= 0){
				Tile temp = (myGrid.getTiles()[x + dx[i]][y + dy[i]]);
				neighbors.add(temp);
				//System.out.println(temp.getX() + ", " + temp.getY());
				
			}
		}
		
		/*neighbors.add(myTiles[x-1][y]);
		neighbors.add(myTiles[x+1][y]);
		neighbors.add(myTiles[x][y-1]);
		neighbors.add(myTiles[x][y+1]);
		//TODO
		*/
		
		return neighbors;
	}

	public Path target(Shootable s, Collidable c) {
		// TODO CREATE PROJECTILE PATH BETWEEN OBJECTS
		
		
		return null;
	}

	public void generateProjectile(Projectile projectile, Path path) {
		Projectile newP = new Projectile(projectile);
		newP.setPath(path);
		myGrid.placeGridObjectAt(projectile, path.getNext());
	}
	
	
	
	

}
