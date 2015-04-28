package game_data;

import engine.Game;

public class TestGamesLoader {

	public static void main(String[] args) {
		GamesLoader gl = new GamesLoader();
		
		Game selectedGame = gl.getSelectedGame();
		
		if (selectedGame!=null){
			System.out.println(selectedGame.getName());
		}
		

	}

}
