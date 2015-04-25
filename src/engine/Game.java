package engine;


import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;


public class Game {

	private String myName;
	private final int FRAME_RATE = 10;	
	private GameNode myStartNode;
	private Store myStore;
	
	public Game(GameNode head){
		myStartNode = head;
		addStoreToLevel();
	}
	
	public void setHead(GameNode head){
		myStartNode = head;
	}
	
	public GameNode getHead(){
		return myStartNode;
	}
	
	/**
	 * This is pretty awful design
	 * Any ideas? Maybe a try/catch
	 */
	public void addStoreToLevel(){
		if(myStartNode instanceof LevelNode){
			((LevelNode) myStartNode).setStore(myStore);
		}
	}
	
	//TODO: Can this all be removed with our new framework of KeyFrame/game loop?
	//Fangyi will handle the game loop and creating the key frames
	//then he will call a method in the controller that calls the loop method in model
	
/*	public KeyFrame startGame(){
		return new KeyFrame(Duration.millis(FRAME_RATE * 10), e -> update());
	}
	
	public KeyFrame update(){
		if(sceneComplete()){
			myStartNode = myStartNode.getNextNode();
			addStoreToLevel();
			return myStartNode.start(FRAME_RATE);
		}
		return myStartNode.getCurScene();
	}*/

	public boolean sceneComplete(){
		return myStartNode.isComplete();
	}
}