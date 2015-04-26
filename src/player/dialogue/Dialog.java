package player.dialogue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.*;

public class Dialog {
	private BorderPane myPane;
	private ImageView myImage;
	private TextFlow myTextFlow;
	private Text myText;
	public Dialog(){
		myText = new Text();
		myImage = new ImageView();
		myTextFlow = new TextFlow();
		myTextFlow.getChildren().add(myText);
		myPane = new BorderPane();
		myPane.setLeft(myImage);
		myPane.setBottom(myTextFlow);
	}
	public Dialog(String imagePath, String myText){
		this();
		updateDialog(imagePath, myText);
		
		
	}
	public void updateDialog(String imagePath, String text){
		myText.setText(text);
		myImage.setImage(new Image(imagePath));
	}
	
	public Node getDialog(){
		return myPane;
	}
}
