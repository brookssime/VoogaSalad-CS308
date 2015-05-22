
public interface GamePlay {
	int getMoney();
	int getScore();
	void updateMoney();
	void updateScore();
	Level loadLevel(int level);
}
