package engine;

import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;

import java.util.HashMap;
import java.util.Map;

import player.manager.PlayerManager;
import engine.gameLogic.GameObject;
import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;


public class Game extends GameObject {
	
	private GameNode myCurNode;
	private Store myStore;
	private Map<GameNode, Map<NodeState, GameNode>> myAdjacencyList;
	private Map<String, GameNode> myIDMap;
    
	private PlayerManager myPlayerManager;
	
	public Game() {
		
	}

	public Game(GameNode head) {
		myCurNode = head;
		myAdjacencyList = new HashMap<GameNode, Map<NodeState, GameNode>>();
		myIDMap = new HashMap<String, GameNode>();
		addStoreToLevel();
	}
	
	@MethodAnnotation(editor=true, name = "Game Editor", type = "game", fieldName = "")
	public void fakeMethod() {
		return;
	}
	
	// To be called by Player
	public void setPlayerManager(PlayerManager playerManager){
		myPlayerManager = playerManager;
	}

	public GameNode getCurNode() {
		return myCurNode;
	}

	public void setAdjacencyList(Map<GameNode, Map<NodeState, GameNode>> adjList){
		myAdjacencyList = adjList;
	}
	
	public void setIDMap(Map<String, GameNode> idMap){
		myIDMap = idMap;
	}
	
	public void advanceNode(NodeState state) {
		myCurNode = myAdjacencyList.get(myCurNode).get(state);
		myCurNode.refreshNodeButtons(null);
		myCurNode.render(myPlayerManager);
	}

	public void goToNode(String nodeID) {
		myCurNode = myIDMap.get(nodeID);
		myCurNode.render(myPlayerManager);
	}

	@SpecialEditorAnnotation(specialeditor=true, name = "Set Head", fieldName = "myStartNode")
	public void setHead(GameNode head) {
		myCurNode = head;
	}


	public void update(){
		myCurNode.update();
		if(myCurNode.checkState()!=NodeState.RUNNING){
			advanceNode(myCurNode.checkState());
		}
		else{
			myCurNode.render(myPlayerManager);
		}
	}
	// TODO: Check back on this
	public void addStoreToLevel() {
		if (myCurNode instanceof LevelNode) {
			((LevelNode) myCurNode).setStore(myStore);
		}
	}

}