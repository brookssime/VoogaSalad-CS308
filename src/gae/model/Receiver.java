package gae.model;

import engine.Game;

public interface Receiver {
	
	public void add(String type);
	public void updateObject(String type, Object obj, Object...parmas);
	public void editObject(String type, Object obj);
	public void saveFile();
	public void exportFile(Game game);

}
