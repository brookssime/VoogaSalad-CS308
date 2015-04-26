package engine.controller;


public abstract class Controller {

	/**
	 * Used after player has clicked on a button
	 * Takes player to a new node, whether that be a level, title, or dialogue
	 * The ID will be passed to the player by the model, likely by a set method
	 * The player should also be able to know the ID of the node that they are going to 
	 * @param screenID
	 */
	public void moveToNode(String nodeID){
		
	}
	
	public abstract void update();
	
}