package engine.gameScreens;

import java.awt.Point;

import engine.gameLogic.GameObject;

public class NodeButton extends GameObject{
	
	private static final String DEFAULT_CSS = 
			"-fx-background-color: white;  -fx-padding: 30; -fx-border-color: black";
	
	public Point myLocation;
	public String myTargetNodeID;
	public String myInfo;
	public double myScale;
	public String myStyle;

	public NodeButton(){
		myStyle = DEFAULT_CSS;
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
	
	public void setScale(double scale){
		myScale = scale;
	}
	
	public double getScale(){
		return myScale;
	}
	
	public void setStyle(String css){
		myStyle = css;
	}
	
	public String getStyle(){
		return myStyle;
	}
	
	public String getDefaultStyle(){
		return DEFAULT_CSS;
	}
}
