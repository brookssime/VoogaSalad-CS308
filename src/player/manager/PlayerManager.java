// This entire file is part of my masterpiece.
// Sajal Kantha

package player.manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import engine.Game;
import engine.Grid;
import engine.HeadsUpDisplay;
import engine.Controller;
import engine.gameLogic.Placement;
import engine.gameScreens.DialogueBox;
import engine.gameScreens.NodeButton;
import engine.gameScreens.Store;
import engine.sprites.Tower;
import game_data.ImageLoader;
import game_data.SampleGameMain;
import game_data.XMLWriter;
import player.GameChoiceScreen;
import player.GraphicGameScene;
import player.MainMenu;
import player.dialogue.DialogScene;
import player.level.GameLevelScene;

/**
 * For controller to use, can be casted as interface updateview
 * 
 * @author Fangyi Chen, Sajal Kantha
 *
 */
public class PlayerManager implements DialogueManager, LevelManager, UpdateView {
	
	private GameLevelScene myLevel;
	private DialogScene myDialog;
	private Controller myController;
	private GraphicGameScene currScene;
	private Stage stage;
	private double screenWidth;
	private double screenHeight;
	private Game currGame;
	public static ImageLoader myImageLoader;

	public PlayerManager(GameLevelScene level, DialogScene dialog,
			Controller controller) {
		myLevel = level;
		myDialog = dialog;
		myController = controller;
	}

	public PlayerManager(Stage stage, double screenWidth, double screenHeight) {
		this.stage = stage;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
	}

	private void init() {
		
		myLevel = new GameLevelScene(stage, screenWidth, screenHeight, this);
		myDialog = new DialogScene(stage, screenWidth, screenHeight, this);
		myController = new Controller(currGame, this);

	}

	public void setCurrGame(Game game) {
		currGame = game;

		init();
	}

	public void play() {
		myController.start();
	}

	public Scene getInitScene() {
		GameChoiceScreen gcs = new GameChoiceScreen(stage, screenWidth,
				screenHeight);
		createGameChoiceScreenButtons(gcs);
		Scene initScene = gcs.getScene();

		return initScene;
	}

	private void createGameChoiceScreenButtons(GameChoiceScreen gcs) {

		Button loadGame = gcs.getLoadButton();
		loadGame.setOnAction((event) -> {

			try {
				currGame = (Game) XMLWriter.LoadGameData();
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found: " + e);
			} catch (IOException e) {
				System.out.println("IOException: " + e);
			}

			if (currGame != null)
				System.out.println(currGame.getName());
			myController = new Controller(currGame, this);

		});

		Button newGame = gcs.getNewGameButton();
		newGame.setOnAction((event) -> {

			System.out.println("Do Something to start a New Game");

		});

	}

	public void moveToNode(String nodeID) {
		myController.moveToNode(nodeID);
	}

	@Override
	public void updateLevel(Grid grid, Store store, HeadsUpDisplay hud) {
		if (currScene != myLevel) {
			changeScene(myLevel);
		}

		myLevel.updateLevel(grid, store, hud);

	}

	private void changeScene(GraphicGameScene myScene) {
		currScene = myScene;
		stage.setScene(currScene.getScene());
		stage.show();

	}

	@Override
	public void updateDialogue(DialogueBox dialog) {
		if (currScene != myDialog) {
			changeScene(myDialog);
		}

		myDialog.displayDialog(dialog);

	}

	@Override
	public void displayError(String errormessage) {
		myLevel.displayError(errormessage);

	}

	@Override
	public void sellObject(String spriteID, Placement place) {
		Object[] params = { spriteID, place };

		try {
			myController.doSomething("sellObject", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void placeSprite(String spriteID, Placement place) {
		Object[] params = { spriteID, place };
		try {
			myController.doSomething("placeSprite", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void examinSprite(String spriteID, Placement place) {
		Object[] params = { spriteID, place };
		try {
			myController.doSomething("examinSprite", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void increaseGameSpeed() {
		Object[] params = {};
		try {
			myController.doSomething("increaseGameSpeed", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void decreaseGameSpeed() {
		Object[] params = {};
		try {
			myController.doSomething("decreaseGameSpeed", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void purchaseObject(String spriteID) {
		Object[] params = { spriteID };
		try {
			myController.doSomething("purchaseObject", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showNextDialogue() {
		Object[] params = {};
		try {
			myController.doSomething("showNextDialogue", params);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public void makeNodeButton(List<NodeButton> nodeButtons) {
		currScene.makeNodeButton(nodeButtons);
	}

}
