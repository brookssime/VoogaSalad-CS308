// This entire file is part of my masterpiece.
// Patrick Wickham
package interfaces;

import java.util.List;
import engine.Path;
import engine.sprites.Tile;

/*
 * a functional interface to delegate the ability to make a Path based on a list of Tiles
 */
public interface MovementStrategy {
	
	Path generatePath(List<Tile> pathTiles);
	
}
