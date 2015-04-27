package engine.gameScreens;

import engine.NodeState;

/**
 * Currently a static title screen Animation can be added later.
 *
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class TitleScene extends GameNode {

	private String myTitlePicturePath;

	public TitleScene() {
		super();
	}

	@Override
	public void render() {
		// REVIEW: make sure these having nothing is fully functional
	}

	@Override
	public void update() {

	}

	@Override
	public NodeState checkState() {
		return NodeState.RUNNING;
	}


	public String getTitlePicturePath() {
		return myTitlePicturePath;
	}

	public void setTitlePicturePath(String path) {
		myTitlePicturePath = path;
	}

}