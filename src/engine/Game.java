package engine;


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

	public Game(GameNode head) {
		myStartNode = head;
		myAdjacencyList = new HashMap<GameNode, Map<NodeState, GameNode>>();
		myIDMap = new HashMap<String, GameNode>();
		addStoreToLevel();
	}

	public GameNode getCurNode() {
		return myCurNode;
	}

	public void advanceNode(NodeState state) {
		myCurNode = myAdjacencyList.get(myCurNode).get(state);
		myCurNode.render();
	}

	public void goToNode(String nodeID) {
		myCurNode = myIDMap.get(nodeID);
		myCurNode.render();
	}

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