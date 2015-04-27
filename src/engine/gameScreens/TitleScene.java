package engine.gameScreens;

import java.awt.Point;
import java.util.List;

import interfaces.MethodAnnotation;
import engine.NodeState;

/**
 * Currently a static title screen Animation can be added later.
 *
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class TitleScene extends GameNode {

	private String myBackgroundPicturePath;
	private String myTitleText;
	private Point myTitlePos = new Point();
	private String myTitleStyle;
	private List<NodeButton> myButtons;

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
	
	public List<NodeButton> getButtons() {
		return myButtons;
	}

	@MethodAnnotation(editor=true, name="Set Background Image", type="imageselect", fieldName="myBackgroundPicturePath")
	public void setBackgroundPicturePath(String path) {
		myBackgroundPicturePath = path;
	}
	
	@MethodAnnotation(editor=true, name="Set Title Text", type="textfield", fieldName="myTitleText")
	public void setTitleText(String text) {
		myTitleText = text;
	}
	
	@MethodAnnotation(editor=true, name="Set Title Position", type="something", fieldName="myTitlePos")
	public void setTitlePos(int x, int y) {
		myTitlePos.x = x;
		myTitlePos.y = y;
	}
	
	@MethodAnnotation(editor=true, name="Set Title Style", type="textfield", fieldName="myTitleStyle")
	public void setTitleStyle(String style) {
		myTitleStyle = style;
	}
	
	@MethodAnnotation(editor=true, name="Set Buttons", type="titlescreeneditor", fieldName="myButtons")
	public void setButtons(List<NodeButton> buttons) {
		myButtons = buttons;
	}
}