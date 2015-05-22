package player;

public interface GameChooser {
	void detectGames();
	void displayDescription(String gameFileName);
	void loadNewGame(String gameFileName);
}
