package codeInterfaces;

import java.util.ArrayList;

public interface GameAuthor {
	
	
	/**
	 * Window
	 */
	public void launchGame();
	
	public void setGameName(String s);
	
	public void setWindowSize();
		
	
	/**
	 * Scene
	 */
	
	public ArrayList<gameScene> sceneList();
	
	public gameScene setNewScene(gameScene gs);
	
	public Integer sceneID();
	
	public gameScene addToScene(gameObject g);
	
	/**
	 * Workspace
	 */
	
	public void setUpWorkspace(Workspace w);
	
	public void Editor();
	
	public void Resources();
	
}
