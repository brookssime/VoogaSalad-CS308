package player.level;

public interface LevelPlay {
	void loadLevel();
	void pause();
	void resume();
	void speedUp();
	void slowDown();
	void win();
	void lose();
	void updateLevel();
	void startNextWave();
}
