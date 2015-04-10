package engine;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GridManager {
	
	private Grid myGrid;
	private HashMap<Integer, LinkedList<Tile>> myEnemyPaths;
	
	public GridManager(Grid g){
		myGrid = g;
	}
	

	private void setEnemyPath(Enemy enemy){
		if(myEnemyPaths.containsKey(enemy.getID()))
			enemy.setSteps(myEnemyPaths.get(enemy.getID()));
		else
			myEnemyPaths.put(enemy.getID(), (LinkedList)findPath(enemy));
	}

	
	public List<Tile> findPath(Enemy enemy){
		Tile current = myGrid.getPort();
		List<Tile> path = new LinkedList<Tile>();
		boolean pathFound = false;
		
		while(!pathFound){
			path.add(current);
			current = findNextTile(current, enemy);
			if (current == null) // perhaps give Tile a way to check if it has a Tower on it...?
				pathFound = true;
		}
		
		return path;
	}
	
	private Tile findNextTile(Tile current, Enemy enemy){
		
		// TODO
		// SHOULD return null if no next tile is found, or if this tile is a base..there is a null check in findPath
		
		return null;
	}
	
}
	
	
	
