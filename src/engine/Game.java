package engine;

import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//used for constructing the adjacency list, all index based. 
	private String myReference;
	private NodeState myState;
	private GameNode myNext;
	private Map<NodeState, GameNode> myMap;
	private GameNode myCur;
	
	public Game() {
		
	}

	public Game(GameNode head) {
		myStartNode = head;
		myAdjacencyList = new HashMap<GameNode, Map<NodeState, GameNode>>();
		myIDMap = new HashMap<String, GameNode>();
		addStoreToLevel();
	}
	
	/**
	 * used for gae
	 * @param nodeState
	 */
	@SpecialEditorAnnotation(specialeditor=true, name = "addReference", fieldName = "myReferences")
	public void addReference(String s){
		myReference = s;
		buildIDMap();
	}
	
	private void buildIDMap() {
		if(myReference != null && myCur != null){
			myIDMap.put(myReference, myCur);
			myReference = null;
			myCur = null;
		}
		
	}

	/**
	 * used for gae
	 * @param nodeState
	 */
	@SpecialEditorAnnotation(specialeditor=true, name = "addNodeState", fieldName = "myStates")
	public void addNodeState(NodeState nodeState){
		myState = nodeState;
		buildMap();
		
	}
	
	private void buildMap() {
		if(myState != null && myNext != null){
			Map<NodeState, GameNode> map = new HashMap<>();
			map.put(myState, myNext);
			myMap = map;
			myState = null;
			myNext = null;
		}
		
	}

	/**
	 * Used in gae
	 * @param node
	 */
	@SpecialEditorAnnotation(specialeditor=true, name = "addNextNode", fieldName = "myNexts")
	public void addNextNode(GameNode node){
		myNext = node;
		buildMap();
	}
	
	/**
	 * used in gae
	 * @param node
	 */
	@SpecialEditorAnnotation(specialeditor=true, name = "addCurNode", fieldName = "myCurs")
	public void addCurNode(GameNode node){
		myCur = node;
		setAdjacencyList();
		buildIDMap();
	}
	
	
	
	@MethodAnnotation(editor=true, name = "Game Editor", type = "gameeditor", fieldName = "")
	public void fakeMethod() {
		return;
	}

	public GameNode getCurNode() {
		return myCurNode;
	}

	private void setAdjacencyList(){
		if(myCur != null && myMap != null){
			myAdjacencyList.put(myCur, myMap);
			myCur = null;
			myMap = null;
		}
	}
	
	public void setIDMap(Map<String, GameNode> idMap){
		myIDMap = idMap;
	}
	
	public void advanceNode(NodeState state) {
		myCurNode = myAdjacencyList.get(myCurNode).get(state);
		myCurNode.render();
	}

	public void goToNode(String nodeID) {
		myCurNode = myIDMap.get(nodeID);
		myCurNode.render();
	}

	@SpecialEditorAnnotation(specialeditor=true, name = "setHead", fieldName = "myStartNode")
	public void setHead(GameNode head) {
		myStartNode = head;
	}

	public GameNode getHead() {
		return myStartNode;
	}

	public void update(){
		myCurNode.update();
		if(myCurNode.checkState()!=NodeState.RUNNING){
			advanceNode(myCurNode.checkState());
		}
		else{
			myCurNode.render();
		}
	}
	// TODO: Check back on this
	public void addStoreToLevel() {
		if (myStartNode instanceof LevelNode) {
			((LevelNode) myStartNode).setStore(myStore);
		}
	}

}