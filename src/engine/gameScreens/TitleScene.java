package engine.gameScreens;

import java.awt.Point;
import java.util.List;

import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;
import engine.NodeState;

public class TitleScene extends GameNode {

	private String myBackgroundPicturePath;
	private String myTitleText;
	private Point myTitlePos = new Point();
	private String myTitleStyle;
	private List<NodeButton> myButtons;

	public TitleScene() {
		super();
	}
	
	@MethodAnnotation(editor=true, name="Title Scene Editor", type="titlescene", fieldName="")
	public void fakeMethod() {
		return;
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
	
	public List<NodeButton> getButtons() {
		return myButtons;
	}

	@MethodAnnotation(editor=true, name = "Select Image", type = "imageselect", fieldName = "myImagePath")
	public void setBackgroundPicturePath(String path) {
		myBackgroundPicturePath = path;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Title Text", fieldName="myTitleText")
	public void setTitleText(String text) {
		myTitleText = text;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Title Position", fieldName="myTitlePos")
	public void setTitlePos(int x, int y) {
		myTitlePos.x = x;
		myTitlePos.y = y;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Title Style", fieldName="myTitleStyle")
	public void setTitleStyle(String style) {
		myTitleStyle = style;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Buttons", fieldName="myButtons")
	public void setButtons(List<NodeButton> buttons) {
		myButtons = buttons;
	}
}