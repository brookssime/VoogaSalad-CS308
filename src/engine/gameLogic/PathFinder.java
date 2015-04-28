package engine.gameLogic;

import interfaces.Collidable;
import interfaces.Shootable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import engine.Grid;
import engine.Path;
import engine.sprites.Enemy;
import engine.sprites.Projectile;
import engine.sprites.Tile;

public class PathFinder {
	
	private Grid myGrid;
	private HashMap<String, List<Tile>> myEnemyPaths; 
	// TODO this will be an issue when multiple enemies of the same type require different paths..
	// ie multiple different ports with the same waves-MAKE SURE that the same enemy out of different waves has a different name
	
	public PathFinder(Grid grid){
		myGrid = grid;
	}
	
	/**********Called by GridManager*********/
	
	public void setEnemyPath(Enemy enemy, Wave w){
		if(!myEnemyPaths.containsKey(enemy.getName()))
			myEnemyPaths.put(enemy.getName(), findEnemyPath(enemy, myGrid.getPortFor(w)));
		
		enemy.setPath(convertToPath(myEnemyPaths.get(enemy), enemy));
	}
	
	public Path target(Shootable s, Collidable c) {
		// TODO CREATE PROJECTILE PATH BETWEEN OBJECTS
		return null;
	}

	public void generateProjectile(Projectile projectile, Path path) {
		Projectile newP = new Projectile(projectile);
		newP.setPath(path);
		myGrid.placeSpriteAt(projectile, path.getNextPlacement());
	}
	
	/***********Helpers - Called locally******/
	
	private List<Tile> findEnemyPath(Enemy enemy, Tile port){
		Tile current = port;
		List<Tile> path = new LinkedList<Tile>();
		boolean pathFound = false;
		while(!pathFound){
			path.add(current);
			current = findNextTile(path, enemy);	
			if (current == null){ // perhaps give Tile a way to check if it has a Tower on it...?
				pathFound = true;
				
			}
		}
		return path;
	}
	
	private Path convertToPath(List<Tile> tiles, Enemy enemy){
		
		return enemy.getMovement().generatePath(tiles);
		
	}

	private Tile findNextTile(List<Tile> path, Enemy enemy){
		Tile current = path.get(path.size()-1);
		for (Tile t: getTileNeighbors(current)){
			if(enemy.getWalkables().contains(t.getName()) && !path.contains(t)){
				return t;
			}
		}
		return null;
		// REVIEW
		// SHOULD return null if no next tile is found, or if this tile is a base..there is a null check in findPath	
	}
	
	private List<Tile> getTileNeighbors(Tile t){
		return myGrid.getTileNeighbors(t);	
	}

}

