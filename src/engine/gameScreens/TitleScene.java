package engine.gameScreens;

import engine.NodeState;

/**
 * Currently a static title screen Animation can be added later.
 *
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class TitleScene extends GameNode {

	// private String myName; Do we need this?
	private String myTitlePicturePath;

	public TitleScene() {
		super();
	}

	@Override
	public void render() {
		// TODO FILL IN WITH APPROPRIATE CALLS FOR TITLESCENE ONCE AVAILABLE

	}

	@Override
	public void update() {

	}

	@Override
	public NodeState checkState() {
		return myState;
	}

	/**
	 * Theoretically, this could apply to any button All buttons will lead away
	 * from this TitleScene to another scene It will just be a matter of setting
	 * the myNext of this scene after it is completed.
	 */
	public void exitButtonClicked() {
		myState = NodeState.COMPLETE;
	}

	public String getTitlePicturePath() {
		return myTitlePicturePath;
	}

	public void setTitlePicturePath(String path) {
		myTitlePicturePath = path;
	}

}