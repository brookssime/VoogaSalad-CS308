package engine;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import player.GamePlay;

public class Main extends Application {

	private GamePlay myPlayer;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Tuff Wizard");
		myPlayer = new GamePlay( stage,1400,800);
		stage.setScene(myPlayer.getScene()); //Fangyi: will this work?
		stage.setResizable(false);
		stage.show();
		Timeline animationTimeline = new Timeline();
		int frameRate = 1;
		myPlayer.manageTimeline(animationTimeline, frameRate);	//see below for an implementation of this method	
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