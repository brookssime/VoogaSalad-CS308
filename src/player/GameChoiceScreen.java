package player;

import engine.Game;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameChoiceScreen {

	private double infoBoxWidthPct = .6;
	private double infoBoxHeightPct = .7;

	private double choiceBoxWidthPct = .2;
	private double choiceBoxHeightPct = .7;

	Pane root;
	Scene scene;

	private double screenWidth;
	private double screenHeight;

	private double infoBoxWidth;
	private double infoBoxHeight;

	private GameInfoBox gameInfoBox;
	private ExistingGameLoader gl;

	List<Game> availGames;

	public GameChoiceScreen(Stage stage, double screenWidth, double screenHeight){

		this.root = new Pane();
		root.setStyle("-fx-background-color: #708090;");
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		this.infoBoxWidth = infoBoxWidthPct * screenWidth;
		this.infoBoxHeight = infoBoxHeightPct * screenHeight;

		double choiceBoxWidth = choiceBoxWidthPct * screenWidth;
		double choiceBoxHeight = choiceBoxHeightPct * screenHeight;

		gl = new ExistingGameLoader();
		availGames = gl.getGameList();
		Game selectedGame = availGames.get(0);

		// GameData gameData = new GameData("Inital Name", "Inital Description",
		// "../resources/tower-defense-games.png");

		gameInfoBox = new GameInfoBox(stage, infoBoxWidth, infoBoxHeight,
				selectedGame);
		gameInfoBox.setLayoutX(.35 * screenWidth);
		gameInfoBox.setLayoutY(.25 * screenHeight);

		GameChoiceBox gameChoiceBox = new GameChoiceBox(choiceBoxWidth,
				choiceBoxHeight, gameInfoBox, availGames);
		gameChoiceBox.setLayoutX(.1 * screenWidth);
		gameChoiceBox.setLayoutY(.25 * screenHeight);

		Text txtTuff = new Text("Tuff");
		txtTuff.setFont(Font.font(null, FontWeight.BOLD, 72));
		txtTuff.setStyle("-fx-fill: linear-gradient(orange, orangered);");

		Text txtWizard = new Text("Wizard");
		txtWizard.setFont(Font.font(null, FontWeight.BOLD, 72));

		DropShadow dropShadow = new DropShadow();
		dropShadow.setColor(Color.DODGERBLUE);
		dropShadow.setRadius(25);
		dropShadow.setSpread(0.25);
		dropShadow.setBlurType(BlurType.GAUSSIAN);
		txtWizard.setEffect(dropShadow);

		root.getChildren().add(gameChoiceBox);
		root.getChildren().add(gameInfoBox);
		root.getChildren().add(txtWizard);
		root.getChildren().add(txtTuff);

		txtTuff.setId("Java");
		txtWizard.setId("FX2");
		HBox hb = new HBox();
		hb.getChildren().addAll(txtTuff, txtWizard);
		hb.setLayoutX(screenWidth * .5);
		hb.setLayoutY(.05 * screenHeight);

		root.getChildren().add(hb);

		Text text2 = new Text("Tower Defense");
		text2.setFont(Font.font(null, FontWeight.BOLD, 72));
		HBox hb2 = new HBox();
		hb2.setLayoutX(screenWidth * .45);
		hb2.setLayoutY(.125 * screenHeight);
		text2.setStyle("-fx-fill: linear-gradient(#0000ff, #000080);");
		text2.setStyle("linear-gradient(#ffea6a, #efaa22)");
		text2.setStyle("linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%)");
		text2.setStyle("linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));");
		//text2.setStyle( "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 10 );");
//                "linear-gradient(#ffea6a, #efaa22)",
//                "linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%)",
//                "linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
//        "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 10 );"
// }); 
		
		hb2.getChildren().add(text2);
		root.getChildren().add(hb2);
	}

	public Scene getScene() {
		scene = new Scene(root, screenWidth, screenHeight);
		return scene;
	}

	public Button getLoadButton() {
		Button loadButton = gameInfoBox.getLoadButton();
		return loadButton;
	}

	public Button getNewGameButton() {
		Button newGameButton = gameInfoBox.getNewGameButton();
		return newGameButton;
	}
}
