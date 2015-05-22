package codeInterfaces;

import java.util.ArrayList;

public interface GameAuthor {
	
	
	/**
	 * Window
	 * 
	 * The window will hold objects outside of the game. An option to launch a new game
	 * will move the window to the workspace and sandbox environment. The name of the game
	 * is set through setGameName. The size of the window, which influences the complexity
	 * and determines the size of your game is also set here.
	 * 
	 */
	void launchGame();
	
	void setGameName(String s);
	
	void setWindowSize();
		
	
	/**
	 * gameScene
	 * 
	 * The level creator is the gameScene. When saved, it is another addition to the overall
	 * Game and each gameScene represents a step in the game. The scenes are stored in the
	 * sceneList, setScene allows for things like scene creation, deletion. SceneID is the
	 * name associated with each scene. UpdateScene allows for modification of the scene as
	 * it is being created. Finally, loadScene allows previously created scenes will be
	 * able to be uploaded to the game authoring environment to be further modified.
	 * 
	 */

	ArrayList<gameScene> sceneList();
	
	void setScene(gameScene gs);
	
	String sceneID(String s);
	
	gameScene updateScene(gameObject g);
	
	void loadScene();
	
	
	/**
	 * Workspace
	 * 
	 * The Workspace consists of the tabs that contain the list of gameObjects to choose from
	 * and create from scratch as well as the resources that are created from gameObject as final
	 * options to be added to your game. Resource is essentially a library of created gameObjects.
	 */

	void setUpWorkspace(Workspace w);
	
	void Editor();
	
	void Resources();
	
	/**
	 * GameObject
	 * 
	 * Create, modify, and load gameObjects. GameObjects include towers, enemies, and 
	 * environmental data
	 */

	void createGameObject();
	void updateGameObject();
	void loadGameObject();
	
	/**
	 * Sandbox
	 * The scene before the scene, before anything is committed to a scene, the sandbox is the
	 * place to play with ideas, tweak the characteristics of your playable characters, and serve 
	 * as a placeholder should you choose to leave in the middle of a game and want to come
	 * back.
	 */

	Sandbox setNewSandbox();
	
	void saveSandbox();
	
	void loadSandbox();
	
	
	
}
