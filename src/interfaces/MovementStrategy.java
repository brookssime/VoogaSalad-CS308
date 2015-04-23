package interfaces;

import java.util.LinkedList;

import engine.Path;
import engine.gameLogic.Placement;
import engine.sprites.Tile;

public interface MovementStrategy {
	
	Path generatePath(LinkedList<Tile> pathTiles);

}
