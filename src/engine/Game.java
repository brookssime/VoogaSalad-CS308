package engine;

import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
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
	private ArrayList<NodeState> myStates;
	private ArrayList<GameNode> myNexts;
	private ArrayList<Map<NodeState, GameNode>> myMap;
	private ArrayList<GameNode> myCurs;
	
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
	@SpecialEditorAnnotation(specialeditor=true, name = "addNodeState", fieldName = "myStates")
	public void addNodeState(NodeState nodeState){
		myStates.add(nodeState);
		buildMap();
		
	}
	
	private void buildMap() {
		if(myStates.size() == myNexts.size()){
			Map<NodeState, GameNode> map = new HashMap<>();
			map.put(myStates.get(myStates.size() - 1), myNexts.get(myNexts.size() - 1));
			myMap.add(map);
		}
		
	}

	/**
	 * Used in gae
	 * @param node
	 */
	@SpecialEditorAnnotation(specialeditor=true, name = "addNextNode", fieldName = "myNexts")
	public void addNextNode(GameNode node){
		myNexts.add(node);
		buildMap();
	}
	
	/**
	 * used in gae
	 * @param node
	 */
	@SpecialEditorAnnotation(specialeditor=true, name = "addCurNode", fieldName = "myCurs")
	public void addCurNode(GameNode node){
		myCurs.add(node);
		setAdjacencyList();
	}
	
	
	
	@MethodAnnotation(editor=true, name = "Game Editor", type = "game", fieldName = "")
	public void fakeMethod() {
		return;
	}

	public GameNode getCurNode() {
		return myCurNode;
	}

	private void setAdjacencyList(){
		if(myCurs.size() == myMap.size()){
			myAdjacencyList.put(myCurs.get(myCurs.size() - 1), myMap.get(myMap.size() - 1));
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

	@SpecialEditorAnnotation(specialeditor=true, name = "sethead", fieldName = "myStartNode")
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