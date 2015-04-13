package engine;

import java.util.List;

import interfaces.Authorable;

/**
 * Currently a static title screen
 * Animation can be added later
 * @author Sid and Brooks and Rob and Patrick, oh my!
 *
 */
public class TitleScene extends GameScene implements Authorable{
	
	private String myName;
	private String myTitlePicturePath;
	private Boolean myButtonClicked;
	
	public TitleScene(){
		
	}
	
	@Override
	public void update() {
		myButtonClicked = false;
		myHasCompleted = false;
	}

	@Override
	public void checkComplete() {
		if(myButtonClicked){
			myHasCompleted = true;
		}
	}
	
	/**
	 * Theoretically, this could apply to any button
	 * All buttons will lead away from this TitleScene to another scene
	 * It will just be a matter of setting the myNext of this scene after it is completed
	 */
	public void buttonClicked(){
		myButtonClicked = true;
	}
	
	public String getTitlePicturePath(){
		return myTitlePicturePath;
	}

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}