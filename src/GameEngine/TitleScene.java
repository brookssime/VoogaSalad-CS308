package GameEngine;

public class TitleScene extends GameScene{

	private boolean buttonClicked = false;
	private String myLogoPath;
	
	@Override
	public void update() {
		// animation? anything moving? 
		// maybe later
	}

	@Override
	public void checkComplete() {
		myHasCompleted = buttonClicked;
	}
	
	public void clickStart(){
		buttonClicked = true;
	}
	
	public String getLogoPath(){
		return myLogoPath;
	}
}