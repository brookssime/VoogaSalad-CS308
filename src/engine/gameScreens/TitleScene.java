package engine.gameScreens;

/**
 * Currently a static title screen
 * Animation can be added later.
 *
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class TitleScene extends GameScene{
	
	/** The my name. */
	private String myName;
	
	/** The my title picture path. */	
	private String myTitlePicturePath;

	/** The my button clicked. */
	private Boolean myButtonClicked;
	
	/**
	 * Instantiates a new title scene.
	 */
	public TitleScene(){
		
	}
	
	/* (non-Javadoc)
	 * @see engine.GameScene#update()
	 */
	@Override
	public void update() {
		myButtonClicked = false;
		//myHasCompleted = false;
	}

	/* (non-Javadoc)
	 * @see engine.GameScene#checkComplete()
	 */
	@Override
	public boolean isComplete(){
		if(myButtonClicked)
			return true;
		return false;
	}
	
	/*@Override
	public void checkComplete() {
		if(myButtonClicked){
			myHasCompleted = true;
		}
	}*/
	
	/**
	 * Theoretically, this could apply to any button
	 * All buttons will lead away from this TitleScene to another scene
	 * It will just be a matter of setting the myNext of this scene after it is completed.
	 */
	public void buttonClicked(){
		myButtonClicked = true;
	}
	
	/**
	 * Gets the title picture path.
	 *
	 * @return the title picture path
	 */
	public String getTitlePicturePath(){
		return myTitlePicturePath;
	}
	
	public void setTitlePicturePath(String path){
		myTitlePicturePath = path;
	}
}