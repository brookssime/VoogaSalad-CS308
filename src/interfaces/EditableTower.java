package interfaces;

import java.util.List;

import com.sun.javafx.geom.Point2D;

public interface EditableTower {
	
	String setName();
	String setImageString();
	List<Integer> setAccessList();
	Integer setRange();
	Integer setFireRate();
	Point2D setLocation();
	Integer setHealth();
	Integer setRad();
	
}
