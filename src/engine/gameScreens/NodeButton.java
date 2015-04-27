package engine.gameScreens;

import java.awt.Point;

import engine.gameLogic.GameObject;

public class NodeButton extends GameObject{
	
	public Point myLocation;
	public String myTargetNodeID;
	public String myInfo;

	public NodeButton(){
		
	}
	
	public Point getLocation() {
		return myLocation;
	}

	public void setLocation(Point location) {
		this.myLocation = location;
	}

	public String getInfo() {
		return myInfo;
	}


	public void setInfo(String info) {
		this.myInfo = info;
	}


	public String getTarget(){
		return myTargetNodeID;
	}
	
	public void setTarget(String target){
		myTargetNodeID = target;
	}
	
	public NodeButton clone(){
		NodeButton b = new NodeButton();
		b.myInfo = this.myInfo;
		b.myTargetNodeID = this.myTargetNodeID;
		b.myName = this.myName;
		return b;
		}
	
	
	
}
