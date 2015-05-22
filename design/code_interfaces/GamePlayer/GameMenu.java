
public interface GameMenu {
	void newGame();
	void detectSavedGame();
	void loadSavedGame(String gameFileName);
	void saveGame();
	
	void replayGame();
	void backToChooser();
	
	
}
