// This entire file is part of my masterpiece.
// SID GOPINATH

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
	
	private GameNode myStartNode;
	private GameNode myCurNode;
	private Store myStore;
	private Map<GameNode, Map<NodeState, GameNode>> myAdjacencyList;
	private Map<String, GameNode> myIDMap;
	private PlayerManager myPlayerManager;
	private String myReference;
	private NodeState myState;
	private GameNode myNext;
	private Map<NodeState, GameNode> myMap;
	private GameNode myCur;

	public Game() {
		myAdjacencyList = new HashMap<GameNode, Map<NodeState, GameNode>>();
		myIDMap = new HashMap<String, GameNode>();
	}
	
	public Game(GameNode head) {
		myStartNode = head;
		myAdjacencyList = new HashMap<GameNode, Map<NodeState, GameNode>>();
		myIDMap = new HashMap<String, GameNode>();
		addStoreToLevel();
	}
	
	private void buildIDMap() {
		myIDMap.put(myReference, myCur);
	}
	
	private void buildMap() {
		Map<NodeState, GameNode> map = new HashMap<>();
		map.put(myState, myNext);
		myMap = map;	
	}
	
	public void setPlayerManager(PlayerManager playerManager){
		myPlayerManager = playerManager;
	}

	public void addStoreToLevel() {
		if (myStartNode instanceof LevelNode) {
			((LevelNode) myStartNode).setStore(myStore);
		}
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

	public GameNode getCurNode() {
		return myCurNode;
	}

	private void setAdjacencyList(){
		myAdjacencyList.put(myCur, myMap);
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

	public GameNode getHead(){
		return myCurNode;
	}

	/*****Used by GAE*****/
	@SpecialEditorAnnotation(specialeditor=true, name = "addReference", fieldName = "myReferences")
	public void addReference(String s){
		myReference = s;
		buildIDMap();
	}

	@SpecialEditorAnnotation(specialeditor=true, name = "addNodeState", fieldName = "myStates")
	public void addNodeState(NodeState nodeState){
		myState = nodeState;
		buildMap();
	}
	
	@MethodAnnotation(editor=true, name = "Grid Editor", type = "grid", fieldName = "")
	public void getGAEComponent() {
		return;
	}

	@SpecialEditorAnnotation(specialeditor=true, name = "addNextNode", fieldName = "myNexts")
	public void addNextNode(GameNode node){
		myNext = node;
		buildMap();
	}

	@SpecialEditorAnnotation(specialeditor=true, name = "addCurNode", fieldName = "myCurs")
	public void addCurNode(GameNode node){
		myCur = node;
		setAdjacencyList();
		buildIDMap();
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name = "setHead", fieldName = "myCurNode")
	public void setHead(GameNode head) {
		myCurNode = head;
	}
}