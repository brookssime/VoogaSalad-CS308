package interfaces;

import java.util.LinkedList;
import java.util.List;

import com.sun.javafx.geom.Point2D;

public interface EditableEnemy {
	
	Integer getSpeed();
	Integer getDamage();
	Integer getHealth();
	List<Integer> getWalkable();
	String getImageString();
	Point2D getLocation();
	LinkedList<Point2D> getPath();
	Integer getRad();
	

}
