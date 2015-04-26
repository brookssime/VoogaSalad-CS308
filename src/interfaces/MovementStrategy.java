package interfaces;

import java.util.List;

import engine.Path;
import engine.sprites.Tile;

public interface MovementStrategy {
	
	Path generatePath(List<Tile> pathTiles);

}
