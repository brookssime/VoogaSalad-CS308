package engine;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import player.GameChoiceScreen;
import player.GamePlay;

public class Main extends Application {

	private GamePlay myPlayer;


	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Tuff Wizard");
		
		//OpenGameChoiceScreen
		GameChoiceScreen gcs = new GameChoiceScreen(stage,1400,800);
		//Set Game Choice Screen Scene
		stage.setScene(gcs.getScene());
		
		//myPlayer = new GamePlay( stage,1400,800);
		
		//stage.setScene(myPlayer.getScene()); //Fangyi: will this work?
		stage.setResizable(false);
		stage.show();
		//myPlayer.play();
		
		//Timeline animationTimeline = new Timeline();
		//int frameRate = 1;
		//myPlayer.manageTimeline(animationTimeline, frameRate);	//see below for an implementation of this method	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
/*
STARTS and animates timeline. good template for Fangyi
	public void manageTimeline(Timeline animationTimeline, int frameRate) {
		myTimeline = animationTimeline;
		KeyFrame frame = getKeyFrame(frameRate);
		myTimeline.setCycleCount(Timeline.INDEFINITE);
		myTimeline.getKeyFrames().add(frame);
		myTimeline.play();	
	}*/
}