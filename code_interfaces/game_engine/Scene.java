package game_engine;

/**
 * The Scene interface will handle all of our "scenes"
 * These include the LevelScene, MenuScene, etc.
 * There are very few methods in this interface
 * These abstract methods mostly handle transitioning between scenes
 * @author Sid
 *
 */

public interface Scene {
	
	/*
	 * The isComplete() method will check if the Scene has finished
	 * If this is a level scene, for example, it will check if the last wave has finished
	 */
	protected abstract isComplete();
	
	/*
	 * The toGameOver() method will set the "myNext" instance variable of the Scene to the GameOver scene
	 * The Game will then see that the Scene isComplete() and will move to the next Scene, which has been set to GameOver
	 */
	protected abstract toGameOver();
	
	/*
	 * The getKeyFrame() method will be used to provide the GUI with a fresh image
	 * This will be particularly important when transitioning between two different levels or scenes
	 */
	protected abstract getKeyFrame();
	
}
