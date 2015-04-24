package engine.gameScreens;

/**
 * Currently a static title screen
 * Animation can be added later.
 *
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class TitleScene extends GameNode{
	
	//private String myName; Do we need this?
	private String myTitlePicturePath;
	private Boolean myButtonClicked;
	
	public TitleScene(){
		
	}
	
	@Override
	public void update() {
		myButtonClicked = false;
	}

	@Override
	public boolean isComplete(){
		return myButtonClicked;
	}
	
	/**
	 * Theoretically, this could apply to any button
	 * All buttons will lead away from this TitleScene to another scene
	 * It will just be a matter of setting the myNext of this scene after it is completed.
	 */
	public void exitButtonClicked(){
		myButtonClicked = true;
	}
	
	public String getTitlePicturePath(){
		return myTitlePicturePath;
	}
	
	public void setTitlePicturePath(String path){
		myTitlePicturePath = path;
	}
}