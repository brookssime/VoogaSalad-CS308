package engine;

import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;

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
	
	public Game() {
		
	}

	public Game(GameNode head) {
		myStartNode = head;
		myAdjacencyList = new HashMap<GameNode, Map<NodeState, GameNode>>();
		myIDMap = new HashMap<String, GameNode>();
		addStoreToLevel();
	}
	
	@MethodAnnotation(editor=true, name = "Game Editor", type = "game", fieldName = "")
	public void fakeMethod() {
		return;
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

	@SpecialEditorAnnotation(specialeditor=true, name = "Set Head", fieldName = "myStartNode")
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