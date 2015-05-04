// This entire file is part of my masterpiece.
// Patrick Wickham
package engine;

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
	private String myReference;
	private NodeState myState;
	private GameNode myNext;
	private Map<NodeState, GameNode> myMap;
	private GameNode myCur;


	public Game(GameNode head) {
		myCurNode = head;
		myAdjacencyList = new HashMap<GameNode, Map<NodeState, GameNode>>();
		myIDMap = new HashMap<String, GameNode>();
		addStoreToLevel();
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
	
	public void advanceNode(NodeState state) {
		myCurNode = myAdjacencyList.get(myCurNode).get(state);
		myCurNode.refreshNodeButtons(null);
		myCurNode.render(myPlayerManager);
	}
	
	public void addStoreToLevel() {
		if (myCurNode instanceof LevelNode) {
			((LevelNode) myCurNode).setStore(myStore);
		}
	}
	/**
	 *  called by GAE
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
	
	private void setAdjacencyList(){
		if(myCur != null && myMap != null){
			if(myAdjacencyList == null){
				System.out.println("wtf");
			}
			myAdjacencyList.put(myCur, myMap);
			myCur = null;
			myMap = null;
		}
		System.out.println(myAdjacencyList);
	}

	/*
	 * called by Player
	 */
	
	public void setPlayerManager(PlayerManager playerManager){
		myPlayerManager = playerManager;
	}



	/*
	 * called by Controller
	 */
	public void goToNode(String nodeID) {
		myCurNode = myIDMap.get(nodeID);
		myCurNode.render(myPlayerManager);
	}

	public GameNode getCurNode() {
		return myCurNode;
	}
	
	

}