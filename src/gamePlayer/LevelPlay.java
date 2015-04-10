package GamePlayer;

public interface LevelPlay {
	public void loadLevel();
	public void pause();
	public void resume();
	public void speedUp();
	public void slowDown();
	public void win();
	public void lose();
	public void updateLevel();
	public void startNextWave();
}
